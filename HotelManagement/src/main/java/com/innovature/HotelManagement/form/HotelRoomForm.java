package com.innovature.HotelManagement.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.id.IntegralDataTypeHolder;

public class HotelRoomForm {

    @Size(max = 50)
    @NotBlank
    private String typeName;

    private Integer typeCap;

    private Integer typePrice;

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
