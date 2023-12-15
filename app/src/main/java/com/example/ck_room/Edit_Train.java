package com.example.ck_room;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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

public class Edit_Train extends AppCompatActivity {

    TextView edtDate, edtStart, edtEnd, des, source;
    private Calendar selectedDate = Calendar.getInstance();
    private int selectedHour, selectedMinute;
    Button update;
    MyDatabase myDatabase;

    EditText edtName,edtEcoFare,edtFirstFare,edtBusFare,
            edtEcoPass,edtBusPass,edtFirstPass;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_train);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());

        edtDate = findViewById(R.id.edtDate);
        edtName = findViewById(R.id.edtName);
        edtEnd = findViewById(R.id.edtEnd);
        edtStart = findViewById(R.id.edtStart);
        update = findViewById(R.id.btUpdateTrain);

        source = findViewById(R.id.edtDepart);
        des = findViewById(R.id.edtArrive);
        edtEcoPass = findViewById(R.id.edtEcoPass);
        edtBusPass = findViewById(R.id.edtBusPass);
        edtFirstPass = findViewById(R.id.edtFirstPass);

        edtBusFare = findViewById(R.id.edtBusFare);
        edtFirstFare = findViewById(R.id.edtFirstFare);
        edtEcoFare = findViewById(R.id.edtEcoFare);
        Intent intent = getIntent();
        id = intent.getIntExtra("id",0)  -1;
        Train t = myDatabase.trainDao().getAllTrains().get(id);
        Toast.makeText(this, t.toString(), Toast.LENGTH_SHORT).show();

            edtName.setText(t.getTrain_name());
            source.setText(t.getSource_stn());
            des.setText(t.getDestination_stn());

            List<Day_available> a =  new ArrayList<>();
            a =myDatabase.dateAvailableDao().getDayAvailableByTrainId(id + 1);

            Train_class t_c = new Train_class();
            t_c = myDatabase.trainClassDao().getTrainClassById(id +1);
            if(a.size() == 0)
            {
                Log.d("a","kooo");


            }
          //  edtDate.setText(a.get(0).getDay_available());
            edtStart.setText(t.getTimeStart());
            edtEnd.setText(t.getTimeEnd());
            edtDate.setText((a.get(0).getDay_available()));
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
                        Edit_Train.this,
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
                        Edit_Train.this,
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
                        Edit_Train.this,
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
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Log.d("id", id+"");
                Train t = myDatabase.trainDao().getAllTrains().get(id);
                t.setTimeStart(edtStart.getText().toString());
                t.setTimeEnd(edtEnd.getText().toString());
                myDatabase.trainDao().update(t);
                Toast.makeText(Edit_Train.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}