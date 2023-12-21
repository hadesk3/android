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

import com.example.ck_room.DataConfig.DatabaseManager;
import com.example.ck_room.DataConfig.MyDatabase;
import com.example.ck_room.MainActivity;
import com.example.ck_room.R;
import com.example.ck_room.User_Search;
import com.example.ck_room.User_view_train;

import java.util.List;

public class CustomAdapter_user extends RecyclerView.Adapter<CustomAdapter_user.ViewHolder> {

    private List<String> itemListName;
    private List<String> itemListPlace;
    private List<String> itemListTime;

    private List<String> itemListSource;
    private List<String> itemListDes;
    private List<String> itemListDay;
    MyDatabase myDatabase;

    private Context context;

    public CustomAdapter_user(List<String> itemListName,List<String> itemListPlace,List<String> itemListTime, Context context,List<String> itemListSource,List<String> itemListDes, List<String> itemListDay) {
        this.itemListName = itemListName;
        this.itemListPlace = itemListPlace;
        this.itemListTime = itemListTime;
        this.itemListSource = itemListSource;
        this.itemListDes = itemListDes;
        this.itemListDay = itemListDay;
        this.context = context;
        myDatabase = DatabaseManager.getDatabase(context.getApplicationContext());


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.train_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = itemListName.get(position);
        String place = itemListPlace.get(position);
        String time = itemListTime.get(position);

        String source = itemListSource.get(position);
        String des = itemListDes.get(position);
        String date = itemListDay.get(position);

        holder.name.setText(name);
        holder.place.setText(place);
        holder.time.setText(time);



        holder.itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id =  myDatabase.trainDao().findTrainsByStationsAndDay(source,des,date).get(0).getTrain_id();
                startUserChooseSeatActivity(id);
            }
        });
    }
    private void startUserChooseSeatActivity(int id) {
        Intent intent = new Intent(context, User_view_train.class);
        intent.putExtra("id", id);
        intent.putExtra("username", ((User_Search) context).getUsername());
        ((Activity) context).startActivityForResult(intent, MainActivity.REQUEST_CODE_USER_VIEW_TRAIN);
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
            itemButton = itemView.findViewById(R.id.txtPrice);
        }
    }
}
