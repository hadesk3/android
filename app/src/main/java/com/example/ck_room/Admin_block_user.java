package com.example.ck_room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.User;

public class Admin_block_user extends AppCompatActivity {
    TextView name, gender, dob;
    TextView phone, first, last ;
    Button block;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_view_user);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
        first = findViewById(R.id.edtFirst);
        last = findViewById(R.id.edtLast);
        phone = findViewById(R.id.edtPhone);
        block = findViewById(R.id.btBlock);
        dob = findViewById(R.id.edtDob);
        gender = findViewById(R.id.edtGe);
        name = findViewById(R.id.txtName);


        Intent intent = getIntent();
        String  username = intent.getStringExtra("username")  ;
        User user = myDatabase.userDao().getUserByMail(username);

        if(user == null)
        {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
        }
        else
        {
            name.setText(user.getLastName() + " " + user.getFirstName());
            phone.setText(user.getPhone());
            dob.setText(user.getDob());
            last.setText(user.getLastName());
            first.setText(user.getFirstName());
            last.setText(user.getLastName());
            gender.setText(user.getGender());

        }

        block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(user.isBlock() == false)
                {
                    user.setBlock(true);
                    myDatabase.userDao().update(user);
                    Toast.makeText(Admin_block_user.this, "blocked user", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    user.setBlock(false);
                    myDatabase.userDao().update(user);

                    Toast.makeText(Admin_block_user.this, "Unblock user", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

}
