package com.example.ck_room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Food;
import com.example.ck_room.custom_view.CustomAdapter_station;
import com.example.ck_room.custom_view.CustomAdapter_user_profile;
import com.example.ck_room.custom_view.CustomAdapter_user_see_menu;

import java.util.ArrayList;
import java.util.List;

public class User_see_menu extends AppCompatActivity {
    MyDatabase myDatabase;
    private CustomAdapter_user_see_menu adapter3;
    private RecyclerView recyclerView;
    Button back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        recyclerView = findViewById(R.id.recyclerView3);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
        back = findViewById(R.id.btBack);


        List<Food> f = myDatabase.foodDao().getAllFood();
        List<String> name = new ArrayList<>();
        List<String> type = new ArrayList<>();
        List<String> price = new ArrayList<>();
        List<String> draw = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(User_see_menu.this));
        for(int i = 0; i < f.size();i++)
        {
            name.add(f.get(i).getName());
            type.add(f.get(i).getType());
            price.add(f.get(i).getPrice());
            draw.add(f.get(i).getDrawable());
        }

        adapter3 = new CustomAdapter_user_see_menu(name,type,price,draw,User_see_menu.this);
        recyclerView.setAdapter(adapter3);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });


    }
}
