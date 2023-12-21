package com.example.ck_room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Station;
import com.example.ck_room.Entity.User;
import com.example.ck_room.custom_view.CustomAdapter_station;
import com.example.ck_room.custom_view.CustomAdapter_user_profile;

import java.util.ArrayList;
import java.util.List;

public class Admin_manage_profile extends AppCompatActivity {
    EditText gmail;
    Button search,back;
    private MyDatabase myDatabase;
    private CustomAdapter_user_profile adapter3;
    private RecyclerView recyclerView;
    String username = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_manage_user);
        gmail = findViewById(R.id.edtEmail);
        search = findViewById(R.id.btSearch);
        back = findViewById(R.id.btBack);

        myDatabase = DatabaseManager.getDatabase(getApplicationContext());

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User u = myDatabase.userDao().getUserByMail(gmail.getText().toString());
                if(u == null)
                {
                    Toast.makeText(Admin_manage_profile.this, "Can't not find", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    recyclerView = findViewById(R.id.recyclerViewmanage);

                    recyclerView.setLayoutManager(new LinearLayoutManager(Admin_manage_profile.this));
                    List<String> name = new ArrayList<>();
                    name.add(u.getUserName());
                    List<String> dob = new ArrayList<>();
                    dob.add(u.getDob());
                    List<String> gender = new ArrayList<>();
                    gender.add(u.getGender());
                    adapter3 = new CustomAdapter_user_profile(name, dob,gender,Admin_manage_profile.this);
                    recyclerView.setAdapter(adapter3);
                    username = gmail.getText().toString();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            gmail.setText("");
        }

    }

    public String getUsernameToEdit()
    {
        return  this.username;
    }
}
