package com.example.ck_room;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Day_available;
import com.example.ck_room.Entity.Train;
import com.example.ck_room.Entity.Train_class;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class User_view_train extends AppCompatActivity {

    TextView edtDate, edtStart, edtEnd, des, source;
    private Calendar selectedDate = Calendar.getInstance();
    private int selectedHour, selectedMinute;
    MyDatabase myDatabase;

    TextView edtName,edtEcoFare,edtFirstFare,edtBusFare,
            edtEcoPass,edtBusPass,edtFirstPass;
    int id;
    Button book;
    int id_sent_to_book = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view_train);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
        book = findViewById(R.id.btCreate);
        edtDate = findViewById(R.id.edtDate);
        edtName = findViewById(R.id.edtName);
        edtEnd = findViewById(R.id.edtEnd);
        edtStart = findViewById(R.id.edtStart);

        source = findViewById(R.id.edtEmail);
        des = findViewById(R.id.edtArrive);
        edtEcoPass = findViewById(R.id.edtEcoPass);
        edtBusPass = findViewById(R.id.edtBusPass);
        edtFirstPass = findViewById(R.id.edtFirstPass);

        edtBusFare = findViewById(R.id.edtBusFare);
        edtFirstFare = findViewById(R.id.edtFirstFare);
        edtEcoFare = findViewById(R.id.edtEcoFare);
        Intent intent = getIntent();
        id_sent_to_book = intent.getIntExtra("id",0);
        id = intent.getIntExtra("id",0)  -1;
        Train t = myDatabase.trainDao().getAllTrains().get(id);

        edtName.setText(t.getTrain_name());
        source.setText(t.getSource_stn());
        des.setText(t.getDestination_stn());

        List<Day_available> a =  new ArrayList<>();
        a =myDatabase.dateAvailableDao().getDayAvailableByTrainId(id + 1);
        edtDate.setText(a.get(0).getDay_available());
        Train_class t_c = new Train_class();
        t_c = myDatabase.trainClassDao().getTrainClassById(id +1);

        //  edtDate.setText(a.get(0).getDay_available());
        edtStart.setText(t.getTimeStart());
        edtEnd.setText(t.getTimeEnd());
        edtEcoFare.setText(t_c.getEconomy_Fare() +"");
        edtBusFare.setText(t_c.getBusiness_Fare() +"");
        edtFirstFare.setText(t_c.getFirst_Fare() +"");
        edtEcoPass.setText(t_c.getEconomy_Passenger() +"");
        edtBusPass.setText(t_c.getBusiness_Passenger() +"");
        edtFirstPass.setText(t_c.getFirst_Passenger() +"");


        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        User_view_train.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                selectedDate.set(Calendar.YEAR, year);
                                selectedDate.set(Calendar.MONTH, month);
                                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                                String selectedDateString = dateFormat.format(selectedDate.getTime());
                                edtDate.setText(selectedDateString);
                            }
                        },
                        selectedDate.get(Calendar.YEAR),
                        selectedDate.get(Calendar.MONTH),
                        selectedDate.get(Calendar.DAY_OF_MONTH)
                );

                datePickerDialog.show();
            }
        });
        edtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                // Tạo TimePickerDialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        User_view_train.this,
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // Xử lý khi thời gian được chọn
                                selectedHour = hourOfDay;
                                selectedMinute = minute;

                                // Hiển thị thời gian trên TextView
                                String formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
                                edtStart.setText(formattedTime);
                            }
                        },
                        hour,
                        minute,
                        true
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.setTitle("Select a time");
                timePickerDialog.show();
            }
        });
        edtEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                // Tạo TimePickerDialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        User_view_train.this,
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // Xử lý khi thời gian được chọn
                                selectedHour = hourOfDay;
                                selectedMinute = minute;

                                // Hiển thị thời gian trên TextView
                                String formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
                                edtEnd.setText(formattedTime);
                            }
                        },
                        hour,
                        minute,
                        true
                );

                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.setTitle("Select a time");
                timePickerDialog.show();
            }
        });
        source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_address = source.getText().toString();
                Toast.makeText(User_view_train.this,  get_address, Toast.LENGTH_SHORT).show();

                String detail = myDatabase.stationDao().getStationByName(get_address).getAddress();
                Toast.makeText(User_view_train.this, detail, Toast.LENGTH_SHORT).show();
                if (!TextUtils.isEmpty(detail)) {
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(detail));

                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");

                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    } else {
                        //if dont have gg map
                    }
            }}
        });


        des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_address = des.getText().toString();
                Toast.makeText(User_view_train.this,  get_address, Toast.LENGTH_SHORT).show();

                String detail = myDatabase.stationDao().getStationByName(get_address).getAddress();
                Toast.makeText(User_view_train.this, detail, Toast.LENGTH_SHORT).show();
                if (!TextUtils.isEmpty(detail)) {
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(detail));

                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");

                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    } else {
                    }
                }}
        });




        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGet = getIntent();
                String username = intentGet.getStringExtra("username");

                Intent intent = new Intent(User_view_train.this, User_choose_seat.class);
                intent.putExtra("id", id_sent_to_book);
                intent.putExtra("username",username);
             startActivity(intent);
            }
        });
    }
}
