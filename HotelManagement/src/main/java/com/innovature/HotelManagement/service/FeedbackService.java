package com.innovature.HotelManagement.service;

import java.util.Collection;

import com.innovature.HotelManagement.entity.feedback;
import com.innovature.HotelManagement.form.FeedbackForm;
import com.innovature.HotelManagement.view.FeedbackDetailView;
import com.innovature.HotelManagement.view.FeedbackListView;

public interface FeedbackService {
    FeedbackDetailView add(FeedbackForm form);
    Collection<feedback>list();
    
    Collection<FeedbackListView>list1();
}
