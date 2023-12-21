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
    Button block, back;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_view_user);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
        first = findViewById(R.id.txtFirst);
        last = findViewById(R.id.txtLast);
        phone = findViewById(R.id.edtPhone);
        block = findViewById(R.id.btBlock);
        dob = findViewById(R.id.edtDob);
        gender = findViewById(R.id.txtGen);
        name = findViewById(R.id.txtName);
        back = findViewById(R.id.btBack);


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
                    setResult(RESULT_OK);
                    finish();
                }
                else
                {

                    user.setBlock(false);
                    myDatabase.userDao().update(user);
                    Toast.makeText(Admin_block_user.this, "Unblock user", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                }

            }

        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

    }

}
