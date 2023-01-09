/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.HotelManagement.view;

import com.innovature.HotelManagement.entity.User;
import com.innovature.HotelManagement.json.Json;
import java.util.Date;


public class UserView {

    private final int userId;
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String country;
    private final String email;
    private final int role;
    

    private final short status;
    private final short UserStatus;
    @Json.DateFormat
    private final Date dob;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateTimeFormat
    private final Date updateDate;

    public UserView(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName=user.getLastName();
        this.dob=user.getDob();
        this.gender=user.getGender();
        this.country=user.getCountry();
        this.email = user.getEmail();
        this.role=user.getRole();
        this.status = user.getStatus();
        this.UserStatus=user.getUserStatus();
        this.createDate = user.getCreateDate();
        this.updateDate = user.getUpdateDate();
        
    }

    public int getRole() {
        return role;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public Date getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public short getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public short getUserStatus() {
        return UserStatus;
    }
    
}
