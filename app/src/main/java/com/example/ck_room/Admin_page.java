package com.example.ck_room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Station;
import com.example.ck_room.Entity.Ticket;
import com.example.ck_room.Entity.User;

import java.text.DecimalFormat;
import java.util.List;

public class Admin_page extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    /*   Button butAddTrain,getButAddTrainStatus, butAddRoute,butAddStation, butProfile,butManageTrain;
       Button back;*/
    Button back;
    MyDatabase myDatabase;

    TextView total_user, total_station, total_ticket, total_money;
    ImageButton butManageTrain, btStation, btManageUser, btLogout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());

        butManageTrain = findViewById(R.id.btTrain);
        btStation = findViewById(R.id.btStation);
        btManageUser = findViewById(R.id.btUser);
        total_money = findViewById(R.id.txtTicket3);
        total_user = findViewById(R.id.txtUser);
        total_station = findViewById(R.id.txtUser3);
        total_ticket = findViewById(R.id.txtTicket);

        double totalPrice = 0;
        List<User> lUser = myDatabase.userDao().getAllUser();
        List<Ticket> lTicket = myDatabase.ticketDao().getAllTickets();
        List<Station> lStation = myDatabase.stationDao().getAllStations();
        for (int i = 0; i < lTicket.size(); i++) {
            totalPrice += lTicket.get(i).getPrice();
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        total_ticket.setText(lTicket.size() + "");
        total_station.setText(lStation.size() + "");
        total_money.setText(decimalFormat.format(totalPrice));
        total_user.setText(lUser.size() + "");

        btLogout = findViewById(R.id.btLogout);
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(MainActivity.RESULT_LOGOUT);
                startActivity(new Intent(Admin_page.this, MainActivity.class));
                finish();
            }
        });
        butManageTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_page.this, Admin_manageTrain_page.class);
                startActivityForResult(intent, MainActivity.REQUEST_CODE_ADMIN_MANAGE_TRAIN);
            }
        });
        btStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_page.this, Admin_manage_station.class);
                startActivityForResult(intent, MainActivity.REQUEST_CODE_ADMIN_MANAGE_STATION);
            }

        });

        btManageUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_page.this, Admin_manage_profile.class);
                startActivityForResult(intent, MainActivity.REQUEST_CODE_ADMIN_MANAGE_USER);

            }
        });



       /*
        butAddTrain = findViewById(R.id.add_train);
        getButAddTrainStatus = findViewById(R.id.add_train_status);
        butAddRoute = findViewById(R.id.add_route);
        butAddStation = findViewById(R.id.add_station);
        butManageTrain = findViewById(R.id.manage_train);
        butProfile = findViewById(R.id.manage_profile);
        back = findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        butAddTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_page.this,Add_Train.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

        butAddStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_page.this,Add_station.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        butAddRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_page.this,Add_route.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

*/


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        double totalPrice = 0;
        List<User> lUser = myDatabase.userDao().getAllUser();
        List<Ticket> lTicket = myDatabase.ticketDao().getAllTickets();
        List<Station> lStation = myDatabase.stationDao().getAllStations();
        for (int i = 0; i < lTicket.size(); i++) {
            totalPrice += lTicket.get(i).getPrice();
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        total_ticket.setText(lTicket.size() + "");
        total_station.setText(lStation.size() + "");
        total_money.setText(decimalFormat.format(totalPrice));
        total_user.setText(lUser.size() + "");
    }

}
