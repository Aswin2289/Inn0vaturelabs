package com.innovature.HotelManagement.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FeedbackForm {

    @Size(max=255)
    @NotBlank
    private String email;

    @Size(max=255)
    @NotBlank
    private String feedname;

    @Size(max=255)
    @NotBlank
    private String feedmsg;

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

    public String getFeedname() {
        return feedname;
    }

    public void setFeedname(String feedname) {
        this.feedname = feedname;
    }

    


    
}
