package com.example.ck_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Station;
import com.example.ck_room.Entity.Train;
import com.example.ck_room.custom_view.CustomAdapter;
import com.example.ck_room.custom_view.CustomAdapter_station;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Admin_manageTrain_page extends AppCompatActivity {
    Button btCreate, search, back;

    private Spinner edtDepart, edtArrive;
    private ArrayAdapter<String> adapter;
    MyDatabase myDatabase;
    TextView edtDate;
    private Calendar selectedDate = Calendar.getInstance();
    int  REQUEST_CODE = 200;
    private List<String> itemList;

    private CustomAdapter adapter3;
    private RecyclerView recyclerView;
    private String select1 ="",select2 ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_manage_train);

        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
        back = findViewById(R.id.btBack);
        edtDepart = findViewById(R.id.edtDepart);
        edtArrive = findViewById(R.id.edtArrive);
        edtDate = findViewById(R.id.edtDate);
        search = findViewById((R.id.btSearch));
        btCreate = findViewById(R.id.create);
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
                        Admin_manageTrain_page.this,
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



        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Admin_manageTrain_page.this, Admin_add_Train.class);

                startActivityForResult(intent,REQUEST_CODE);
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemList = new ArrayList<>();
                recyclerView = findViewById(R.id.recyclerViewmanage);
                recyclerView.setLayoutManager(new LinearLayoutManager(Admin_manageTrain_page.this));
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

                adapter3 = new CustomAdapter(itemListName, itemListPlace,itemListTime, Admin_manageTrain_page.this,itemListSource,itemListDes,itemListDay);
                recyclerView.setAdapter(adapter3);

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

            itemList = new ArrayList<>();
            recyclerView = findViewById(R.id.recyclerViewmanage);
            recyclerView.setLayoutManager(new LinearLayoutManager(Admin_manageTrain_page.this));
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

            adapter3 = new CustomAdapter(itemListName, itemListPlace,itemListTime, Admin_manageTrain_page.this,itemListSource,itemListDes,itemListDay);
            recyclerView.setAdapter(adapter3);

        }

    }
}