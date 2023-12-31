// Generated by view binder compiler. Do not edit!
package com.example.ck_room.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ck_room.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class UserPageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView Tittle;

  @NonNull
  public final View body;

  @NonNull
  public final ImageButton btBooking;

  @NonNull
  public final ImageButton btContact;

  @NonNull
  public final LinearLayout btGr;

  @NonNull
  public final ImageButton btHistory;

  @NonNull
  public final ImageButton btPassword;

  @NonNull
  public final ImageButton btUser;

  @NonNull
  public final CardView cardView1;

  @NonNull
  public final CardView cardView2;

  @NonNull
  public final TextView class1;

  @NonNull
  public final TextView class2;

  @NonNull
  public final TextView des1;

  @NonNull
  public final TextView des2;

  @NonNull
  public final ImageView imgBuss1;

  @NonNull
  public final ImageView imgBuss2;

  @NonNull
  public final TextView new1;

  @NonNull
  public final TextView new2;

  @NonNull
  public final ImageView rate1;

  @NonNull
  public final ImageView rate2;

  @NonNull
  public final TextView rateNum;

  @NonNull
  public final TextView rateNum1;

  @NonNull
  public final TextView txtMenu;

  @NonNull
  public final View view1;

  @NonNull
  public final View view6;

  @NonNull
  public final View view8;

  private UserPageBinding(@NonNull ConstraintLayout rootView, @NonNull TextView Tittle,
      @NonNull View body, @NonNull ImageButton btBooking, @NonNull ImageButton btContact,
      @NonNull LinearLayout btGr, @NonNull ImageButton btHistory, @NonNull ImageButton btPassword,
      @NonNull ImageButton btUser, @NonNull CardView cardView1, @NonNull CardView cardView2,
      @NonNull TextView class1, @NonNull TextView class2, @NonNull TextView des1,
      @NonNull TextView des2, @NonNull ImageView imgBuss1, @NonNull ImageView imgBuss2,
      @NonNull TextView new1, @NonNull TextView new2, @NonNull ImageView rate1,
      @NonNull ImageView rate2, @NonNull TextView rateNum, @NonNull TextView rateNum1,
      @NonNull TextView txtMenu, @NonNull View view1, @NonNull View view6, @NonNull View view8) {
    this.rootView = rootView;
    this.Tittle = Tittle;
    this.body = body;
    this.btBooking = btBooking;
    this.btContact = btContact;
    this.btGr = btGr;
    this.btHistory = btHistory;
    this.btPassword = btPassword;
    this.btUser = btUser;
    this.cardView1 = cardView1;
    this.cardView2 = cardView2;
    this.class1 = class1;
    this.class2 = class2;
    this.des1 = des1;
    this.des2 = des2;
    this.imgBuss1 = imgBuss1;
    this.imgBuss2 = imgBuss2;
    this.new1 = new1;
    this.new2 = new2;
    this.rate1 = rate1;
    this.rate2 = rate2;
    this.rateNum = rateNum;
    this.rateNum1 = rateNum1;
    this.txtMenu = txtMenu;
    this.view1 = view1;
    this.view6 = view6;
    this.view8 = view8;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static UserPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static UserPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.user_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static UserPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Tittle;
      TextView Tittle = ViewBindings.findChildViewById(rootView, id);
      if (Tittle == null) {
        break missingId;
      }

      id = R.id.body;
      View body = ViewBindings.findChildViewById(rootView, id);
      if (body == null) {
        break missingId;
      }

      id = R.id.btBooking;
      ImageButton btBooking = ViewBindings.findChildViewById(rootView, id);
      if (btBooking == null) {
        break missingId;
      }

      id = R.id.btContact;
      ImageButton btContact = ViewBindings.findChildViewById(rootView, id);
      if (btContact == null) {
        break missingId;
      }

      id = R.id.btGr;
      LinearLayout btGr = ViewBindings.findChildViewById(rootView, id);
      if (btGr == null) {
        break missingId;
      }

      id = R.id.btHistory;
      ImageButton btHistory = ViewBindings.findChildViewById(rootView, id);
      if (btHistory == null) {
        break missingId;
      }

      id = R.id.btPassword;
      ImageButton btPassword = ViewBindings.findChildViewById(rootView, id);
      if (btPassword == null) {
        break missingId;
      }

      id = R.id.btUser;
      ImageButton btUser = ViewBindings.findChildViewById(rootView, id);
      if (btUser == null) {
        break missingId;
      }

      id = R.id.cardView1;
      CardView cardView1 = ViewBindings.findChildViewById(rootView, id);
      if (cardView1 == null) {
        break missingId;
      }

      id = R.id.cardView2;
      CardView cardView2 = ViewBindings.findChildViewById(rootView, id);
      if (cardView2 == null) {
        break missingId;
      }

      id = R.id.class1;
      TextView class1 = ViewBindings.findChildViewById(rootView, id);
      if (class1 == null) {
        break missingId;
      }

      id = R.id.class2;
      TextView class2 = ViewBindings.findChildViewById(rootView, id);
      if (class2 == null) {
        break missingId;
      }

      id = R.id.des1;
      TextView des1 = ViewBindings.findChildViewById(rootView, id);
      if (des1 == null) {
        break missingId;
      }

      id = R.id.des2;
      TextView des2 = ViewBindings.findChildViewById(rootView, id);
      if (des2 == null) {
        break missingId;
      }

      id = R.id.imgBuss1;
      ImageView imgBuss1 = ViewBindings.findChildViewById(rootView, id);
      if (imgBuss1 == null) {
        break missingId;
      }

      id = R.id.imgBuss2;
      ImageView imgBuss2 = ViewBindings.findChildViewById(rootView, id);
      if (imgBuss2 == null) {
        break missingId;
      }

      id = R.id.new1;
      TextView new1 = ViewBindings.findChildViewById(rootView, id);
      if (new1 == null) {
        break missingId;
      }

      id = R.id.new2;
      TextView new2 = ViewBindings.findChildViewById(rootView, id);
      if (new2 == null) {
        break missingId;
      }

      id = R.id.rate1;
      ImageView rate1 = ViewBindings.findChildViewById(rootView, id);
      if (rate1 == null) {
        break missingId;
      }

      id = R.id.rate2;
      ImageView rate2 = ViewBindings.findChildViewById(rootView, id);
      if (rate2 == null) {
        break missingId;
      }

      id = R.id.rateNum;
      TextView rateNum = ViewBindings.findChildViewById(rootView, id);
      if (rateNum == null) {
        break missingId;
      }

      id = R.id.rateNum1;
      TextView rateNum1 = ViewBindings.findChildViewById(rootView, id);
      if (rateNum1 == null) {
        break missingId;
      }

      id = R.id.txtMenu;
      TextView txtMenu = ViewBindings.findChildViewById(rootView, id);
      if (txtMenu == null) {
        break missingId;
      }

      id = R.id.view1;
      View view1 = ViewBindings.findChildViewById(rootView, id);
      if (view1 == null) {
        break missingId;
      }

      id = R.id.view6;
      View view6 = ViewBindings.findChildViewById(rootView, id);
      if (view6 == null) {
        break missingId;
      }

      id = R.id.view8;
      View view8 = ViewBindings.findChildViewById(rootView, id);
      if (view8 == null) {
        break missingId;
      }

      return new UserPageBinding((ConstraintLayout) rootView, Tittle, body, btBooking, btContact,
          btGr, btHistory, btPassword, btUser, cardView1, cardView2, class1, class2, des1, des2,
          imgBuss1, imgBuss2, new1, new2, rate1, rate2, rateNum, rateNum1, txtMenu, view1, view6,
          view8);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
