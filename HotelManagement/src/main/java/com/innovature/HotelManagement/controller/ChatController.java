package com.innovature.HotelManagement.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovature.HotelManagement.entity.Chat;
import com.innovature.HotelManagement.form.ChatForm;
import com.innovature.HotelManagement.repository.ChatRepository;
import com.innovature.HotelManagement.service.ChatService;
import com.innovature.HotelManagement.view.ChatListView;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ChatService chatService;
    


    @PostMapping
    public ChatListView add(@RequestBody @Valid  ChatForm form){
        return chatService.add(form);
    }

    @GetMapping("/chat/{chatterId}")
    public Collection<Chat> findChats(@PathVariable("chatterId") Integer chatterId){
        return chatService.findChats(chatterId);
    }
}
