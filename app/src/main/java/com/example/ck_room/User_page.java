package com.example.ck_room;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.example.ck_room.Entity.User;
import com.paypal.android.sdk.ch;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class User_page extends AppCompatActivity {
    int REQUEST_CODE = 4;
    ImageButton edit,check,buy,history,changePass;
    TextView menu;
    Button help;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_page);
        edit = findViewById(R.id.btUser);
        check = findViewById(R.id.btHistory);
        buy = findViewById(R.id.btBooking);
        changePass = findViewById(R.id.btPassword);
        menu = findViewById(R.id.txtMenu);
        history = findViewById(R.id.btHistory);
        help = findViewById(R.id.help);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_page.this, Call.class);
                startActivityForResult(intent, 123);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_page.this,User_history.class);
                intent.putExtra("username",username);

                startActivityForResult(intent,MainActivity.REQUEST_CODE_EDIT_PROFILE);

            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_page.this,User_see_menu.class);


                startActivityForResult(intent,MainActivity.REQUEST_CODE_EDIT_PROFILE);
            }
        });



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_page.this,User_edit_profile.class);
                intent.putExtra("username",username);


                startActivityForResult(intent,MainActivity.REQUEST_CODE_EDIT_PROFILE);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_page.this,User_Search.class);
                intent.putExtra("username",username);
                startActivityForResult(intent,MainActivity.REQUEST_CODE_USER_BUY);

            }
        });

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_page.this, User_change_pass.class);
                intent.putExtra("username",username);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });



    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MainActivity.REQUEST_CODE_EDIT_PROFILE) {
            if (resultCode == MainActivity.RESULT_LOGOUT) {
                setResult(MainActivity.RESULT_LOGOUT); // Đặt kết quả là RESULT_LOGOUT để xử lý trong MainActivity
                finish();
            }
        }
    }


}
