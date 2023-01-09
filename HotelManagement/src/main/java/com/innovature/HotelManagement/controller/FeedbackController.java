package com.innovature.HotelManagement.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovature.HotelManagement.entity.feedback;
import com.innovature.HotelManagement.form.FeedbackForm;
import com.innovature.HotelManagement.service.FeedbackService;
import com.innovature.HotelManagement.view.FeedbackDetailView;
import com.innovature.HotelManagement.view.FeedbackListView;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public FeedbackDetailView add(@Valid @RequestBody  FeedbackForm form) {
        
        return feedbackService.add(form);
    }
    @GetMapping
    public Collection<feedback>list(){
        return feedbackService.list();
    }
    
    @GetMapping("/id")
    public Collection<FeedbackListView>list1(){
        return feedbackService.list1();
    }
    
}
