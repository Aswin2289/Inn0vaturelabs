package com.innovature.HotelManagement.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.innovature.HotelManagement.form.FeedbackForm;

@Entity
public class feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedId;

    private String feedname;

    private String email;

    private String feedmsg;

    

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public feedback(){

    }

    public feedback(Integer feedId){
        this.feedId=feedId;
    }

    public feedback(String feedname,String email,String feedmsg,Integer userId,Date createDate){
        this.feedname=feedname;
        this.email = email;
        this.feedmsg=feedmsg;
        this.user=new User(userId);
        Date dt = new Date();
        this.createDate = dt;
    }

    public feedback(FeedbackForm form, Integer userId) {

        this.feedname=form.getFeedname();
        this.email = form.getEmail();
        this.feedmsg=form.getFeedmsg();
        this.user=new User(userId);
        Date dt = new Date();
        this.createDate = dt;
    }

    public Integer getFeedId() {
        return feedId;
    }

    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedmsg() {
        return feedmsg;
    }

    public void setFeedmsg(String feedmsg) {
        this.feedmsg = feedmsg;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFeedname() {
        return feedname;
    }

    public void setFeedname(String feedname) {
        this.feedname = feedname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   


    
}
