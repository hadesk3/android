// Generated by view binder compiler. Do not edit!
package com.example.ck_room.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ck_room.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class UserSeatItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout linearLayout2;

  @NonNull
  public final ImageView textViewSeatNumber;

  @NonNull
  public final TextView txtNumber;

  private UserSeatItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout linearLayout2, @NonNull ImageView textViewSeatNumber,
      @NonNull TextView txtNumber) {
    this.rootView = rootView;
    this.linearLayout2 = linearLayout2;
    this.textViewSeatNumber = textViewSeatNumber;
    this.txtNumber = txtNumber;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static UserSeatItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static UserSeatItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.user_seat_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static UserSeatItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout linearLayout2 = (ConstraintLayout) rootView;

      id = R.id.textViewSeatNumber;
      ImageView textViewSeatNumber = ViewBindings.findChildViewById(rootView, id);
      if (textViewSeatNumber == null) {
        break missingId;
      }

      id = R.id.txtNumber;
      TextView txtNumber = ViewBindings.findChildViewById(rootView, id);
      if (txtNumber == null) {
        break missingId;
      }

      return new UserSeatItemBinding((ConstraintLayout) rootView, linearLayout2, textViewSeatNumber,
          txtNumber);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
