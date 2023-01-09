package com.innovature.HotelManagement.view;
import java.util.Date;

import com.innovature.HotelManagement.entity.User;

public class UserDetailView extends UserListView{

    public UserDetailView(User user) {
        super(
            user.getUserId(),
            user.getFirstName(),
            user.getLastName(),
            user.getDob(),
            user.getGender(),
            user.getCountry(),
            user.getRole(),
            user.getEmail(),
            user.getStatus(),
            user.getUserStatus(),
            user.getCreateDate(),
            user.getUpdateDate()

        );
        
        
    }
   
}
