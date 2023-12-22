package com.example.ck_room.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ck_room.Entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user WHERE EmailID= :userName")
    User getUserByMail(String userName);

    @Query("SELECT * FROM user WHERE phone= :phone")
    User getUserByPhone(String phone);

    @Query("SELECT * FROM user")
    List<User> getAllUser();

}