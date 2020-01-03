package com.test.shiftscheduletraking.controllers;

import java.util.Date;
import java.util.List;

import com.test.shiftscheduletraking.entities.User;
import com.test.shiftscheduletraking.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping(value ="/user")
    public List<User> index(
        @RequestParam(name="id",required=false) Long id,
        @RequestParam(name="fullName",required=false) String fullName,
        @RequestParam(name="team",required=false) Integer team,
        @RequestParam(name="status",required=false) String status,
        @RequestParam(name="access",required=false) String access
    )
    {   
        if(id != null){
            return userRepo.searchUserById(id);
        }else if(fullName != null){
            return userRepo.searchUserByName(fullName);
        }else if(team != null){
            return userRepo.searchUserByTeam(team);
        }else if(status != null){
            return userRepo.searchUserByStatus(status);
        }else if(access != null){
            return userRepo.searchUserByAccess(access);
        }else{
            return userRepo.findAll();
        }
    }

    @PostMapping(value="/user")
    public String create(
        @RequestBody User user
        // @RequestParam(name="fullName",required=false) String fullName,
        // @RequestParam(name="group",required=false) Integer group,
        // @RequestParam(name="access",required=false) String access
    ){
        if(user.getFullName()!= null && (user.getGroup() <=2 ||user.getGroup() >=1) && user.getAccess() !=null){
            user.setFullName(user.getFullName());
            user.setGroup(user.getGroup());
            user.setTotalLeave(18);
            user.setStatus("working");
            user.setAccess(user.getAccess());
            Date date = new Date(System.currentTimeMillis());
            user.setCreatedBy("BF");
            user.setCreatedAt(date);
            user.setUpdatedBy("BF");
            user.setUpdatedAt(date);
            user.setUpdateFrequency(0);

            userRepo.save(user);
            return "User created";
        }else {
            return "Please key in all required values";
        }
    }

    @PutMapping(value ="/user/{id}")
    public String update(
        @PathVariable("id") Long id,
        // @RequestParam String fullName,
        // @RequestParam Integer team,
        // @RequestParam Integer totalLeave,
        // @RequestParam String status,
        // @RequestParam String access,
        @RequestBody User data
    ){
        if(id!=null){
            User user = userRepo.searchById(id);
            user.setFullName(data.getFullName());
            user.setGroup(data.getGroup());
            user.setTotalLeave(data.getTotalLeave());
            user.setStatus(data.getStatus());
            user.setAccess(data.getAccess());
            Date date = new Date(System.currentTimeMillis());
            user.setUpdatedBy("ABF");
            user.setUpdatedAt(date);
            user.setUpdateFrequency(user.getUpdateFrequency()+1);
    
            userRepo.save(user);
            return "Data updated";
        }else{
            return "Please key in all required values";
        }    
    }

    @DeleteMapping(value="/user/{id}")
    public String delete(@PathVariable("id") Long id){
        User user = userRepo.searchById(id);

        if(user != null){
            userRepo.delete(user);
            return "User successfully deleted";
        }else{
            return "User doesn't exist";
        }
    }
}