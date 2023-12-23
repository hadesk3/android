package com.example.ck_room.custom_view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.R;
import com.example.ck_room.User_see_ticket_detail;

import java.util.List;

public class CustomAdapter_user_see_history extends RecyclerView.Adapter<CustomAdapter_user_see_history.ViewHolder3> {
    private List<String> itemList;
    private List<String> itemType;
    private List<String> itemPrice;
    private List<String> ticketid;
    private List<String> ticketStatus;

    private Context context;


    public CustomAdapter_user_see_history(List<String> itemList,List<String> itemType,List<String> itemPrice,List<String> ticketid,List<String> ticketStatus, Context context) {
        this.itemList = itemList;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
        this.ticketid = ticketid;
        this.ticketStatus = ticketStatus;

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_ticket_item, parent, false);
        return new ViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder3 holder, int position) {
        String name = itemList.get(position);
        String type = itemType.get(position);
        String price = itemPrice.get(position);
        String id = ticketid.get(position);
        String sta = ticketStatus.get(position);
        holder.text1.setText(name);
        holder.text2.setText(type);
        holder.text3.setText(price);
        holder.text4.setText(sta);
        Log.d("================================",sta);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startUserChooseSeatActivity(id);
            }
        });
    }


    @Override
    public int getItemCount() {
        return itemList.size();

    }

    private void startUserChooseSeatActivity(String id) {
        Intent intent = new Intent(context, User_see_ticket_detail.class);
        intent.putExtra("idTicket", id);
        Log.d("id ticket", id);
        context.startActivity(intent);
    }


    public static class ViewHolder3 extends RecyclerView.ViewHolder {
        // ...
        TextView text1;
        TextView text2;
        TextView text3;
        TextView text4;

        Button button;
        public ViewHolder3(View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.txtTrip);
            text2 = itemView.findViewById(R.id.txtDate);
            text3 = itemView.findViewById(R.id.txtTime);
            text4 = itemView.findViewById(R.id.textView17);
            button = itemView.findViewById(R.id.btView);
        }
    }
}