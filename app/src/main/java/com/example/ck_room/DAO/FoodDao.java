package com.example.ck_room.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ck_room.Entity.Food;
import com.example.ck_room.Entity.Train;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert
    long insert(Food food);

    @Update
    void update(Food food);

    @Delete
    void delete(Food food);

    @Query("SELECT * FROM Food")
    List<Food> getAllFood();

}
