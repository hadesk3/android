package com.example.ck_room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Mail;
import com.example.ck_room.Entity.Ticket;
import com.example.ck_room.Entity.Train;

public class User_share_mail extends AppCompatActivity {
    EditText phone;
    Button back, share_mail;
    MyDatabase myDatabase;
    public String phoneNumber = "";
    public  String mess = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_share_mail);
        myDatabase =  DatabaseManager.getDatabase(getApplicationContext());
        phone =findViewById(R.id.phone);
        back = findViewById(R.id.btBack);
        share_mail = findViewById(R.id.butSend);
        Intent intent = getIntent();
        String id_ticket = intent.getStringExtra("idTicket");

        Ticket ticket = myDatabase.ticketDao().getTicketByTicketNo(id_ticket);
        Train t = myDatabase.trainDao().getTrainById(ticket.getTrain_id()).get(0);
        String content = "";
        content += "Ticket id: " +ticket.getTicket_No() + "\n";
        content += "Train name: " + t.getTrain_name() + "\n";
        content += "Date: " + ticket.getDate() + "\n";
        content += "Time: " + t.getTimeStart() + " to " +t.getTimeEnd() + "\n";
        content += "Depart from: " + t.getSource_stn() + "\n";
        content += "Arrive at: " + t.getDestination_stn() + "\n";
        content += "Class: " + ticket.getClassType() + "\n";
        content += "Seat place: " + ticket.getSeat() + "\n";



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        String finalContent = content;

        share_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phone.getText().toString() != null)
                {
                    phoneNumber = phone.getText().toString();
                    mess = "" + finalContent;
                    sendEmail(phoneNumber,mess);

                }

            }
        });




    }
    private void sendEmail(String email, String message) {
        String subject = "Sign up";
        message =  "Your pass is "+  message;

        Mail sendMailTask = new Mail(email, subject, message);
        sendMailTask.execute();
    }
}
