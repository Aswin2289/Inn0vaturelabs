package com.innovature.HotelManagement.service;

import java.util.Collection;

import com.innovature.HotelManagement.entity.HotelRoom;
import com.innovature.HotelManagement.exception.NotFoundException;
import com.innovature.HotelManagement.form.HotelRoomForm;
import com.innovature.HotelManagement.view.HotelDetailView;
import com.innovature.HotelManagement.view.HotelRoomDetailView;

public interface HotelRoomService {

    Collection<HotelRoom>list();
    //Collection<>list();
    HotelRoomDetailView add(HotelRoomForm form);
    HotelRoomDetailView get(Integer typeId) throws NotFoundException;
    

}
