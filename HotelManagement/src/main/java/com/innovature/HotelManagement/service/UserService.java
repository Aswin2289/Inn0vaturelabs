/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.HotelManagement.service;

import com.innovature.HotelManagement.entity.User;
import com.innovature.HotelManagement.exception.BadRequestException;
import com.innovature.HotelManagement.form.ChangepasswordForm;
import com.innovature.HotelManagement.form.LoginForm;
import com.innovature.HotelManagement.form.UserEditForm;
import com.innovature.HotelManagement.form.UserForm;
import com.innovature.HotelManagement.view.LoginView;
import com.innovature.HotelManagement.view.UserView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.validation.Errors;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;

/**
 *
 * @author nirmal
 */
public interface UserService {

    UserView add(UserForm form);

    UserView currentUser();

    LoginView login(LoginForm form, Errors errors) throws BadRequestException;

    LoginView refresh(String refreshToken) throws BadRequestException;

    Collection<User> list();
    Collection<User> listall();

    UserView edit(UserForm form);
    UserView updates(Integer userId, UserEditForm form);
    void deletes(Integer userId);

    void statusup(Integer userId);
    void userstatusup(Integer userId);

    // public APIResponse getUser(Pageable pageable){
    //     APIResponse apiresponse=new APIResponse();
    // }
    List<User>getUser(Integer pageNo,Integer pageSize,String firstName);
    Collection<User>getUser2(String first);

    UserView getpassword(ChangepasswordForm form);
    

}
