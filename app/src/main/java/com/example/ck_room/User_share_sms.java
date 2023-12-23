package com.example.ck_room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Mail;
import com.example.ck_room.Entity.Ticket;
import com.example.ck_room.Entity.Train;

public class User_share_sms extends AppCompatActivity
{
    private static final int REQUEST_SEND_SMS_PERMISSION = 1;

    EditText phone;
    Button back, share_sms;
    MyDatabase myDatabase;
    public String phoneNumber = "";
    public  String mess = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_share);
        myDatabase =  DatabaseManager.getDatabase(getApplicationContext());
        phone =findViewById(R.id.phone);
        back = findViewById(R.id.btBack);
        share_sms = findViewById(R.id.butSend);
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
        share_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phone.getText().toString() != null)
                {
                    phoneNumber = phone.getText().toString();
                    mess = "" + finalContent;
                    sendSMS(phoneNumber,mess);
                }

            }
        });






    }
    private void sendSMS(String phoneNumber,String message) {

        Uri smsUri = Uri.parse("smsto:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, smsUri);
        intent.putExtra("sms_body", message);

        if (ContextCompat.checkSelfPermission(User_share_sms.this, android.Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            startActivityForResult(intent, 100000000);
        } else {
            ActivityCompat.requestPermissions(User_share_sms.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SEND_SMS_PERMISSION);
        }
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_SEND_SMS_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendSMS( phoneNumber, mess);

            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100000000) {
            if (resultCode == RESULT_OK) {
            } else {
            }

            // Kết thúc hoạt động hiện tại
            setResult(RESULT_CANCELED);
            finish();
        }
}}
