package com.innovature.HotelManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.innovature.HotelManagement.form.HotelForm;
import com.innovature.HotelManagement.form.HotelRoomForm;

@Entity
public class HotelRoom {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;
    private String typeName;
    private Integer typeCap;
    private Integer typePrice;

    public HotelRoom(){

    }
    public HotelRoom(Integer typeId){
        this.typeId=typeId;

    }

    public HotelRoom(HotelRoomForm form){
        this.typeName=form.getTypeName();
        this.typeCap=form.getTypeCap();
        this.typePrice=form.getTypePrice();


    }
    //
    
    public Integer getTypeId() {
        return typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public Integer getTypeCap() {
        return typeCap;
    }
    public void setTypeCap(Integer typeCap) {
        this.typeCap = typeCap;
    }
    public Integer getTypePrice() {
        return typePrice;
    }
    public void setTypePrice(Integer typePrice) {
        this.typePrice = typePrice;
    }
    

}
