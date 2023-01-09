package com.innovature.HotelManagement.service;

import java.util.Collection;

import com.innovature.HotelManagement.entity.Chat;
import com.innovature.HotelManagement.form.ChatForm;
import com.innovature.HotelManagement.view.ChatListView;



public interface ChatService {
    

    ChatListView add(ChatForm form);
    Collection<Chat> findChats(Integer chatterId);
}
