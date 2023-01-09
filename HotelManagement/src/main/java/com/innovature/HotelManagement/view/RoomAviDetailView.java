package com.innovature.HotelManagement.view;

import com.innovature.HotelManagement.entity.RoomsAvi;

public class RoomAviDetailView extends RoomAviListView{
    public RoomAviDetailView(RoomsAvi room){
        super(
            room.getRoomAviId(),
            room.getNoOfRooms(),
            room.getHotelId(),
            room.getTypeId(),
            room.getBookedRoom(),
            room.getCreateDate()
        );
    }
}
