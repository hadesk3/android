// Generated by view binder compiler. Do not edit!
package com.example.ck_room.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class UserShareBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btBack;

  @NonNull
  public final Button butSend;

  @NonNull
  public final EditText phone;

  @NonNull
  public final TextView textView42;

  @NonNull
  public final View view28;

  @NonNull
  public final View view29;

  private UserShareBinding(@NonNull LinearLayout rootView, @NonNull Button btBack,
      @NonNull Button butSend, @NonNull EditText phone, @NonNull TextView textView42,
      @NonNull View view28, @NonNull View view29) {
    this.rootView = rootView;
    this.btBack = btBack;
    this.butSend = butSend;
    this.phone = phone;
    this.textView42 = textView42;
    this.view28 = view28;
    this.view29 = view29;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static UserShareBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static UserShareBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.user_share, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static UserShareBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btBack;
      Button btBack = ViewBindings.findChildViewById(rootView, id);
      if (btBack == null) {
        break missingId;
      }

      id = R.id.butSend;
      Button butSend = ViewBindings.findChildViewById(rootView, id);
      if (butSend == null) {
        break missingId;
      }

      id = R.id.phone;
      EditText phone = ViewBindings.findChildViewById(rootView, id);
      if (phone == null) {
        break missingId;
      }

      id = R.id.textView42;
      TextView textView42 = ViewBindings.findChildViewById(rootView, id);
      if (textView42 == null) {
        break missingId;
      }

      id = R.id.view28;
      View view28 = ViewBindings.findChildViewById(rootView, id);
      if (view28 == null) {
        break missingId;
      }

      id = R.id.view29;
      View view29 = ViewBindings.findChildViewById(rootView, id);
      if (view29 == null) {
        break missingId;
      }

      return new UserShareBinding((LinearLayout) rootView, btBack, butSend, phone, textView42,
          view28, view29);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
