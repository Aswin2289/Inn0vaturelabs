package com.innovature.HotelManagement.controller;

import java.io.IOException;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;
import com.innovature.HotelManagement.entity.Hotel;


import com.innovature.HotelManagement.form.HotelForm;
import com.innovature.HotelManagement.repository.HotelRepository;
import com.innovature.HotelManagement.security.util.SecurityUtil;
import com.innovature.HotelManagement.service.HotelService;
import com.innovature.HotelManagement.util.FileUtil;
import com.innovature.HotelManagement.view.HotelDetailView;
import com.innovature.HotelManagement.view.HotelListView;


@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    
    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping
    public HotelDetailView add(@Valid @RequestBody HotelForm form){
        return hotelService.add(form);
    }


    @GetMapping
    public Collection<Hotel>list(){
        return hotelService.list();
    }

    @GetMapping("/{hotelId}")
    public HotelDetailView get(@PathVariable("hotelId") Integer hotelId){
        return hotelService.get(hotelId);
    }

    @PutMapping("/{hotelId}")
    public HotelDetailView updates(
        @PathVariable("hotelId") Integer hotelId,
        @Valid @RequestBody HotelForm form){
            return hotelService.updates(hotelId,form);
        }                                                                               
       


    @DeleteMapping("/{hotelId}")
    public void deletes(@PathVariable("hotelId") Integer hotelId){
        hotelService.deletes(hotelId);
    }


    //ImageUpload Controller

    @PostMapping("/save/image/{hotelId}")
    public void saveHotelImage(@RequestParam(value="image" )  MultipartFile multipartFile,
    @PathVariable Integer hotelId) throws IOException {

        Hotel hotel = hotelRepository.findByHotelId(hotelId);

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        hotel.setImage(fileName);

        hotelRepository.save(hotel);

    //  String UploadDir = "userProfile-photos/" + savedUserProfile.getUserprofileId();

        FileUtil.saveUserProfile(fileName, multipartFile);

    }


    //Image View Controller

    @GetMapping("/profile/{hotelId}")
    public HttpEntity<byte[]> getImagePic(@PathVariable Integer hotelId) {

        return hotelService.getImagePic(hotelId);
    }

    
}
