package com.example.ck_room.custom_view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.Admin_edit_station;
import com.example.ck_room.MainActivity;
import com.example.ck_room.R;

import java.util.List;

public class CustomAdapter_station extends RecyclerView.Adapter<CustomAdapter_station.ViewHolder> {

    private List<String> itemListName;
    private List<String> itemListAdress;


    private Context context;

    public CustomAdapter_station(List<String> itemListName,List<String> itemListAdress, Context context) {
        this.itemListName = itemListName;
        this.itemListAdress = itemListAdress;

        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_station_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = itemListName.get(position);
        String address = itemListAdress.get(position);

        holder.name.setText(name);
        holder.address.setText(address);
        holder.itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                startUserChooseSeatActivity(clickedPosition);
            }
        });
    }
    private void startUserChooseSeatActivity(int id) {
        id = id + 1;
        Intent intent = new Intent(context, Admin_edit_station.class);
        intent.putExtra("id", id);
        ((Activity) context).startActivityForResult(intent, MainActivity.REQUEST_CODE_ADMIN_EDIT_STATION);
    }
    @Override
    public int getItemCount() {
        return itemListName.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView address;

        public ImageButton itemButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            address = itemView.findViewById(R.id.txtPlace);
            itemButton = itemView.findViewById(R.id.btEdit);
        }
    }
}