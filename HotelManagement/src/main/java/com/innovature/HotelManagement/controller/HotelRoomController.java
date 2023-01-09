package com.innovature.HotelManagement.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovature.HotelManagement.entity.HotelRoom;
import com.innovature.HotelManagement.form.HotelRoomForm;
import com.innovature.HotelManagement.service.HotelRoomService;
import com.innovature.HotelManagement.view.HotelListView;
import com.innovature.HotelManagement.view.HotelRoomDetailView;

@RestController
@RequestMapping("/hotelroom")
public class HotelRoomController {
    @Autowired
    private HotelRoomService hotelrRoomService;

    
    @GetMapping
    public Collection<HotelRoom>list(){
        return hotelrRoomService.list();
    }

    @PostMapping
    public HotelRoomDetailView add(@Valid @RequestBody HotelRoomForm form){
        return hotelrRoomService.add(form);
    }

    @GetMapping("/{typeId}")
    public HotelRoomDetailView get(@PathVariable("typeId")Integer typeId){
        return hotelrRoomService.get(typeId);
    }

    



    


}
