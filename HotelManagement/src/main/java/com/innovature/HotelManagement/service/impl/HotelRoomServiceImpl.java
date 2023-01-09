package com.innovature.HotelManagement.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovature.HotelManagement.entity.HotelRoom;
import com.innovature.HotelManagement.exception.NotFoundException;
import com.innovature.HotelManagement.form.HotelRoomForm;
import com.innovature.HotelManagement.repository.HotelRepository;
import com.innovature.HotelManagement.repository.HotelRoomRepository;
import com.innovature.HotelManagement.service.HotelRoomService;
import com.innovature.HotelManagement.view.HotelDetailView;
import com.innovature.HotelManagement.view.HotelRoomDetailView;
@Service
public class HotelRoomServiceImpl implements HotelRoomService{
    
    
    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    @Override
    public HotelRoomDetailView add(HotelRoomForm form){
         return new HotelRoomDetailView(hotelRoomRepository.save(new HotelRoom(form)));

    }

    @Override
    public Collection<HotelRoom>list(){
        return hotelRoomRepository.findAll();

   
    }

    @Override
    public HotelRoomDetailView get(Integer typeId) throws NotFoundException {
        return hotelRoomRepository.findById(typeId)
                .map((hotelroom) -> {
                    return new HotelRoomDetailView(hotelroom);
                }).orElseThrow(NotFoundException::new);
    }
}
