package com.innovature.HotelManagement.view;

import java.util.Date;

import org.hibernate.FetchMode;

public class FeedbackListView {

    private Integer feedId;

    private String feedname;

    private String email;

    private String feedmsg;

    

    @Json.DateTimeFormat
    private Date createDate;


    public FeedbackListView(Integer feedId){
        this.feedId=feedId;
    }

    public FeedbackListView(Integer feedId,String feedname,String email,String feedmsg,Date createDate){
        this.feedId=feedId;
        this.feedname=feedname;
        this.email=email;
        this.feedmsg=feedmsg;
        this.createDate=createDate;

    }

    public Integer getFeedId() {
        return feedId;
    }



    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
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

    
    
}
