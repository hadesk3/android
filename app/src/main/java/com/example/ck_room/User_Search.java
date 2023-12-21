package com.example.ck_room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Day_available;
import com.example.ck_room.Entity.Station;
import com.example.ck_room.Entity.Train;
import com.example.ck_room.custom_view.CustomAdapter;
import com.example.ck_room.custom_view.CustomAdapter_user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class User_Search extends AppCompatActivity {
    int REQUEST_CODE = 5;
    Button  search ,back;
    String username = "";
    private Spinner edtDepart, edtArrive;
    private ArrayAdapter<String> adapter;
    MyDatabase myDatabase;
    TextView edtDate;
    private Calendar selectedDate = Calendar.getInstance();
    private List<String> itemList;

    private CustomAdapter_user adapter3;
    private RecyclerView recyclerView;
    private String select1 ="",select2 ="";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search_page);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
        back = findViewById(R.id.btBack);

        Intent intent = getIntent();
         username = intent.getStringExtra("username");

        edtDepart = findViewById(R.id.edtDepart);
        edtArrive = findViewById(R.id.edtArrive);
        edtDate = findViewById(R.id.edtDate);
        search = findViewById((R.id.btSearch));
        List<Station> list = myDatabase.stationDao().getAllStations();
        List<String> nameStation = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            nameStation.add(list.get(i).getName());
        }



        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nameStation);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edtDepart.setAdapter(adapter);
        edtDepart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select1 = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không làm gì khi không chọn gì
            }
        });


        edtArrive.setAdapter(adapter);
        edtArrive.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select2 = (String) parent.getItemAtPosition(position);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        User_Search.this,
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



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemList = new ArrayList<>();
                recyclerView = findViewById(R.id.recyclerViewmanage);
                recyclerView.setLayoutManager(new LinearLayoutManager(User_Search.this));
                List<Train> list = myDatabase.trainDao().findTrainsByStationsAndDay(select1,select2,edtDate.getText().toString());


                List<String> itemListName = new ArrayList<>();
                List<String> itemListPlace= new ArrayList<>();
                List<String> itemListTime = new ArrayList<>();

                List<String> itemListSource = new ArrayList<>();
                List<String> itemListDes = new ArrayList<>();
                List<String> itemListDay = new ArrayList<>();

                for(int i = 0; i < list.size();i++)
                {
                    itemListName.add(list.get(i).getTrain_name());
                    itemListPlace.add(list.get(i).getSource_stn()+"-"+list.get(i).getDestination_stn());
                    itemListTime.add(list.get(i).getTimeStart()+"-" + list.get(i).getTimeEnd());
                    itemListSource.add(list.get(i).getSource_stn());
                    itemListDes.add(list.get(i).getDestination_stn());
                    itemListDay.add(edtDate.getText().toString());

                }

                adapter3 = new CustomAdapter_user(itemListName, itemListPlace,itemListTime,User_Search.this,itemListSource,itemListDes,itemListDay);
                recyclerView.setAdapter(adapter3);

            }

        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
    public String getUsername() {
        return this.username;
    }

}
