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

import com.example.ck_room.Admin_block_user;
import com.example.ck_room.Admin_manage_profile;
import com.example.ck_room.MainActivity;
import com.example.ck_room.R;


import java.util.List;

public class CustomAdapter_user_profile extends RecyclerView.Adapter<CustomAdapter_user_profile.ViewHolder> {

    private List<String> Name;
    private List<String> Dob;
    private List<String> Gender;


    private Context context;



    public CustomAdapter_user_profile(List<String> Name, List<String> Dob, List<String> Gender, Context context) {
       this.Name = Name;
       this.Dob = Dob;
       this.Gender = Gender;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nameU = Name.get(position);
        holder.name.setText(nameU);
        String dobU = Dob.get(position);
        holder.dob.setText(dobU);
        String genderU = Gender.get(position);
        holder.gender.setText(genderU);

        holder.itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                startUserChooseSeatActivity(clickedPosition);            }
        });


    }
    private void startUserChooseSeatActivity(int id) {
        Intent intent = new Intent(context, Admin_block_user.class);
        intent.putExtra("username", ((Admin_manage_profile) context).getUsernameToEdit());
        ((Activity) context).startActivityForResult(intent, MainActivity.REQUEST_CODE_ADMIN_MANAGE_USER_BLOCK);

    }

    @Override
    public int getItemCount() {
        return Name.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView dob;
        public TextView gender;
        public ImageButton itemButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            dob = itemView.findViewById(R.id.txtPlace);
            gender = itemView.findViewById(R.id.txtTime);
            itemButton = itemView.findViewById(R.id.txtPrice);

        }
    }


}