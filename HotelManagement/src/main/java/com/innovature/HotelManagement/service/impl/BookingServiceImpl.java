package com.innovature.HotelManagement.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innovature.HotelManagement.entity.Booking;
import com.innovature.HotelManagement.entity.Hotel;
import com.innovature.HotelManagement.entity.HotelRoom;
import com.innovature.HotelManagement.exception.NotFoundException;
import com.innovature.HotelManagement.form.BookingForm;
import com.innovature.HotelManagement.repository.BookingRepository;
import com.innovature.HotelManagement.repository.HotelRepository;
import com.innovature.HotelManagement.repository.HotelRoomRepository;
import com.innovature.HotelManagement.security.util.SecurityUtil;
import com.innovature.HotelManagement.service.BookingService;
import com.innovature.HotelManagement.view.BookingDetailView;
import com.innovature.HotelManagement.view.BookingListView;

@Service
public class BookingServiceImpl implements BookingService{


    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelRoomRepository hotelRoomRepository;
    
    

    @Override
    public BookingDetailView add(BookingForm form){
        Hotel hotel=hotelRepository.findByHotelId(form.getHotelId());
        HotelRoom hotelRoom=hotelRoomRepository.findByTypeId(form.getTypeId());
        return new BookingDetailView(bookingRepository.save(new Booking(form,SecurityUtil.getCurrentUserId(),hotel,hotelRoom)));
    }


    @Override
    public Collection<Booking>list(){
        return bookingRepository.findAll();

   
    }

    @Override
    public Collection<BookingListView> list1() {
        return bookingRepository.findAllByUserUserId(SecurityUtil.getCurrentUserId());
    }

    @Override
    public Collection<Hotel>available(String checkIn, String checkOut){
        Collection<Hotel> list1=new ArrayList<Hotel>();
         
         for(Integer i:bookingRepository.availability(checkIn,checkOut)){
         
            Hotel h=hotelRepository.findByHotelId(i);
      
            list1.add(h);
            
         }
      
         return list1;
    }
    @Override
    public Collection<Hotel>availabilityId(Integer hotelId ,Integer typeId,String checkIn, String checkOut){
        Collection<Hotel> list1=new ArrayList<Hotel>();
         
         for(Integer i:bookingRepository.availabilityId(hotelId,typeId,checkIn,checkOut)){
         
            Hotel h=hotelRepository.findByHotelId(i);
      
            list1.add(h);
           
         }
      
         return list1;
    }



    @Override
    @Transactional
    public void Bookstatusup(Integer bookId){
        Booking booking=bookingRepository.findById(bookId);
        if(booking.getStatus()==1){
            booking.setStatus(Booking.Status.DELETED.value);
        }
        else{
            System.out.println("Error");
        }
    }

    @Override
    public Collection<Object[]> datediff() {
        return bookingRepository.datediff();
    }
    @Override
    public boolean sendBookEmail(Integer bookId, String to)
    {
        boolean s=false;
        String senderEmail="stormhokspam@gmail.com";
        String senderPassword="cyckyhziponehguf";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); 
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "587"); // 587 is TLS port number
        Session session = Session.getInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){

                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        try {
            Booking booking=bookingRepository.findById(bookId);
            Hotel hotel=booking.getHotelId();

            MimeMessage msg = new MimeMessage(session); 

            msg.setFrom(new InternetAddress(senderEmail));

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); 

            msg.setSubject("Your Hotel has been booked"); 
            msg.setText("The Hotel has booked \t"+booking.getBookName()+"\t in hotel\t"+hotel.getName()+"\tBooked On\t"+booking.getCreateDate()); 
            Transport.send(msg); 

            s = true; // Set the "foo" variable to true after successfully sending emails

        }catch(Exception e){

        }

        return s; // and return foo variable
    }


    /////////////////////////////////Cancel book email

    @Override
    public boolean sendCancelBookEmail(Integer bookId, String to)
    {
        
        boolean s=false;
        String senderEmail="stormhokspam@gmail.com";
        String senderPassword="cyckyhziponehguf";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); 
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "587"); // 587 is TLS port number
        Session session = Session.getInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){

                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        try {
            Booking booking=bookingRepository.findById(bookId);
            
            Hotel hotel=booking.getHotelId();
            
            MimeMessage msg = new MimeMessage(session); 

            msg.setFrom(new InternetAddress(senderEmail));

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); 

            msg.setSubject("Your Booking Cancelled"); 
            msg.setText("booking of name "+booking.getBookName()+" \t in hotel\t"+hotel.getName()+" \tbooked On\t"+booking.getCreateDate()+"\tHas been cancelled" ); 
            Transport.send(msg); 

            s = true; // Set the "foo" variable to true after successfully sending emails

        }catch(Exception e){
            return false;
        }

        return s; // and return foo variable
    }
    

}
