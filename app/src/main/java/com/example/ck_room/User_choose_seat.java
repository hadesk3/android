    package com.example.ck_room;

    import android.content.Intent;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.GridLayoutManager;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.example.ck_room.DataConfig.DatabaseManager;
    import com.example.ck_room.DataConfig.MyDatabase;
    import com.example.ck_room.Entity.Day_available;
    import com.example.ck_room.Entity.Train;
    import com.example.ck_room.Entity.Train_class;
    import com.example.ck_room.custom_view.CustomAdapter;
    import com.example.ck_room.custom_view.CustomAdapter2;
    import com.example.ck_room.custom_view.CustomAdapter3;
    import com.example.ck_room.custom_view.CustomAdapter_user;
    import com.example.ck_room.custom_view.CustomAdapter_user_seat;
    import com.example.ck_room.custom_view.Seat;

    import java.util.ArrayList;
    import java.util.List;

    public class User_choose_seat extends AppCompatActivity {
        int REQUEST_CODE = 8;
        TextView name,date,time, price ,seat;
        MyDatabase myDatabase;
        RadioGroup radioGroup;
        RadioButton radioEco,radioFirst,radioBus;
        List<Integer> list;
        Button next;
        int id;
        private List<String> itemList;


        private CustomAdapter_user_seat adapter3;
        private RecyclerView recyclerView;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.user_choose_seat);
            name = findViewById(R.id.textView15);
            date = findViewById(R.id.textView29);
            time = findViewById(R.id.textView31);
            radioGroup = findViewById(R.id.radioGroup);
            radioEco = findViewById(R.id.radEco);
            radioBus = findViewById(R.id.radBus);
            radioFirst = findViewById(R.id.radFirst);
            price = findViewById(R.id.textView10);
            seat = findViewById(R.id.textView11);
            next = findViewById(R.id.btNext);
            myDatabase = DatabaseManager.getDatabase(getApplicationContext());

            Intent intent = getIntent();
            id = intent.getIntExtra("id",0)  -1;
            Train t = myDatabase.trainDao().getAllTrains().get(id);
            Toast.makeText(this, t.toString(), Toast.LENGTH_SHORT).show();
            name.setText(t.getTrain_name());
            time.setText(t.getTimeStart()+":"+t.getTimeEnd());

            List<Day_available> a =  new ArrayList<>();
            a =myDatabase.dateAvailableDao().getDayAvailableByTrainId(id + 1);

            Train_class t_c = new Train_class();
            t_c = myDatabase.trainClassDao().getTrainClassById(id +1);

            date.setText(a.get(0).getDay_available());

                list = new ArrayList<>();
            Train_class finalT_c = t_c;
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (checkedId == radioEco.getId()) {
                        // Xử lý khi RadioButton "radioEco" được chọn

                        String s = finalT_c.getTakenSeats_Business();

                        List<String> check = new ArrayList<>();

                        for (int i = 0; i < s.length(); i++) {
                            char c = s.charAt(i);
                            int number = Character.getNumericValue(c);
                            check.add(number + "");
                        }

                        itemList = new ArrayList<>();
                        for(int i = 0; i < check.size();i++)
                        {
                                itemList.add(i + "");
                        }

                        recyclerView = findViewById(R.id.recyclerViewmanage);
                        recyclerView.setLayoutManager(new GridLayoutManager(User_choose_seat.this, 4)); // 4 columns for 4 rows

                        adapter3 = new CustomAdapter_user_seat(itemList,check,User_choose_seat.this, price,seat,finalT_c.getEconomy_Fare());
                        recyclerView.setAdapter(adapter3);

                        Toast.makeText(getApplicationContext(), "Bạn đã chọn radioEco", Toast.LENGTH_SHORT).show();
                    } else if (checkedId == radioBus.getId()) {
                        // Xử lý khi RadioButton "radioBus" được chọn

                    } else if (checkedId == radioFirst.getId())
                    {

                    }





                }
            });




            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<String> a = adapter3.getUserChoose();

                    Intent intent = new Intent(User_choose_seat.this, User_buy_ticket.class);
                    ArrayList<String> arrayList = new ArrayList<>(a);
                    intent.putStringArrayListExtra("list", arrayList);
                    intent.putExtra("totalSeat",seat.getText().toString())  ;
                    intent.putExtra("totalPrice",price.getText().toString())  ;
                    startActivity(intent);
                }
            });





        }
    }
