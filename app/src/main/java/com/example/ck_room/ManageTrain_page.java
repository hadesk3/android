package com.example.ck_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.ck_room.Entity.Day_available;
import com.example.ck_room.Entity.Station;
import com.example.ck_room.Entity.Train;
import com.example.ck_room.custom_view.CustomAdapter;
import com.example.ck_room.custom_view.CustomAdapter2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ManageTrain_page extends AppCompatActivity {
    Button btCreate, search;

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
        setContentView(R.layout.activity_manage_train_page);
        btCreate = findViewById(R.id.btCreate);

        myDatabase = DatabaseManager.getDatabase(getApplicationContext());

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
                        ManageTrain_page.this,
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

                Intent intent = new Intent(ManageTrain_page.this, Add_Train.class);

                startActivityForResult(intent,REQUEST_CODE);
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemList = new ArrayList<>();
                recyclerView = findViewById(R.id.recyclerViewmanage);
                recyclerView.setLayoutManager(new LinearLayoutManager(ManageTrain_page.this));
                List<Train> list = myDatabase.trainDao().findTrainsByStationsAndDay(select1,select2,edtDate.getText().toString());
                if(list.size() == 0)
                {
                    Toast.makeText(ManageTrain_page.this, "ko cos", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ManageTrain_page.this, list.get(0).toString(), Toast.LENGTH_SHORT).show();

                }
                for(int i = 0; i < list.size();i++)
                {
                    itemList.add(list.get(i).toString());
                }

                adapter3 = new CustomAdapter(itemList, ManageTrain_page.this);
                recyclerView.setAdapter(adapter3);

            }

        });
    }
}