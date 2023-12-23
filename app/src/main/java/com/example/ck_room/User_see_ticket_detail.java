package com.example.ck_room;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Ticket;
import com.example.ck_room.Entity.Train;

public class User_see_ticket_detail extends AppCompatActivity {
    MyDatabase myDatabase;
    TextView code,seat,nameTrain,start,end,source,des,date,class_type, edtStatus;
    Button back;
    ImageView share;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_ticket);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
        edtStatus = findViewById(R.id.edtStatus);
        nameTrain = findViewById(R.id.edtName);
        code = findViewById(R.id.edtCode);
        start = findViewById(R.id.edtStart);
        end = findViewById(R.id.edtEnd);
        date = findViewById(R.id.edtDate);
        source = findViewById(R.id.edtFrom);
        des = findViewById(R.id.edtArrive);
        class_type = findViewById(R.id.edtClass);
        seat = findViewById(R.id.edtSeat);
        back = findViewById(R.id.btBack3);
        share = findViewById(R.id.btShare);




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        Intent intent = getIntent();
        String id_ticket =intent.getStringExtra("idTicket");
        Ticket ticket = myDatabase.ticketDao().getTicketByTicketNo(id_ticket);
        Train t = myDatabase.trainDao().getTrainById(ticket.getTrain_id()).get(0);

        nameTrain.setText(t.getTrain_name());
        code.setText(ticket.getTicket_No());
        start.setText(t.getTimeStart());
        end.setText(t.getTimeEnd());
        date.setText(ticket.getDate());
        source.setText(t.getSource_stn());
        des.setText(t.getDestination_stn());
        class_type.setText(ticket.getClassType());
        Log.d("seat========",ticket.getSeat());
        seat.setText(ticket.getSeat());
        if(ticket.getStatusPay().equals("PAYED"))
        {
            edtStatus.setText("PAYED");
            int color = Color.parseColor("#00FF00");

            edtStatus.setBackgroundColor(color);
        }
        else
        {
            edtStatus.setText("UNPAID");
        }
        source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_address = source.getText().toString();

                String detail = myDatabase.stationDao().getStationByName(get_address).getAddress();
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

                String detail = myDatabase.stationDao().getStationByName(get_address).getAddress();
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

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_see_ticket_detail.this, User_share_sms.class);
                intent.putExtra("idTicket", id_ticket);
                startActivityForResult(intent, MainActivity.REQUEST_CODE_USER_SHARE);

            }
        });
    }
}
