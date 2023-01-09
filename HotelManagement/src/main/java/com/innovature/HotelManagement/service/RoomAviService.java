package com.innovature.HotelManagement.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.innovature.HotelManagement.entity.RoomsAvi;
import com.innovature.HotelManagement.form.RoomAviForm;
import com.innovature.HotelManagement.view.RoomAviDetailView;

public interface RoomAviService {

    RoomAviDetailView add(RoomAviForm form);
    Collection<RoomsAvi>list();
    RoomAviDetailView updates(Integer roomAviId,@Valid RoomAviForm form);
    Collection<RoomsAvi>selroom(Integer hotelId);
    Collection<Object[]>Noroom(Integer hotelId,Integer typeId);

    int roomdata(Integer hotelId,Integer typeId);

    int bookedroom(Integer hotelId, Integer typeId);
    int bookedroomdec(Integer hotelId, Integer typeId);


    int mainavailable(Date check_in,Date check_out,Integer hotelId, Integer typeId);

}
