package com.innovature.HotelManagement.repository;

import java.util.Collection;

import org.springframework.data.repository.Repository;

import com.innovature.HotelManagement.entity.feedback;
import com.innovature.HotelManagement.view.FeedbackListView;

public interface FeedbackRepository extends Repository<feedback, Integer>{

    feedback save(feedback feedback);
    Collection<feedback> findAll();
    feedback findById(Integer feedId);

    
    Collection<FeedbackListView> findAllByUserUserId(Integer userId);
    
}
