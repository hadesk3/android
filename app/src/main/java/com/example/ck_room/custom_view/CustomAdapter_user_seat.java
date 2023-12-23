package com.example.ck_room.custom_view;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.Admin_edit_Train;
import com.example.ck_room.R;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter_user_seat extends RecyclerView.Adapter<CustomAdapter_user_seat.ViewHolder> {

    private List<String> itemListName;
    private List<String> check;
    private TextView price,seat;
    private double fare;
    private Context context;
    private List<String> user_choose_seat;


    private boolean[] isSelected; // Mảng lưu trữ trạng thái của các phần tử
    private double totalPrice = 0; // Tổng giá trị của các phần tử được chọn
    private int totalSeat = 0;
    public CustomAdapter_user_seat(List<String> itemList,List<String> check, Context context, TextView price,TextView seat, double fare) {
        this.itemListName = itemList;
        this.check =check;
        this.price = price;
        this.seat = seat;
        this.context = context;
        this.fare = fare;
        this.isSelected = new boolean[itemList.size()];
        this.user_choose_seat = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_seat_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String number = itemListName.get(position);
        String check_seat = check.get(position);
        holder.number.setText(number);
        holder.number.setOnClickListener(new View.OnClickListener() {
            boolean isImage1 = true; // Biến đánh dấu trạng thái hiện tại của hình ảnh

            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition(); // Retrieve the current adapter position

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    if ( check_seat.equals("0")) {
                        boolean isImage1 = !isSelected[adapterPosition]; // Toggle the selected state

                        if (isImage1) {
                            holder.image.setImageResource(R.drawable.baseline_chair_24);
                            totalPrice += fare; // Add fare to the total price
                            totalSeat += 1;
                            user_choose_seat.add(number);
                        } else {
                            holder.image.setImageResource(R.drawable.baseline_chair_1);
                            totalPrice -= fare; // Subtract fare from the total price
                            totalSeat -= 1;
                            user_choose_seat.remove(number);
                        }

                        DecimalFormat decimalFormat = new DecimalFormat("#.##");
                        String roundedNumber = decimalFormat.format(totalPrice);

                        isSelected[adapterPosition] = isImage1; // Save the selected state in the isSelected array
                        price.setText(String.valueOf(roundedNumber)); // Update the total price in the TextView price
                        seat.setText(totalSeat+"");
                    }
                }
            }
        });

        if(check_seat.equals("0"))
            {
                holder.image.setImageResource(R.drawable.baseline_chair_1);

            }
        else
        {
            holder.image.setImageResource(R.drawable.baseline_chair_2);

        }



    }
    private void startUserChooseSeatActivity(int id) {
        id = id + 1;
        Intent intent = new Intent(context, Admin_edit_Train.class);
        intent.putExtra("id", id);
        Toast.makeText(context, id + "", Toast.LENGTH_SHORT).show();
        context.startActivity(intent);
    }

    public List<String> getUserChoose() {
        return this.user_choose_seat;
    }
    @Override
    public int getItemCount() {
        return itemListName.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView number;

        ImageView image;
        public ImageButton itemButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.txtNumber);
            image = itemView.findViewById(R.id.textViewSeatNumber);
        }
    }


}