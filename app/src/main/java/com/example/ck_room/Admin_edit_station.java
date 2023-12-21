package com.example.ck_room;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Station;

public class Admin_edit_station extends AppCompatActivity {
    EditText name,address;
    Button update;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_station);
        name = findViewById(R.id.edtName);
        address = findViewById(R.id.edtAddress);
        update = findViewById(R.id.btCreate);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());

        Intent intent = getIntent();
        int  id = intent.getIntExtra("id",0)  ;
        Station s = myDatabase.stationDao().getStationById(id);
        name.setText(s.getName());
        address.setText(s.getAddress());


        address.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (address.getRight() - address.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        String get_address = address.getText().toString();

                        if (!TextUtils.isEmpty(get_address)) {
                            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(get_address));

                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                            mapIntent.setPackage("com.google.android.apps.maps");

                            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                                startActivity(mapIntent);
                            } else {
                                //if dont have gg map
                            }
                        }

                        return true;
                    }
                }
                return false;
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.setName(name.getText().toString());
                s.setAddress(address.getText().toString());
                myDatabase.stationDao().update(s);
                Toast.makeText(Admin_edit_station.this, "Update success", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();


            }
        });

    }
}
