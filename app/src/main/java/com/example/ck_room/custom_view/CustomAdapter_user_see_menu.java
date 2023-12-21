package com.example.ck_room.custom_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ck_room.R;

import java.util.List;

public class CustomAdapter_user_see_menu extends RecyclerView.Adapter<CustomAdapter_user_see_menu.ViewHolder3> {
    private List<String> itemList;
    private List<String> itemType;
    private List<String> itemPrice;
    private List<String> drawable;

    private Context context;


    public CustomAdapter_user_see_menu(List<String> itemList,List<String> itemType,List<String> itemPrice,List<String> drawable, Context context) {
        this.itemList = itemList;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
        this.drawable = drawable;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new ViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder3 holder, int position) {
        String name = itemList.get(position);
        String type = itemType.get(position);
        String price = itemPrice.get(position);
        String draw = drawable.get(position);

        holder.text1.setText(name);
        holder.text2.setText(type);
        holder.text3.setText(price);

        String resourceName = draw.substring(draw.lastIndexOf("/") + 1);

        int resourceId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        if (resourceId != 0) {
            holder.image.setImageResource(resourceId);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }



    public static class ViewHolder3 extends RecyclerView.ViewHolder {
        // ...
        TextView text1;
        TextView text2;
        TextView text3;
        ImageView image;
        public ViewHolder3(View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.txtName);
            text2 = itemView.findViewById(R.id.txtPlace);
            text3 = itemView.findViewById(R.id.txtPrice);
            image = itemView.findViewById(R.id.imgAvatar);
        }
    }
}