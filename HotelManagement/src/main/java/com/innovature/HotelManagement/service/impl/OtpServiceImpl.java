package com.innovature.HotelManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.innovature.HotelManagement.entity.Otp;
import com.innovature.HotelManagement.entity.User;
import com.innovature.HotelManagement.form.OtpForm;
import com.innovature.HotelManagement.repository.OtpRepository;
import com.innovature.HotelManagement.repository.UserRepository;
import com.innovature.HotelManagement.service.OtpService;


@Service
public class OtpServiceImpl implements OtpService{

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean add(OtpForm form){
        Otp otp=otpRepository.findByEmail(form.getEmail());
        User user=userRepository.findByEmailId(form.getEmail());
        if ((form.getOtp().equals(otp.getOtp()))) {

            if (form.getNewPassword().equals(form.getCnewPassword()))

            {
                
                user.setPassword(passwordEncoder.encode(form.getNewPassword()));
                userRepository.save(user);
                return true;
            } 
            return false;
            

        }
            return false;
    }
    
    
}
