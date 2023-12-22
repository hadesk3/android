package com.example.ck_room;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.Manifest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.User;



public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 0;
    private static final int REQUEST_CALL_PHONE_PERMISSION = 1;
    public static final int REQUEST_CODE_USER_PAGE = 4 ;
    public static final int REQUEST_CODE_EDIT_PROFILE = 20;
    public static final int RESULT_LOGOUT = 100;

    public static final int REQUEST_CODE_ADMIN_PAGE = 5 ;
    public static final int REQUEST_CODE_ADMIN_MANAGE_STATION = 6 ;
    public static final int REQUEST_CODE_ADMIN_EDIT_STATION = 7 ;
    public static final int REQUEST_CODE_ADMIN_CREATE_STATION = 8 ;
    public static final int REQUEST_CODE_ADMIN_MANAGE_USER = 9 ;
    public static final int REQUEST_CODE_ADMIN_MANAGE_USER_BLOCK = 10 ;
    public static final int REQUEST_CODE_ADMIN_MANAGE_TRAIN = 11 ;
    public static final int REQUEST_CODE_ADMIN_CREATE_TRAIN = 12 ;
    public static final int REQUEST_CODE_ADMIN_EDIT_TRAIN = 13 ;
    public static final int REQUEST_CODE_USER_BUY = 14 ;
    public static final int REQUEST_CODE_USER_VIEW_TRAIN = 15 ;
    public static final int REQUEST_CODE_USER_CHOOSE_SEAT = 16 ;
    public static final int REQUEST_CODE_USER_PAY = 17 ;
    public static final int REQUEST_CODE_USER_CHOOSE_PAY = 18 ;

    public static final int REQUEST_CODE_USER_SEE_MENU = 19 ;

    public static final int REQUEST_CODE_USER_SHARE = 20 ;

    EditText username, pass;
    Button login;
    TextView register;

    boolean passwordVisible;
    private MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_in);
        username = findViewById(R.id.edtCurrent);
        pass = findViewById(R.id.edtPassword);
        login = findViewById(R.id.btSignUp);
        register = findViewById(R.id.txtSignIn);

        myDatabase = DatabaseManager.getDatabase(getApplicationContext());

        //Register text
        SpannableString spannableString = new SpannableString("Don't have an account? Sign up here");

        int loginHereStart = "Don't have an account? ".length();

        int loginHereEnd = spannableString.length();

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Xử lý sự kiện, ví dụ: chuyển hướng đến trang đăng nhập
                Intent intent = new Intent(MainActivity.this, Sign_up.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        };
        spannableString.setSpan(clickableSpan, loginHereStart, loginHereEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), loginHereStart, loginHereEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        register.setText(spannableString);

        register.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());

        //Password toggle
        pass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final int Right = 2;

                if (event.getAction() == MotionEvent.ACTION_UP){

                    if (event.getRawX() >= pass.getRight() - pass.getCompoundDrawables()[Right].getBounds().width()){

                        int selection = pass.getSelectionEnd();

                        if (passwordVisible){

                            pass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_off_24, 0);

                            pass.setTransformationMethod(PasswordTransformationMethod.getInstance());

                            passwordVisible = false;
                        }
                        else{

                            pass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_24, 0);

                            pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());


                            passwordVisible = true;
                        }
                        pass.setSelection(selection);

                        return true;
                    }
                }
                return  false;
            }
        });





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = myDatabase.userDao().getUserByMail(username.getText().toString());
                if(username.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
                {
                    Intent intent = new Intent(MainActivity.this,Admin_page.class);
                    startActivityForResult(intent,REQUEST_CODE_ADMIN_PAGE);

                }
                else
                {
                   if(user != null && pass.getText().toString().equals(user.getPass()) && user.isBlock() == false)
                    {
                        Intent intent = new Intent(MainActivity.this,User_page.class);

                        intent.putExtra("username",user.getUserName());

                        startActivityForResult(intent,REQUEST_CODE_USER_PAGE);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Error, user not found or blocked", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_USER_PAGE) {
            if (resultCode == RESULT_OK) {
                // Xử lý khi quay lại từ User_page thành công
            } else if (resultCode == RESULT_LOGOUT) {
                // Xử lý khi quay về từ User_page sau khi logout
            }
        }
    }




}