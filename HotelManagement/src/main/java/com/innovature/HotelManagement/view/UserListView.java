package com.innovature.HotelManagement.view;

import java.util.Date;

import com.innovature.HotelManagement.json.Json;
public class UserListView {
    private final int userId;
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String country;
    private final String email;
    private final int role;
    

    private final short UserStatus;
    private final short status;
    @Json.DateFormat
    private final Date dob;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateTimeFormat
    private final Date updateDate;


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
    public String getEmail() {
        return email;
    }
    public int getRole() {
        return role;
    }
    public short getStatus() {
        return status;
    }
    public Date getDob() {
        return dob;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    
    

    public UserListView(int userId,String firstName,String lastName,Date dob,String gender,String country,int role, String email,byte status,byte userstatus, Date createDate, Date updateDate){

        this.userId=userId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.dob=dob;
        this.gender=gender;
        this.country=country;
        this.role=role;
        this.email=email;
        this.UserStatus=userstatus;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public short getUserStatus() {
        return UserStatus;
    }
}
