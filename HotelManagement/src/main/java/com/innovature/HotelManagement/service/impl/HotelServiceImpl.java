package com.innovature.HotelManagement.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.innovature.HotelManagement.entity.Hotel;
import com.innovature.HotelManagement.exception.NotFoundException;
import com.innovature.HotelManagement.form.HotelForm;
import com.innovature.HotelManagement.form.UserForm;
import com.innovature.HotelManagement.repository.HotelRepository;
import com.innovature.HotelManagement.security.util.SecurityUtil;
import com.innovature.HotelManagement.service.HotelService;
import com.innovature.HotelManagement.util.FileUtil;
import com.innovature.HotelManagement.view.HotelDetailView;
import com.innovature.HotelManagement.view.HotelListView;

@Service
public class HotelServiceImpl implements HotelService{
    
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public HotelDetailView add(HotelForm form){
        return new HotelDetailView(hotelRepository.save(new Hotel(form)));
    }

    @Override
    public Collection<Hotel>list(){
        return hotelRepository.findAll();

   
    }

    @Override
    public HotelDetailView get(Integer hotelId) throws NotFoundException {
        return hotelRepository.findById(hotelId)
                .map((hotel) -> {
                    return new HotelDetailView(hotel);
                }).orElseThrow(NotFoundException::new);
    }
    


    @Override
    public HotelDetailView updates(Integer hotelId,HotelForm form){
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(NotFoundException::new);
        hotel.edit(
            form.getName(),
            form.getDescription(),
            form.getAddress(),
            form.getLatitude(),
            form.getLongitude()
            
        );
        return new HotelDetailView(hotelRepository.save(hotel));
    }

    @Override
    public void deletes(Integer hotelId) throws NotFoundException{
        hotelRepository.delete(
            hotelRepository.findById(hotelId)
            .orElseThrow(NotFoundException::new)
        );
    }


    //ImageUpload Contents

    @Override
    public HttpEntity<byte[]> getImagePic(Integer hotelId) {

        String image = hotelRepository.findByHotelId(hotelId)
                .getImage();

        byte[] file = FileUtil.getImage(image);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(file.length);

        return new HttpEntity<>(file, headers);

    }

   


   
}
