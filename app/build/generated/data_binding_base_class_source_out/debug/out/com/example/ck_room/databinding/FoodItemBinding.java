// Generated by view binder compiler. Do not edit!
package com.example.ck_room.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ck_room.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FoodItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imgAvatar;

  @NonNull
  public final LinearLayout layout;

  @NonNull
  public final TextView txtName;

  @NonNull
  public final TextView txtPlace;

  @NonNull
  public final TextView txtPrice;

  private FoodItemBinding(@NonNull LinearLayout rootView, @NonNull ImageView imgAvatar,
      @NonNull LinearLayout layout, @NonNull TextView txtName, @NonNull TextView txtPlace,
      @NonNull TextView txtPrice) {
    this.rootView = rootView;
    this.imgAvatar = imgAvatar;
    this.layout = layout;
    this.txtName = txtName;
    this.txtPlace = txtPlace;
    this.txtPrice = txtPrice;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FoodItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FoodItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.food_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FoodItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgAvatar;
      ImageView imgAvatar = ViewBindings.findChildViewById(rootView, id);
      if (imgAvatar == null) {
        break missingId;
      }

      LinearLayout layout = (LinearLayout) rootView;

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
      TextView txtPrice = ViewBindings.findChildViewById(rootView, id);
      if (txtPrice == null) {
        break missingId;
      }

      return new FoodItemBinding((LinearLayout) rootView, imgAvatar, layout, txtName, txtPlace,
          txtPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
