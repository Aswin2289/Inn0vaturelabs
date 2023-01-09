package com.innovature.HotelManagement.view;

import com.innovature.HotelManagement.entity.HotelRoom;

public class HotelRoomDetailView extends HotelRoomListView{

    public HotelRoomDetailView(HotelRoom hotelroom){
        super(
            hotelroom.getTypeId(),
            hotelroom.getTypeName(),
            hotelroom.getTypeCap(),
            hotelroom.getTypePrice() 
        );

    }
    
}
