package com.example.ck_room.custom_view;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.Edit_Train;
import com.example.ck_room.R;


import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<String> itemListName;
    private List<String> itemListPlace;
    private List<String> itemListTime;


    private Context context;

    public CustomAdapter(List<String> itemListName,List<String> itemListPlace,List<String> itemListTime, Context context) {
        this.itemListName = itemListName;
        this.itemListPlace = itemListPlace;
        this.itemListTime = itemListTime;

        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = itemListName.get(position);
        String place = itemListPlace.get(position);
        String time = itemListTime.get(position);

        holder.name.setText(name);
        holder.place.setText(place);
        holder.time.setText(time);
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
        Intent intent = new Intent(context, Edit_Train.class);
        intent.putExtra("id", id);
        Toast.makeText(context, id + "", Toast.LENGTH_SHORT).show();
        context.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        return itemListName.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView place;
        public TextView time;

        public ImageButton itemButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            place = itemView.findViewById(R.id.txtPlace);
            time = itemView.findViewById(R.id.txtTime);
            itemButton = itemView.findViewById(R.id.itemButton);
        }
    }
}