package com.innovature.HotelManagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovature.HotelManagement.entity.Booking;
import com.innovature.HotelManagement.entity.Hotel;
import com.innovature.HotelManagement.form.BookingForm;
//import com.innovature.HotelManagement.repository.BookingRepository;
import com.innovature.HotelManagement.service.BookingService;
import com.innovature.HotelManagement.view.BookingDetailView;
import com.innovature.HotelManagement.view.BookingListView;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/booking")
public class BookingController {
   
    @Autowired
    private BookingService bookingService;

    @PostMapping()
    public BookingDetailView add(@Valid @RequestBody  BookingForm form) {
        
        return bookingService.add(form);
    }

    @GetMapping
    public Collection<Booking>list(){
        return bookingService.list();
    }
    
    @GetMapping("/id")
    public Collection<BookingListView>list1(){
        return bookingService.list1();
    }
    @GetMapping("/availability")
    public Collection<Hotel>available(@RequestParam String checkIn , @RequestParam String checkOut){
        return bookingService.available(checkIn,checkOut);
    }
    

    @PatchMapping("/bookStatus/{bookId}")
    public void userstatusup(@PathVariable("bookId") Integer bookId){
        bookingService.Bookstatusup(bookId);
    }
    @GetMapping("/datediff")
    public Collection<Object[]>datediff(){
        return bookingService.datediff();
    }
}
