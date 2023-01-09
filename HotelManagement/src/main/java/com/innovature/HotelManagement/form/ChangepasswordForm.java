package com.innovature.HotelManagement.form;

import javax.validation.constraints.NotBlank;

import com.innovature.HotelManagement.form.validaton.Password;

public class ChangepasswordForm {
    
    @Password
    private String password;

    @Password
    private String newPassword;

    @Password
    private String conPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConPassword() {
        return conPassword;
    }

    public void setConPassword(String conPassword) {
        this.conPassword = conPassword;
    }

    
    
}
