package com.innovature.HotelManagement.service;

public interface EmailService {
    boolean sendEmail(String subject, String message, String sentto);

    boolean sendBookEmail(String sentto);

    //boolean sendOtpEmail(String subject, String message, String sentto);

    // boolean sendEmail(String subject, String message, String sentto);
}
