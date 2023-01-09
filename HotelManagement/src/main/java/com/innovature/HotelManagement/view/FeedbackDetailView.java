package com.innovature.HotelManagement.view;

import com.innovature.HotelManagement.entity.feedback;

public class FeedbackDetailView extends FeedbackListView{
public FeedbackDetailView(feedback feed){
    super(
        feed.getFeedId(), 
        feed.getFeedname(), 
        feed.getEmail(), 
        feed.getFeedmsg(), 
        feed.getCreateDate()
        );
    }
    
}
