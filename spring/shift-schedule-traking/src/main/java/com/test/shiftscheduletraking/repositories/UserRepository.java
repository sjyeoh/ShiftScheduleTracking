package com.test.shiftscheduletraking.repositories;

import java.util.List;
import com.test.shiftscheduletraking.entities.User;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u")
    public List<User> searchAllUser();

    @Query("SELECT u FROM User u WHERE u.fullName like %:name% ")
    public List<User> searchUserByName(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    public List<User> searchUserById(@Param("id") Long id);

    @Query("SELECT u FROM User u WHERE u.team = :team")
    public List<User> searchUserByTeam(@Param("team") Integer team);

    @Query("SELECT u FROM User u WHERE u.status = :status")
    public List<User> searchUserByStatus(@Param("status") String status);

    @Query("SELECT u FROM User u WHERE u.access = :access")
    public List<User> searchUserByAccess(@Param("access") String access);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    public User searchById(@Param("id") Long id);
}
