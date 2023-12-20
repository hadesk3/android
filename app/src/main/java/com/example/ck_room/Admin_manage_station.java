package com.example.ck_room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Station;
import com.example.ck_room.custom_view.CustomAdapter;
import com.example.ck_room.custom_view.CustomAdapter_station;

import java.util.ArrayList;
import java.util.List;

public class Admin_manage_station extends AppCompatActivity {
    Button create;
    MyDatabase myDatabase;
    int  REQUEST_CODE = 20000001;
    private CustomAdapter_station adapter3;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_manage_station);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
        create = findViewById(R.id.btCreate);
        recyclerView = findViewById(R.id.recyclerViewmanage);

        List<Station> list = myDatabase.stationDao().getAllStations();
        List<String> nameStation = new ArrayList<>();
        List<String> nameAddress = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            nameStation.add(list.get(i).getName());
            nameAddress.add(list.get(i).getAddress());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(Admin_manage_station.this));

        adapter3 = new CustomAdapter_station(nameStation, nameAddress,Admin_manage_station.this);
        recyclerView.setAdapter(adapter3);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_manage_station.this, Add_station.class);

                startActivityForResult(intent,REQUEST_CODE);
            }
        });

        adapter3.notifyDataSetChanged();


    }
}
