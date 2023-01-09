package com.innovature.HotelManagement.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovature.HotelManagement.entity.RoomsAvi;
import com.innovature.HotelManagement.form.RoomAviForm;
import com.innovature.HotelManagement.repository.BookingRepository;
import com.innovature.HotelManagement.repository.RoomAviRepository;
import com.innovature.HotelManagement.service.BookingService;
import com.innovature.HotelManagement.service.RoomAviService;
import com.innovature.HotelManagement.view.RoomAviDetailView;

@RestController
@RequestMapping("/Addroom")
public class RoomAviController {
    

    @Autowired
    private RoomAviService roomAviService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomAviRepository roomAviRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping()
    public RoomAviDetailView add(@Valid @RequestBody RoomAviForm form){
        return roomAviService.add(form);
    }

    @GetMapping()
    public Collection<RoomsAvi>list(){
        return roomAviService.list();
    }       
    @PutMapping("/{hotelId}")
    public RoomAviDetailView updates(
        @PathVariable("hotelId") Integer roomAviId,
        @Valid @RequestBody RoomAviForm form
    ){
        return roomAviService.updates(roomAviId,form);
    }  
    
    @GetMapping("/selroom")
    public Collection<RoomsAvi>selroom(@RequestParam Integer hotelId){
        return roomAviService.selroom(hotelId);
    }
    @GetMapping("/Noroom")
    public Collection<Object[]>Noroom(@RequestParam Integer hotelId,@RequestParam Integer typeId){
        return roomAviService.Noroom(hotelId,typeId);
    }
    @PutMapping("/bookedroom")
    public void bookedroom(@RequestParam Integer hotelId,@RequestParam Integer typeId){
        if(roomAviService.bookedroom(hotelId,typeId)==0){
            System.out.println("Error");
        }
       
        
    }
    @PutMapping("/bookedroomdec")
    public void bookedroomdec(@RequestParam Integer hotelId,@RequestParam Integer typeId){
        if(roomAviService.bookedroomdec(hotelId,typeId)==0){
            System.out.println("Error");
        }
        
        
    }


    @GetMapping("/availabl")
    public String availabl(@RequestParam Integer hotelId,@RequestParam Integer typeId,@RequestParam String checkIn , @RequestParam String checkOut){
        
        int available1 =roomAviRepository.roomdata(hotelId,typeId);


        System.out.println("+++++++++++++++++++++++++++++"+available1);

        if(available1==0){
            int a=bookingService.availabilityId(hotelId,typeId,checkIn,checkOut).size();
            if (a>0){
                System.out.println("available");
                return "Avalaible";
            }
            else{
                System.out.println("Error");
                return "Error";
            }
        }
        else{
            System.out.println("available1");
            return "available";
        }
  }

    
 }
