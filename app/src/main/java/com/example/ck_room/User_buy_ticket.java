package com.example.ck_room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Day_available;
import com.example.ck_room.Entity.Train;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class User_buy_ticket extends AppCompatActivity
{
    MyDatabase myDatabase;
    int id_sent_to_book = 0;
    int id = 0;

    TextView nameTrain, date,time, total, seat, pay, paypal;
    Switch sw;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_select_payment);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
        nameTrain = findViewById(R.id.txtTrip);
        date = findViewById(R.id.txtDate);
        time = findViewById(R.id.txtTime);
        total = findViewById(R.id.txtTotal);
        seat = findViewById(R.id.txtSeat);
        pay = findViewById(R.id.txtPay);
        sw = findViewById(R.id.swtCoin);
        paypal = findViewById(R.id.btPaypal);
        Intent intent = getIntent();

            ArrayList<String> list = intent.getStringArrayListExtra("list");
            String totalSeat = intent.getStringExtra("totalSeat");
            String totalPrice = intent.getStringExtra("totalPrice");
            String userName = intent.getStringExtra("username");

        id_sent_to_book = intent.getIntExtra("id",0);

        id = intent.getIntExtra("id",0)  -1;
        Train t = myDatabase.trainDao().getAllTrains().get(id);
        nameTrain.setText(t.getTrain_name());


        List<Day_available> a =  new ArrayList<>();
        a =myDatabase.dateAvailableDao().getDayAvailableByTrainId(id + 1);
        date.setText(a.get(0).getDay_available());
        total.setText(totalPrice);
        seat.setText(totalSeat);
        pay.setText(totalPrice);


        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if(myDatabase.userDao().getUserByMail(userName).getCoin() > 50000)
                    {

                        double money = Double.parseDouble(pay.getText().toString()) - 10;
                        DecimalFormat decimalFormat = new DecimalFormat("#.##");
                        if(money < 0)
                        {
                            money = 0;
                        }
                        else
                        {
                            money = Double.parseDouble(decimalFormat.format(money));

                        }
                        pay.setText(money + "");
                    }

                } else {
                   pay.setText(totalPrice);
                }
            }
        });


        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(User_buy_ticket.this, "click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(User_buy_ticket.this, Paypal.class);
                intent.putExtra("money",pay.getText().toString());
                startActivity(intent);

            }
        });
    }
}
