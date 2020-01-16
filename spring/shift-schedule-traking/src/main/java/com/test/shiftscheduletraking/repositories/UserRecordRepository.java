package com.test.shiftscheduletraking.repositories;

//import java.util.Date;
import java.util.List;

import com.test.shiftscheduletraking.entities.UserRecord;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;





@Transactional
@Repository
public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {
   // @Query("SELECT u FROM UserRecord u WHERE u.fullName like %:name% ")
    //public List<UserRecord> findByfullName(String fullName);

    @Query("SELECT u FROM UserRecord u WHERE u.UserId = :UserId")
    public List<UserRecord> findByUserId(@Param("UserId") Long UserId);

    @Query("SELECT u FROM UserRecord u WHERE u.leaveType = :leaveType")
    public List<UserRecord> findByType(@Param("leaveType") String leaveType);
    
    @Query("SELECT u FROM UserRecord u WHERE u.id = :id")
    public UserRecord searchById(@Param("id") Long id);

}
    