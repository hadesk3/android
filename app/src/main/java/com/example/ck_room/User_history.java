package com.example.ck_room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Ticket;
import com.example.ck_room.Entity.Train;
import com.example.ck_room.custom_view.CustomAdapter;
import com.example.ck_room.custom_view.CustomAdapter_user_see_history;

import java.util.ArrayList;
import java.util.List;

public class User_history extends AppCompatActivity {
    TextView day;
    Button search, back;
    MyDatabase myDatabase;
    private CustomAdapter_user_see_history adapter3;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_manage_ticket);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());

        back = findViewById(R.id.btBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        day = findViewById(R.id.edtDate);
        search = findViewById(R.id.btSearch);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        recyclerView = findViewById(R.id.recyclerView);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Ticket> ticketDay = myDatabase.ticketDao().getTicketClassByTrainAndDay(day.getText().toString(),username);
                 List<String> itemList = new ArrayList<>();
                 List<String> itemType = new ArrayList<>();
                 List<String> itemPrice = new ArrayList<>();
                List<String> itemId = new ArrayList<>();

                List<String> status_check = new ArrayList<>();

                for (int i = 0; i < ticketDay.size(); i++)
                {
                    Train t = myDatabase.trainDao().getTrainById(ticketDay.get(i).getTrain_id()).get(0);
                    itemList.add(t.getTrain_name());
                    itemPrice.add(t.getTimeStart()+ " to " + t.getTimeEnd());
                    itemType.add(day.getText().toString());
                    itemId.add(ticketDay.get(i).getTicket_No());
                    if(ticketDay.get(i).getStatusPay().equals("PAYED"))
                    {
                        status_check.add("Ticket has been paid");
                        Log.d("check ticket",ticketDay.get(i).getStatusPay());

                    }else
                    {
                        status_check.add("Ticket has been unpaid");

                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(User_history.this));
                adapter3 = new CustomAdapter_user_see_history(itemList, itemType,itemPrice, itemId,status_check,User_history.this);
                recyclerView.setAdapter(adapter3);

            }
        });


    }
}
