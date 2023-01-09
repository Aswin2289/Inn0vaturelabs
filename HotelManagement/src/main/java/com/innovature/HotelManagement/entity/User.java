/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.HotelManagement.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;


@Entity
@Where(clause = "status=1")
public class User {

    public static enum Status {
        INACTIVE((byte) 0),
        ACTIVE((byte) 1);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }
    public static enum UserStatus {
        BLOCK((byte) 0),
        UNBLOCK((byte) 1);

        public final byte value;

        private UserStatus(byte value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String gender;
    

    private String country;
    private String email;
    private String password;
    private byte status;

    private byte userStatus;
    private int role;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(String firstName,String lastName,Date dob,String gender,String country,int role, String email, String password) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.dob=dob;
        this.gender=gender;
        this.country=country;
        this.role=role;
        this.email = email;
        this.password = password;
        
        this.status = Status.ACTIVE.value;
        this.userStatus = UserStatus.UNBLOCK.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }
    

    public User edit(String firstName,String lastName,Date dob,String gender,String country,int role, String email) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.dob=dob;
        this.gender=gender;
        this.country=country;
        this.role=role;
        this.email = email;
        // this.password = password;

        this.updateDate = new Date();
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }




    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return Objects.equals(this.userId, other.userId);
    }
    

    @Override
    public String toString() {
        return "com.innovature.HotelManagement.entity.User[ userId=" + userId + " ]";
    }

    public Byte getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(byte userStatus) {
        this.userStatus = userStatus;
    }
}
