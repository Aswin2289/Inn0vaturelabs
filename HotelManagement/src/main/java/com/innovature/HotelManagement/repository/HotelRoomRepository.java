package com.innovature.HotelManagement.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.innovature.HotelManagement.entity.HotelRoom;
import com.innovature.HotelManagement.view.HotelRoomListView;

public interface HotelRoomRepository extends Repository<HotelRoom ,Integer>{
    
    // Collection<ContactListView> findAllByUserUserId(Integer userId);
    //Collection<HotelRoomListView> findAll();

    //HotelRoom save(HotelRoom hotelroom);
    HotelRoom save(HotelRoom hotelRoom);
    Collection<HotelRoom> findAll();
    Optional<HotelRoom>findById(Integer typeId);
    HotelRoom findByTypeId(Integer typeId);

}
