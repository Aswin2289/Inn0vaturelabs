/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.HotelManagement.controller;

import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.innovature.HotelManagement.entity.User;
import com.innovature.HotelManagement.form.ChangepasswordForm;
import com.innovature.HotelManagement.form.UserEditForm;
import com.innovature.HotelManagement.form.UserForm;
import com.innovature.HotelManagement.service.UserService;
import com.innovature.HotelManagement.view.UserView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.mapping.Array;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserView add(@Valid @RequestBody UserForm form) {
        return userService.add(form);
    }



    @PutMapping("/{userId}")
    public UserView updates(
            @PathVariable("userId") Integer userId,
            @Valid @RequestBody UserEditForm form) {
        return userService.updates(userId, form);
    }

    @PatchMapping("/status/{userId}")
    public void statusup(@PathVariable("userId")Integer userId){
        userService.statusup(userId);
    }

    @PatchMapping("/userstatus/{userId}")
    public void userstatusup(@PathVariable("userId") Integer userId){
        userService.userstatusup(userId);
    }

    @DeleteMapping("/{userId}")
    public void deletes(
            @PathVariable("userId") Integer userId) {
        userService.deletes(userId);
    }
    @GetMapping("/role")
    public Collection<User>list(Principal p){
        return userService.list();
    }


    @GetMapping
    public Collection<User>listall(Principal p){
        return userService.listall();
    }

    @GetMapping("/sort")
    public ResponseEntity <List<User>> getAllEmployees(
                                @RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "3") Integer pageSize,
                                @RequestParam(defaultValue = "userId") String sortBy
                                ) {
                                    List<User> list = userService.getUser(pageNo, pageSize,sortBy);
                                        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK); 
                                    }


    @GetMapping("/search")
    public ResponseEntity<Collection<User>>getUserdata(@RequestParam("firstName") String first){
        System.out.println(first);
        Collection<User>list=userService.getUser2(first);
        return new ResponseEntity<Collection<User>>(list,new HttpHeaders(), HttpStatus.OK);
    }


    @PatchMapping("/changepassword")
    public UserView getpass(@RequestBody @Valid ChangepasswordForm form){
        return userService.getpassword(form);
    }

    


    
    
  
}
