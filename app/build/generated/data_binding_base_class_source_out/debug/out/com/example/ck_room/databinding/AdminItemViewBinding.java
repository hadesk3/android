// Generated by view binder compiler. Do not edit!
package com.example.ck_room.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ck_room.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AdminItemViewBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView imgAvatar;

  @NonNull
  public final TextView txtName;

  @NonNull
  public final TextView txtPlace;

  @NonNull
  public final ImageButton txtPrice;

  @NonNull
  public final TextView txtTime;

  private AdminItemViewBinding(@NonNull RelativeLayout rootView, @NonNull ImageView imgAvatar,
      @NonNull TextView txtName, @NonNull TextView txtPlace, @NonNull ImageButton txtPrice,
      @NonNull TextView txtTime) {
    this.rootView = rootView;
    this.imgAvatar = imgAvatar;
    this.txtName = txtName;
    this.txtPlace = txtPlace;
    this.txtPrice = txtPrice;
    this.txtTime = txtTime;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdminItemViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdminItemViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.admin_item_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdminItemViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgAvatar;
      ImageView imgAvatar = ViewBindings.findChildViewById(rootView, id);
      if (imgAvatar == null) {
        break missingId;
      }

      id = R.id.txtName;
      TextView txtName = ViewBindings.findChildViewById(rootView, id);
      if (txtName == null) {
        break missingId;
      }

      id = R.id.txtPlace;
      TextView txtPlace = ViewBindings.findChildViewById(rootView, id);
      if (txtPlace == null) {
        break missingId;
      }

      id = R.id.txtPrice;
      ImageButton txtPrice = ViewBindings.findChildViewById(rootView, id);
      if (txtPrice == null) {
        break missingId;
      }

      id = R.id.txtTime;
      TextView txtTime = ViewBindings.findChildViewById(rootView, id);
      if (txtTime == null) {
        break missingId;
      }

      return new AdminItemViewBinding((RelativeLayout) rootView, imgAvatar, txtName, txtPlace,
          txtPrice, txtTime);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
