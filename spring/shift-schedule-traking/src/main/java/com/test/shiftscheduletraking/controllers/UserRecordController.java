package com.test.shiftscheduletraking.controllers;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.shiftscheduletraking.entities.*;
import com.test.shiftscheduletraking.repositories.*;

@RestController
public class UserRecordController {

    @Autowired
    UserRecordRepository repo;

    @GetMapping(value = "/userrecords")
    public List<UserRecord> index(@RequestParam(name = "starts", required = false) String starts,
            @RequestParam(name = "ends", required = false) String ends,
            @RequestParam(name = "match", required = false) String match,
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "user_id", required = false) Integer user_id,
            @RequestParam(name = "type", required = false) String type

    ) {
        if (starts != null && ends != null && match != null) {
            return repo.findByfullNameStartingWithAndfullNameEndsWithAndfullNameContains(starts, ends, match);
        } else if (starts != null) {
            return repo.findByfullNameStartingWith(starts);
        } else if (ends != null) {
            return repo.findByfullNameEndsWith(ends);
        } else if (match != null) {
            return repo.findByfullNameContains(match);
        } else if (id != null) {
            return repo.findByID(id);
        } else if (user_id != null) {
            return repo.findByuserid(user_id);
        } else if (type != null) {
            return repo.findBytype(type);
        }
        return repo.findAll();
    }

    @PostMapping(value = "/userrecords")
    public UserRecord create(@RequestBody UserRecord userrecord) {
        repo.save(userrecord);
        return userrecord;
    }

    /*
     * @PutMapping(value = "/userrecords/{id}") public UserRecord update(
     * 
     * @PathVariable("id") Long id,
     * 
     * @RequestBody UserRecord data ){
     * 
     * UserRecord userrecord = repo.findById(id).orElse(null);
     * userrecord.setfullName(data.getfullName()); repo.save(userrecord);
     * 
     * return userrecord; }
     */
    @PostMapping(value = "/userrecords/{id}")
    public void update(
        @PathVariable("id") int id, 
        @RequestBody String leaveType,
        @RequestBody Date applyDate){
        repo.updateUserRecord(leaveType,applyDate);
    }


    @DeleteMapping(value = "/userrecords/{id}")
    public void delete(@PathVariable("id") Long id){
        UserRecord userrecord = repo.findById(id).orElse(null);
        repo.delete(userrecord);
    }
}
