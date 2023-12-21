package com.example.ck_room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Station;

public class Admin_add_station extends AppCompatActivity {
    private static final int REQUEST_CODE = 2;
    EditText edit_name,detail;
    Button  but_update ,back;
    private MyDatabase myDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_station);
        edit_name = findViewById(R.id.edtName);
        detail = findViewById(R.id.edtAddress);
        but_update = findViewById(R.id.btCreate);

        back = findViewById(R.id.btBack);


        but_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit_name.getText().toString() != null && detail.getText().toString() != null)
                {
                    Station station = new Station(edit_name.getText().toString(),detail.getText().toString());
                    if(station != null)
                    {
                        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
                        myDatabase.stationDao().insert(station);
                        Toast.makeText(Admin_add_station.this, "Add station success", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_OK);
                        finish();
                    }
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });


    }
}
