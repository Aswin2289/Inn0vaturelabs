package com.innovature.HotelManagement.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovature.HotelManagement.entity.Chat;
import com.innovature.HotelManagement.form.ChatForm;
import com.innovature.HotelManagement.repository.ChatRepository;
import com.innovature.HotelManagement.security.util.SecurityUtil;
import com.innovature.HotelManagement.service.ChatService;
import com.innovature.HotelManagement.view.ChatListView;

@Service
public class ChatServiceImpl implements ChatService{


    @Autowired
    private ChatRepository chatRepository;


    @Override
    public ChatListView add(ChatForm form) {

        return new ChatListView(chatRepository.save(new Chat(form)));
    }

    @Override
    public Collection<Chat> findChats(Integer chatterId){
        return chatRepository.findallChats(SecurityUtil.getCurrentUserId(),chatterId);
    }
    
}
