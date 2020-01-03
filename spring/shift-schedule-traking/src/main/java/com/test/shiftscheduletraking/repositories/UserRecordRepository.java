package com.test.shiftscheduletraking.repositories;

import java.util.Date;
import java.util.List;

import com.test.shiftscheduletraking.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
@Repository
public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {
    public List<UserRecord> findByfullNameStartingWith(String fullName);

    public List<UserRecord> findByfullNameEndsWith(String fullName);    

    public List<UserRecord> findByfullNameContains(String fullName);

    public List<UserRecord> findByfullNameStartingWithAndfullNameEndsWithAndfullNameContains(String starts, String ends, String match);
    
    public List<UserRecord> findByID(Integer id);

    public List<UserRecord> findByuserid(Integer user_id);

    public List<UserRecord> findBytype(String type);


}
    