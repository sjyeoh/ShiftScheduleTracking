package com.test.shiftscheduletraking.controllers;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.test.shiftscheduletraking.entities.UserRecord;
import com.test.shiftscheduletraking.repositories.*;

@RestController
public class UserRecordController {

    private static final Object json = null;
    @Autowired
    UserRecordRepository userrecordRepo;

    @GetMapping(value = "/userrecords")
    public List<UserRecord> index(
            @RequestParam(name = "fullName", required = false) String fullName,
            @RequestParam(name="id",required=false) Long id,
            @RequestParam(name = "leaveType", required = false) String leaveType

    ) {
        //if (fullName != null) {
           // return userrecordRepo.findByfullName(fullName);
        if (id != null) {
            return userrecordRepo.findByUserId(id);
        } else if (leaveType != null) {
            return userrecordRepo.findByType(leaveType);
        }
        return userrecordRepo.findAll();
    }

    @PostMapping(value="/userrecord")
    public ResponseEntity<Object> Create(
        @RequestBody UserRecord userrecord
        // @RequestParam(name="fullName",required=false) String fullName,
        // @RequestParam(name="group",required=false) Integer group,
        // @RequestParam(name="access",required=false) String access
    ){
        if(/*userrecord.getId() <=2 ||userrecord.getId() >=1)*/
        /*userrecord.getApplyDate()!=null && userrecord.getLeaveType()!=null)*/ 
        userrecord.getLeaveType()!=null)
        {
            userrecord.setLeaveType(userrecord.getLeaveType());  
            Date date = new Date(System.currentTimeMillis());
            userrecord.setApplyDate(userrecord.getApplyDate());
            userrecord.setCreatedAt(date);
            userrecord.setCreatedBy("BF");
            userrecord.setUpdatedAt(date);
            userrecord.setUpdatedBy("bf");
            userrecord.setUpdateFrequency(0);
            userrecord.setUser_id(userrecord.getUser_id());

            userrecordRepo.save(userrecord);
            return ResponseEntity.ok(json);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    
    @PutMapping(value = "/userrecord/{id}")
    public String update(
        @PathVariable("id") Long id, 
        //@RequestBody String leaveType,
        //@RequestBody Date applyDate)
        @RequestBody UserRecord data)
        {
                if(id!=null){
                    UserRecord record  = userrecordRepo.searchById(id);
                    record.setLeaveType(data.getLeaveType());
                    Date date = new Date(System.currentTimeMillis());
                    record.setCreatedAt(date);
                    record.setCreatedBy("BF");
                    record.setUpdatedAt(date);
                    record.setUpdateFrequency(0);
            
                    userrecordRepo.save(record);
                    return "Data updated";
                }else{
                    return "Please key in all required values";
                }    
            }
    


   // @DeleteMapping(value = "/userrecords/{id}")
   // public void delete(@PathVariable("id") Long id){
  //      UserRecord userrecord = userrecordRepo.findById(id).orElse(null);
   //     userrecordRepo.delete(userrecord);
  //  }

    @DeleteMapping(value="/userrecords/{id}")
    public String delete(@PathVariable("id") Long id){
        UserRecord record = userrecordRepo.searchById(id);

        if(record != null){
            userrecordRepo.delete(record);
            return "User successfully deleted";
        }else{
            return "User doesn't exist";
        }
    }

}
