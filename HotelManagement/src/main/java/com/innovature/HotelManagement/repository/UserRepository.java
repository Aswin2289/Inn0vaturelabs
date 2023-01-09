/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.HotelManagement.repository;

import com.innovature.HotelManagement.entity.User;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    Optional<User> findById(Integer userId);
    
    Optional<User> findByUserIdAndPassword(Integer userId, String password);

    Optional<User> findByEmail(String email);

    User save(User user);
    void delete(User user);

    @Query(value = "SELECT * FROM user WHERE email=?",nativeQuery = true)
    User findByEmailId(String email);
    
    Collection<User> findAll();
    User findByUserId(Integer userId);
    
    Page<User> findAllByRole(Pageable pageable,Integer role);
    Collection<User> findByRole(Integer role);


    @Query(value = "SELECT * FROM user u WHERE u.first_name LIKE CONCAT('%',:first,'%' ) AND u.role='0' AND u.status=1",nativeQuery = true)
    
    Collection<User>findAllUsers(
        @Param("first") String first);

   

}
