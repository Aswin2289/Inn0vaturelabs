package com.innovature.HotelManagement.repository;

import java.util.Collection;

import org.springframework.data.repository.Repository;

import com.innovature.HotelManagement.entity.Otp;

public interface OtpRepository extends Repository<Otp, Integer>{
    Otp save( Otp otp);
    void deleteAll();
    Collection<Otp>findAll();

    Otp findByEmail(String email);
}
