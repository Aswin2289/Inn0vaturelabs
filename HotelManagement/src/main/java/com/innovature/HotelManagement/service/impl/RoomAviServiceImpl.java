package com.innovature.HotelManagement.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.solr.SolrProperties;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import com.innovature.HotelManagement.entity.RoomsAvi;
import com.innovature.HotelManagement.form.RoomAviForm;
import com.innovature.HotelManagement.repository.RoomAviRepository;
import com.innovature.HotelManagement.service.RoomAviService;
import com.innovature.HotelManagement.view.RoomAviDetailView;

@Service
public class RoomAviServiceImpl implements RoomAviService{

    @Autowired
    private RoomAviRepository roomAviRepository;

    @Override
    public RoomAviDetailView add(RoomAviForm form){
        return new RoomAviDetailView(roomAviRepository.save(new RoomsAvi(form)));
    }

    @Override
    public Collection<RoomsAvi>list(){
        return roomAviRepository.findAll();
    }

    @Override
    public RoomAviDetailView updates(Integer roomAviId,RoomAviForm form){
        RoomsAvi room=roomAviRepository.findById(roomAviId);
        room.edit(form);
        return new RoomAviDetailView(roomAviRepository.save(room));
        
    }

    @Override
    public Collection<RoomsAvi> selroom(Integer hotelId) {
        
        return roomAviRepository.selroom(hotelId);
    }
    @Override
    public Collection<Object[]> Noroom(Integer hotelId,Integer typeId) {

        return roomAviRepository.Noroom(hotelId,typeId);
    }
/////////////////////////////////////////////////////////////////////
    @Override
    public int roomdata(Integer hotelId,Integer typeId) {

        return roomAviRepository.roomdata(hotelId,typeId);
    }

    @Override
    public int bookedroom(Integer hotelId, Integer typeId){
        return roomAviRepository.bookedroom(hotelId,typeId);
    }

    @Override
    public int bookedroomdec(Integer hotelId, Integer typeId){
        return roomAviRepository.bookedroomdec(hotelId,typeId);
    }

    @Override
    public int mainavailable(Date check_in,Date check_out,Integer hotelId, Integer typeId){

        Collection<Object[]>available1 =roomAviRepository.Noroom(hotelId,typeId);
        System.out.println(available1);
        return 1;
        
    }
    
}
