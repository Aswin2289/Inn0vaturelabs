package com.innovature.HotelManagement.service;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpEntity;

import com.innovature.HotelManagement.entity.Hotel;
import com.innovature.HotelManagement.exception.NotFoundException;
import com.innovature.HotelManagement.form.HotelForm;
import com.innovature.HotelManagement.view.HotelDetailView;
import com.innovature.HotelManagement.view.HotelListView;

public interface HotelService {

    Collection<Hotel>list();

    HotelDetailView add(HotelForm form);
    HotelDetailView get(Integer hotelId) throws NotFoundException;
    HttpEntity<byte[]> getImagePic(Integer hotelId);
    void deletes(Integer hotelId);

    HotelDetailView updates(Integer hotelId, @Valid HotelForm form);
}
