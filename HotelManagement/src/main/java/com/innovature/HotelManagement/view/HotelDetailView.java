package com.innovature.HotelManagement.view;

import com.innovature.HotelManagement.entity.Hotel;

public class HotelDetailView extends HotelListView{
    public HotelDetailView(Hotel hotel){
        super(
            hotel.getHotelId(),
            hotel.getName(),
            
            hotel.getDescription(),
            hotel.getImage(),
            hotel.getAddress(),
            hotel.getLatitude(),
            hotel.getLongitude()
        );
    }
    
}
