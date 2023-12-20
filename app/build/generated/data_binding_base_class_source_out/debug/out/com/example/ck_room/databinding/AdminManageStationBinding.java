// Generated by view binder compiler. Do not edit!
package com.example.ck_room.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ck_room.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AdminManageStationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView bt;

  @NonNull
  public final Button btBack;

  @NonNull
  public final Button btCreate;

  @NonNull
  public final CardView cardView5;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final RecyclerView recyclerViewmanage;

  @NonNull
  public final TextView title;

  @NonNull
  public final View view;

  private AdminManageStationBinding(@NonNull ConstraintLayout rootView, @NonNull CardView bt,
      @NonNull Button btBack, @NonNull Button btCreate, @NonNull CardView cardView5,
      @NonNull ImageView imageView4, @NonNull RecyclerView recyclerViewmanage,
      @NonNull TextView title, @NonNull View view) {
    this.rootView = rootView;
    this.bt = bt;
    this.btBack = btBack;
    this.btCreate = btCreate;
    this.cardView5 = cardView5;
    this.imageView4 = imageView4;
    this.recyclerViewmanage = recyclerViewmanage;
    this.title = title;
    this.view = view;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdminManageStationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdminManageStationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.admin_manage_station, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdminManageStationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt;
      CardView bt = ViewBindings.findChildViewById(rootView, id);
      if (bt == null) {
        break missingId;
      }

      id = R.id.btBack;
      Button btBack = ViewBindings.findChildViewById(rootView, id);
      if (btBack == null) {
        break missingId;
      }

      id = R.id.btCreate;
      Button btCreate = ViewBindings.findChildViewById(rootView, id);
      if (btCreate == null) {
        break missingId;
      }

      id = R.id.cardView5;
      CardView cardView5 = ViewBindings.findChildViewById(rootView, id);
      if (cardView5 == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.recyclerViewmanage;
      RecyclerView recyclerViewmanage = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewmanage == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      return new AdminManageStationBinding((ConstraintLayout) rootView, bt, btBack, btCreate,
          cardView5, imageView4, recyclerViewmanage, title, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
