package com.innovature.HotelManagement.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovature.HotelManagement.entity.feedback;
import com.innovature.HotelManagement.form.FeedbackForm;
import com.innovature.HotelManagement.repository.FeedbackRepository;
import com.innovature.HotelManagement.security.util.SecurityUtil;
import com.innovature.HotelManagement.service.FeedbackService;
import com.innovature.HotelManagement.view.FeedbackDetailView;
import com.innovature.HotelManagement.view.FeedbackListView;

@Service
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    private FeedbackRepository feedbackRepository;

    public FeedbackDetailView add(FeedbackForm form){
        return new FeedbackDetailView(feedbackRepository.save(new feedback(form,SecurityUtil.getCurrentUserId())));
    }

    @Override
    public Collection<feedback>list(){
        return feedbackRepository.findAll();

   
    }

    @Override
    public Collection<FeedbackListView> list1() {
        return feedbackRepository.findAllByUserUserId(SecurityUtil.getCurrentUserId());
    }
    
}
