package com.innovature.HotelManagement.view;

public class HotelRoomListView {
    private final int typeId;
    private final String typeName;
    private final Integer typeCap;
    private final Integer typePrice;


    public HotelRoomListView(int typeId,String typeName,int typeCap,int typePrice){

        this.typeId=typeId;
        this.typeName=typeName;
        this.typeCap=typeCap;
        this.typePrice=typePrice;

    }
    
    public int getTypeId() {
        return typeId;
    }
    public String getTypeName() {
        return typeName;
    }
    public Integer getTypeCap() {
        return typeCap;
    }

    public Integer getTypePrice() {
        return typePrice;
    }

    
    
}
