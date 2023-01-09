package com.innovature.HotelManagement.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.innovature.HotelManagement.entity.Hotel;
import com.innovature.HotelManagement.view.HotelListView;

public interface HotelRepository extends Repository<Hotel, Integer>{
    
    Hotel save (Hotel hotel);

    //Collection<HotelListView> findAll();
    Collection<Hotel> findAll();
    Optional<Hotel>findById(Integer hotelId);

    HotelListView findByhotelId(Integer hotelId);

    Hotel findByHotelId(Integer hotelId);

    void delete(Hotel hotel);

     Hotel findByHotelId(Hotel hotelId);
}
