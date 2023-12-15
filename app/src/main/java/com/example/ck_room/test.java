package com.example.ck_room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.Entity.Train_class;
import com.example.ck_room.custom_view.CustomAdapter3;
import com.example.ck_room.custom_view.Seat;

import java.util.ArrayList;
import java.util.List;

public class test extends AppCompatActivity {
    int REQUEST_CODE = 8;
    private RecyclerView recyclerView;
    EditText seat_number;
    TextView text_price;
    MyDatabase myDatabase;
    CustomAdapter3 adapter;
    RadioGroup radioGroup;
    RadioButton radioButton1,radioButton2,radioButton3;
    Button see,back,buy;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_choose_seat);
//        radioGroup = findViewById(R.id.radioGroup);
//        radioButton1 = findViewById(R.id.class1);
//        radioButton2 = findViewById(R.id.class2);
//        radioButton3 = findViewById(R.id.class3);
//        see = findViewById(R.id.see);
//        back = findViewById(R.id.back);
//        buy = findViewById(R.id.buy);
//        text_price = findViewById(R.id.price);
//        seat_number = findViewById(R.id.choose_seat);
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent resultIntent = new Intent();
//                setResult(RESULT_OK, resultIntent);
//                finish();
//            }
//        });
//        myDatabase = DatabaseManager.getDatabase(getApplicationContext());
//        Intent intent = getIntent();
//        String id = intent.getStringExtra("id");
//        Train_class trainClass = myDatabase.trainClassDao().getTrainClassById(Integer.parseInt(id));
//
//        see.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                List<Integer> list_interger = new ArrayList<>();
////                if(radioButton1.isChecked())
////                {
////                    list_interger = trainClass.getAvailableSeats(trainClass.getTakenSeats_Class1());
////                    text_price.setText(trainClass.getFare_Class1() +"");
////
////                }
////                else if(radioButton2.isChecked())
////                {
////                    list_interger = trainClass.getAvailableSeats(trainClass.getTakenSeats_Class2());
////                    text_price.setText(trainClass.getFare_Class2() +"");
////
////
////                }
////                else
////                {
////                    list_interger = trainClass.getAvailableSeats(trainClass.getTakenSeats_Class3());
////                    text_price.setText(trainClass.getFare_Class3() +"");
////                }
//
//                String s = "price: " +text_price.getText().toString();
//                text_price.setText(s);
//                text_price.setVisibility(View.VISIBLE);
//                List<Seat> list_seat= new ArrayList<>();
//                for (int i = 0; i < list_interger.size(); i = i+4)
//                {
//                    Seat a = new Seat(i+"",(i+1)+"",(i+2)+"",i+3+"");
//                    list_seat.add(a);
//                }
//
//                recyclerView = findViewById(R.id.recyclerView);
//                recyclerView.setLayoutManager(new LinearLayoutManager(User_choose_seat.this));
//                adapter = new CustomAdapter3(list_seat, User_choose_seat.this);
//                recyclerView.setAdapter(adapter);
//
//            }
//        });
//
//    buy.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if(seat_number.getText().toString().isEmpty() == false)
//            {Intent in = new Intent(User_choose_seat.this, User_select_payment.class);
//
//                in.putExtra("id",id);
//                in.putExtra("seat",seat_number.getText().toString());
//                startActivityForResult(in,REQUEST_CODE);
//
//            }
//            else
//            {
//                Toast.makeText(User_choose_seat.this, "filling seat", Toast.LENGTH_SHORT).show();
//            }
//
//        }
//    });
        RecyclerView recyclerView = findViewById(R.id.recyclerViewmanage);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4)); // 4 columns for 4 rows


        List<String> seatList = generateSeatList(); // Replace with your data source

        SeatAdapter seatAdapter = new SeatAdapter(this, seatList);
        recyclerView.setAdapter(seatAdapter);
    }
    private List<String> generateSeatList() {
        // Replace this with logic to generate your list of seat numbers
        List<String> seatList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            seatList.add("" + i);
        }
        return seatList;
    }

    public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.SeatViewHolder> {

        private Context context;
        private List<String> seatList;

        public SeatAdapter(Context context, List<String> seatList) {
            this.context = context;
            this.seatList = seatList;
        }

        @NonNull
        @Override
        public SeatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.seat_item, parent, false);
            return new SeatViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SeatViewHolder holder, int position) {
            String seatNumber = seatList.get(position);
            holder.txtNumber.setText(seatNumber);

            // Customize the view based on seat status (e.g., available, selected)
            // You can add more logic here as needed.
        }

        @Override
        public int getItemCount() {
            return seatList.size();
        }

        public class SeatViewHolder extends RecyclerView.ViewHolder {
            TextView txtNumber;

            public SeatViewHolder(@NonNull View itemView) {
                super(itemView);
                txtNumber = itemView.findViewById(R.id.txtNumber);
                // Add references to other views as needed.
            }
        }
    }
}
