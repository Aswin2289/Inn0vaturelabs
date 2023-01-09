/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.HotelManagement.service.impl;

import com.innovature.HotelManagement.entity.User;
import com.innovature.HotelManagement.exception.BadRequestException;
import com.innovature.HotelManagement.exception.NotFoundException;
import com.innovature.HotelManagement.form.ChangepasswordForm;
import com.innovature.HotelManagement.form.LoginForm;
import com.innovature.HotelManagement.form.UserEditForm;
import com.innovature.HotelManagement.form.UserForm;
import com.innovature.HotelManagement.repository.UserRepository;
import static com.innovature.HotelManagement.security.AccessTokenUserDetailsService.PURPOSE_ACCESS_TOKEN;
import com.innovature.HotelManagement.security.config.SecurityConfig;
import com.innovature.HotelManagement.security.util.InvalidTokenException;
import com.innovature.HotelManagement.security.util.SecurityUtil;
import com.innovature.HotelManagement.security.util.TokenExpiredException;
import com.innovature.HotelManagement.security.util.TokenGenerator;
import com.innovature.HotelManagement.security.util.TokenGenerator.Status;
import com.innovature.HotelManagement.security.util.TokenGenerator.Token;
import com.innovature.HotelManagement.service.UserService;
//import com.innovature.view.ContactListView;
import com.innovature.HotelManagement.view.LoginView;
import com.innovature.HotelManagement.view.UserView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

/**
 *
 * @author nirmal
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";

    @Autowired
    private PasswordEncoder passwordEncoder;

    

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public UserView add(UserForm form) {
        return new UserView(userRepository.save(new User(
                form.getFirstName(),
                form.getLastName(),
                form.getDob(),
                form.getGender(),
                form.getCountry(),
                form.getRole(),
                form.getEmail(),
                passwordEncoder.encode(form.getPassword())
        )));
    }

    @Override
    public UserView currentUser() {
        return new UserView(
                userRepository.findById(SecurityUtil.getCurrentUserId()).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public LoginView login(LoginForm form, Errors errors) throws BadRequestException {
        if (errors.hasErrors()) {
            throw badRequestException();
        }
        User user = userRepository.findByEmail(form.getEmail()).orElseThrow(UserServiceImpl::badRequestException);
        if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            throw badRequestException();
        }

        String id = String.format("%010d", user.getUserId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        Token refreshToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, id + user.getPassword(), securityConfig.getRefreshTokenExpiry());
        return new LoginView(user, accessToken, refreshToken);
    }

    @Override
    public LoginView refresh(String refreshToken) throws BadRequestException {
        Status status;
        try {
            status = tokenGenerator.verify(PURPOSE_REFRESH_TOKEN, refreshToken);
        } catch (InvalidTokenException e) {
            throw new BadRequestException("Invalid token", e);
        } catch (TokenExpiredException e) {
            throw new BadRequestException("Token expired", e);
        }

        int userId;
        try {
            userId = Integer.parseInt(status.data.substring(0, 10));
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid token", e);
        }

        String password = status.data.substring(10);

        User user = userRepository.findByUserIdAndPassword(userId, password).orElseThrow(UserServiceImpl::badRequestException);

        String id = String.format("%010d", user.getUserId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        return new LoginView(
                user,
                new LoginView.TokenView(accessToken.value, accessToken.expiry),
                new LoginView.TokenView(refreshToken, status.expiry)
        );
    }

    private static BadRequestException badRequestException() {
        return new BadRequestException("Invalid credentials");
    }

    @Override
    public Collection<User> listall() {
        return userRepository.findAll();
    }

    @Override
    public Collection<User>list(){
        return userRepository.findByRole(0);
    }
    @Override
    public UserView edit(UserForm form) {

        Integer userId=SecurityUtil.getCurrentUserId();

        User user=userRepository.findById(userId).orElseThrow(NotFoundException::new);

        user.edit(
            form.getFirstName(),
            form.getLastName(),
            form.getDob(),
            form.getGender(),
            form.getCountry(),
            form.getRole(), 
            form.getEmail(),   
            passwordEncoder.encode(form.getPassword())
        );

        return new UserView( userRepository.save(user));
    }
    @Override
    public UserView updates(Integer userId, UserEditForm form)  {

        User user=userRepository.findById(userId).orElseThrow(NotFoundException::new);

        user.edit(
            form.getFirstName(),
            form.getLastName(),
            form.getDob(),
            form.getGender(),
            form.getCountry(),
            form.getRole(), 
            form.getEmail()
            // passwordEncoder.encode(form.getPassword())
        );

        return new UserView( userRepository.save(user));
    }
    @Override
    public void deletes(Integer userId) throws NotFoundException {
        userRepository.delete(
                userRepository.findById(userId)
                        .orElseThrow(NotFoundException::new)
        );

    }

    @Override
    public List<User> getUser(Integer pageNo,Integer pageSize,String firstName){
        Pageable paging=PageRequest.of(pageNo-1, pageSize,Sort.by(firstName).ascending());
        Page<User> pagedResult=userRepository.findAllByRole(paging,0);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
            } 
        else 
        {
            return new ArrayList<User>();
        }
    }
    

    @Override
    public Collection<User>getUser2(String first){
        
        return userRepository.findAllUsers(first);
    }


    @Override
    @Transactional
    public UserView getpassword(ChangepasswordForm form){
        User user=userRepository.findByUserId(SecurityUtil.getCurrentUserId());
        if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            throw badRequestException();
        }
        else{
            if(form.getNewPassword().equals(form.getConPassword()))
            {
                user.setPassword(passwordEncoder.encode(form.getNewPassword()));
                System.out.println("success");
                return new UserView(user);
            }
        }
        return null;
    }
    @Override
    @Transactional
    public void statusup(Integer userId){
        User user=userRepository.findByUserId(userId);
        user.setStatus(User.Status.INACTIVE.value);
    }

    @Override
    @Transactional
    public void userstatusup(Integer userId){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        User user=userRepository.findByUserId(userId);
        //Byte status=user.getUserStatus();
        System.out.println("User Statis printing="+user.getUserStatus());
        if(user.getUserStatus()==0){
            user.setUserStatus(User.UserStatus.UNBLOCK.value);
        }
        else{
            user.setUserStatus(User.UserStatus.BLOCK.value);
        }
    }

}
