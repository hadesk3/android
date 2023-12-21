package com.example.ck_room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.User;

public class User_change_pass extends AppCompatActivity {
    EditText current, passNew, confirm;
    Button save,back;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_change_password);
        myDatabase = DatabaseManager.getDatabase(getApplicationContext());

        current = findViewById(R.id.edtCurrent);
        passNew = findViewById(R.id.edtNew);
        confirm = findViewById(R.id.edtConfirm);
        save = findViewById(R.id.btBlock);
        back = findViewById(R.id.btBack);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        User u = myDatabase.userDao().getUserByMail(username);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current.getText().toString() != null && passNew.getText().toString() != null && confirm.getText().toString() != null)
                {
                    if(current.getText().toString().equals(u.getPass()))
                    {
                        if(confirm.getText().toString().equals(passNew.getText().toString()))
                        {
                            u.setPass(passNew.getText().toString());
                            myDatabase.userDao().update(u);
                            Toast.makeText(User_change_pass.this, "Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            setResult(RESULT_OK, intent);
                            finish();

                        }
                        else
                        {
                            Toast.makeText(User_change_pass.this, "New pass and confirm pass have to the same", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else if (current.getText().toString().equals(u.getPass()) == false)
                    {
                        Toast.makeText(User_change_pass.this, "Wrong password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
