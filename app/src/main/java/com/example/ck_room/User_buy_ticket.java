package com.example.ck_room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Day_available;
import com.example.ck_room.Entity.Ticket;
import com.example.ck_room.Entity.Train;
import com.example.ck_room.Entity.Train_class;
import com.example.ck_room.Entity.User;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class User_buy_ticket extends AppCompatActivity
{
    MyDatabase myDatabase;
    int id_sent_to_book = 0;
    int id = 0;
    Button back;
    TextView nameTrain, date,time, total, seat, pay, paypal, cash;
    Switch sw;
    double coin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_select_payment);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
        nameTrain = findViewById(R.id.txtTrip);
        date = findViewById(R.id.txtDate);
        back = findViewById(R.id.btBack2);
        time = findViewById(R.id.txtTime);
        total = findViewById(R.id.txtTotal);
        seat = findViewById(R.id.txtSeat);
        pay = findViewById(R.id.txtPay);
        sw = findViewById(R.id.swtCoin);
        paypal = findViewById(R.id.btPaypal);
        cash = findViewById(R.id.btPaypal2);


        Intent intent = getIntent();

            ArrayList<String> list = intent.getStringArrayListExtra("list");
            String totalSeat = intent.getStringExtra("totalSeat");
        Double seatPrice  = Double.parseDouble(totalSeat) / list.size();

        String totalPrice = intent.getStringExtra("totalPrice");
            String userName = intent.getStringExtra("username");
            String type = intent.getStringExtra("type");
        id_sent_to_book = intent.getIntExtra("id",0);

        Log.d("===id gửi 4",id_sent_to_book +"");
        id = intent.getIntExtra("id",0) ;
        Train t = myDatabase.trainDao().getTrainById(id).get(0);
        nameTrain.setText(t.getTrain_name());


        List<Day_available> a =  new ArrayList<>();
        a =myDatabase.dateAvailableDao().getDayAvailableByTrainId(id);
        date.setText(a.get(0).getDay_available());
        total.setText(totalPrice);
        seat.setText(totalSeat);
        pay.setText(totalPrice);
        Train_class tc = myDatabase.trainClassDao().getTrainClassById(id);

        sw.setText(myDatabase.userDao().getUserByMail(userName).getCoin() +"");
         coin = myDatabase.userDao().getUserByMail(userName).getCoin();
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                        double money = Double.parseDouble(pay.getText().toString()) - coin;
                        DecimalFormat decimalFormat = new DecimalFormat("#.##");
                        if(money < 0)
                        {
                            money = 0;
                            coin = coin - Double.parseDouble(pay.getText().toString());
                        }
                        else
                        {
                            money = Double.parseDouble(decimalFormat.format(money));
                            coin  = 0;


                        }
                        pay.setText(money + "");
                        sw.setText(coin +"");

                } else {
                   pay.setText(totalPrice);
                    coin = myDatabase.userDao().getUserByMail(userName).getCoin();
                    sw.setText(coin+"");

                }
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        List<Day_available> finalA = a;
        paypal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                String addSeatTicket = "";


                if(type.equals("Eco"))
                {
                    for(int i = 0; i < list.size(); i++)
                    {
                        tc.setTakenSeats_Economy(Train_class.setSeatStatus(tc.getTakenSeats_Economy(),Integer.parseInt(list.get(i)),true));
                    }
                    addSeatTicket+= "E";

                }
                else if (type.equals("Bus"))
                {
                    for(int i = 0; i < list.size(); i++)
                    {
                        tc.setTakenSeats_Business(Train_class.setSeatStatus(tc.getTakenSeats_Business(),Integer.parseInt(list.get(i)),true));

                    }
                    addSeatTicket+= "B";

                }
                else
                {
                    for(int i = 0; i < list.size(); i++)
                    {
                        tc.setTakenSeats_First(Train_class.setSeatStatus(tc.getTakenSeats_First(),Integer.parseInt(list.get(i)),true));
                    }
                    addSeatTicket+= "F";

                }
                DecimalFormat decimalFormat = new DecimalFormat("#.##");


                for (int i = 0; i < list.size(); i++) {
                    Ticket ticket = new Ticket();
                    LocalTime localTime = LocalTime.now();
                    ticket.setTicket_No((localTime+""));
                    ticket.setSource(t.getSource_stn());
                    ticket.setDestination(t.getDestination_stn());
                    ticket.setPassenger_Name(userName);
                    ticket.setTrain_id(t.getTrain_id());
                    ticket.setClassType(type);
                    ticket.setTrain_No(t.getTrain_id());
                    ticket.setDate(finalA.get(0).getDay_available());
                    ticket.setSeat(addSeatTicket + list.get(i));
                    ticket.setStatusPay("PAYED");
                    double format = Double.parseDouble(decimalFormat.format(seatPrice));
                    ticket.setPrice(format);
                    myDatabase.ticketDao().insert(ticket);


                }



                Intent intent = new Intent(User_buy_ticket.this, Paypal.class);
                intent.putExtra("money",pay.getText().toString());
                User u = myDatabase.userDao().getUserByMail(userName);
                coin += 1;
                double formatCoin = Double.parseDouble(decimalFormat.format(coin));
                u.setCoin(formatCoin);
                myDatabase.userDao().update(u);
                myDatabase.trainClassDao().update(tc);
                startActivityForResult(intent,MainActivity.REQUEST_CODE_USER_CHOOSE_PAY);


            }
        });

        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pay.getText().toString().equals("0"))
                {
                    String addSeatTicket = "";
                    if(type.equals("Eco"))
                    {
                        for(int i = 0; i < list.size(); i++)
                        {
                            tc.setTakenSeats_Economy(Train_class.setSeatStatus(tc.getTakenSeats_Economy(),Integer.parseInt(list.get(i)),true));
                        }
                        addSeatTicket+= "E";
                    }
                    else if (type.equals("Bus"))
                    {
                        for(int i = 0; i < list.size(); i++)
                        {
                            tc.setTakenSeats_Business(Train_class.setSeatStatus(tc.getTakenSeats_Business(),Integer.parseInt(list.get(i)),true));

                        }
                        addSeatTicket+= "B";
                    }
                    else
                    {
                        for(int i = 0; i < list.size(); i++)
                        {
                            tc.setTakenSeats_First(Train_class.setSeatStatus(tc.getTakenSeats_First(),Integer.parseInt(list.get(i)),true));
                        }
                        addSeatTicket+= "F";

                    }
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    for (int i = 0; i < list.size(); i++) {
                        Ticket ticket = new Ticket();
                        LocalTime localTime = LocalTime.now();
                        ticket.setTicket_No((localTime + ""));
                        ticket.setSource(t.getSource_stn());
                        ticket.setDestination(t.getDestination_stn());
                        ticket.setPassenger_Name(userName);
                        ticket.setTrain_id(t.getTrain_id());
                        ticket.setClassType(type);
                        ticket.setTrain_No(t.getTrain_id());
                        ticket.setDate(finalA.get(0).getDay_available());
                        ticket.setSeat(addSeatTicket + list.get(i));
                        ticket.setStatusPay("PAYED");
                        double format = Double.parseDouble(decimalFormat.format(seatPrice));
                        ticket.setPrice(format);
                        myDatabase.ticketDao().insert(ticket);
                    }
                    User u = myDatabase.userDao().getUserByMail(userName);
                    coin += 1;
                    double formatCoin = Double.parseDouble(decimalFormat.format(coin));
                    u.setCoin(formatCoin);
                    myDatabase.userDao().update(u);
                    myDatabase.trainClassDao().update(tc);
                    setResult(RESULT_OK);
                    finish();

                }
                else
                {

                    String addSeatTicket = "";
                    if(type.equals("Eco"))
                    {
                        for(int i = 0; i < list.size(); i++)
                        {
                            tc.setTakenSeats_Economy(Train_class.setSeatStatus(tc.getTakenSeats_Economy(),Integer.parseInt(list.get(i)),true));
                        }
                        addSeatTicket+= "E";
                    }
                    else if (type.equals("Bus"))
                    {
                        for(int i = 0; i < list.size(); i++)
                        {
                            tc.setTakenSeats_Business(Train_class.setSeatStatus(tc.getTakenSeats_Business(),Integer.parseInt(list.get(i)),true));

                        }
                        addSeatTicket+= "B";
                    }
                    else
                    {
                        for(int i = 0; i < list.size(); i++)
                        {
                            tc.setTakenSeats_First(Train_class.setSeatStatus(tc.getTakenSeats_First(),Integer.parseInt(list.get(i)),true));
                        }
                        addSeatTicket+= "F";

                    }
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    for (int i = 0; i < list.size(); i++) {
                        Ticket ticket = new Ticket();
                        LocalTime localTime = LocalTime.now();
                        ticket.setTicket_No((localTime + ""));
                        ticket.setSource(t.getSource_stn());
                        ticket.setDestination(t.getDestination_stn());
                        ticket.setPassenger_Name(userName);
                        ticket.setTrain_id(t.getTrain_id());
                        ticket.setClassType(type);
                        ticket.setTrain_No(t.getTrain_id());
                        ticket.setDate(finalA.get(0).getDay_available());
                        ticket.setSeat(addSeatTicket + list.get(i));
                        ticket.setStatusPay("NOT PAYED");
                        double format = Double.parseDouble(decimalFormat.format(seatPrice));
                        ticket.setPrice(format);
                        myDatabase.ticketDao().insert(ticket);
                    }


                    User u = myDatabase.userDao().getUserByMail(userName);
                    Log.d("====coin:", coin+"");
                    coin += 1;
                    double formatCoin = Double.parseDouble(decimalFormat.format(coin));
                    u.setCoin(formatCoin);
                    myDatabase.userDao().update(u);
                    myDatabase.trainClassDao().update(tc);
                    setResult(RESULT_OK);
                    finish();

                }
            }
        });

    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
                if(resultCode == RESULT_OK)
                {
                    setResult(RESULT_OK);
                    finish();
                }
    }


}
