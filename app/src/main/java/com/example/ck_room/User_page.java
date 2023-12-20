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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.example.ck_room.Entity.User;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class User_page extends AppCompatActivity {
    int REQUEST_CODE = 4;
    ImageButton edit,check,buy,back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.user_page);
        edit = findViewById(R.id.btUser);
        check = findViewById(R.id.btHistory);
        buy = findViewById(R.id.btBooking);
        //back = findViewById(R.id.back);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_page.this,User_edit_profile.class);
                intent.putExtra("username",username);


                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_page.this,User_Search.class);
                intent.putExtra("username",username);
                startActivityForResult(intent,REQUEST_CODE);

            }
        });
    }



}
