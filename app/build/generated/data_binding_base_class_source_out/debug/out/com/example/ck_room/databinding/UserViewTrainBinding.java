// Generated by view binder compiler. Do not edit!
package com.example.ck_room.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
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

public final class UserViewTrainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout addGr;

  @NonNull
  public final LinearLayout arrGr;

  @NonNull
  public final CardView bt;

  @NonNull
  public final Button btBack;

  @NonNull
  public final Button btCreate;

  @NonNull
  public final CardView cardView5;

  @NonNull
  public final LinearLayout dateGr;

  @NonNull
  public final TextView edtArrive;

  @NonNull
  public final TextView edtBusFare;

  @NonNull
  public final TextView edtBusPass;

  @NonNull
  public final TextView edtDate;

  @NonNull
  public final TextView edtEcoFare;

  @NonNull
  public final TextView edtEcoPass;

  @NonNull
  public final TextView edtEmail;

  @NonNull
  public final TextView edtEnd;

  @NonNull
  public final TextView edtFirstFare;

  @NonNull
  public final TextView edtFirstPass;

  @NonNull
  public final TextView edtName;

  @NonNull
  public final TextView edtStart;

  @NonNull
  public final View form;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final LinearLayout nameGr;

  @NonNull
  public final TableLayout tableLayout;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final LinearLayout timeGr;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView txtArrive;

  @NonNull
  public final TextView txtDate;

  @NonNull
  public final TextView txtMail;

  @NonNull
  public final TextView txtName;

  @NonNull
  public final TextView txtTime;

  @NonNull
  public final TextView txtTo;

  @NonNull
  public final View view;

  private UserViewTrainBinding(@NonNull ConstraintLayout rootView, @NonNull LinearLayout addGr,
      @NonNull LinearLayout arrGr, @NonNull CardView bt, @NonNull Button btBack,
      @NonNull Button btCreate, @NonNull CardView cardView5, @NonNull LinearLayout dateGr,
      @NonNull TextView edtArrive, @NonNull TextView edtBusFare, @NonNull TextView edtBusPass,
      @NonNull TextView edtDate, @NonNull TextView edtEcoFare, @NonNull TextView edtEcoPass,
      @NonNull TextView edtEmail, @NonNull TextView edtEnd, @NonNull TextView edtFirstFare,
      @NonNull TextView edtFirstPass, @NonNull TextView edtName, @NonNull TextView edtStart,
      @NonNull View form, @NonNull ImageView imageView4, @NonNull LinearLayout nameGr,
      @NonNull TableLayout tableLayout, @NonNull TextView textView2, @NonNull LinearLayout timeGr,
      @NonNull TextView title, @NonNull TextView txtArrive, @NonNull TextView txtDate,
      @NonNull TextView txtMail, @NonNull TextView txtName, @NonNull TextView txtTime,
      @NonNull TextView txtTo, @NonNull View view) {
    this.rootView = rootView;
    this.addGr = addGr;
    this.arrGr = arrGr;
    this.bt = bt;
    this.btBack = btBack;
    this.btCreate = btCreate;
    this.cardView5 = cardView5;
    this.dateGr = dateGr;
    this.edtArrive = edtArrive;
    this.edtBusFare = edtBusFare;
    this.edtBusPass = edtBusPass;
    this.edtDate = edtDate;
    this.edtEcoFare = edtEcoFare;
    this.edtEcoPass = edtEcoPass;
    this.edtEmail = edtEmail;
    this.edtEnd = edtEnd;
    this.edtFirstFare = edtFirstFare;
    this.edtFirstPass = edtFirstPass;
    this.edtName = edtName;
    this.edtStart = edtStart;
    this.form = form;
    this.imageView4 = imageView4;
    this.nameGr = nameGr;
    this.tableLayout = tableLayout;
    this.textView2 = textView2;
    this.timeGr = timeGr;
    this.title = title;
    this.txtArrive = txtArrive;
    this.txtDate = txtDate;
    this.txtMail = txtMail;
    this.txtName = txtName;
    this.txtTime = txtTime;
    this.txtTo = txtTo;
    this.view = view;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static UserViewTrainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static UserViewTrainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.user_view_train, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static UserViewTrainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addGr;
      LinearLayout addGr = ViewBindings.findChildViewById(rootView, id);
      if (addGr == null) {
        break missingId;
      }

      id = R.id.arrGr;
      LinearLayout arrGr = ViewBindings.findChildViewById(rootView, id);
      if (arrGr == null) {
        break missingId;
      }

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

      id = R.id.dateGr;
      LinearLayout dateGr = ViewBindings.findChildViewById(rootView, id);
      if (dateGr == null) {
        break missingId;
      }

      id = R.id.edtArrive;
      TextView edtArrive = ViewBindings.findChildViewById(rootView, id);
      if (edtArrive == null) {
        break missingId;
      }

      id = R.id.edtBusFare;
      TextView edtBusFare = ViewBindings.findChildViewById(rootView, id);
      if (edtBusFare == null) {
        break missingId;
      }

      id = R.id.edtBusPass;
      TextView edtBusPass = ViewBindings.findChildViewById(rootView, id);
      if (edtBusPass == null) {
        break missingId;
      }

      id = R.id.edtDate;
      TextView edtDate = ViewBindings.findChildViewById(rootView, id);
      if (edtDate == null) {
        break missingId;
      }

      id = R.id.edtEcoFare;
      TextView edtEcoFare = ViewBindings.findChildViewById(rootView, id);
      if (edtEcoFare == null) {
        break missingId;
      }

      id = R.id.edtEcoPass;
      TextView edtEcoPass = ViewBindings.findChildViewById(rootView, id);
      if (edtEcoPass == null) {
        break missingId;
      }

      id = R.id.edtEmail;
      TextView edtEmail = ViewBindings.findChildViewById(rootView, id);
      if (edtEmail == null) {
        break missingId;
      }

      id = R.id.edtEnd;
      TextView edtEnd = ViewBindings.findChildViewById(rootView, id);
      if (edtEnd == null) {
        break missingId;
      }

      id = R.id.edtFirstFare;
      TextView edtFirstFare = ViewBindings.findChildViewById(rootView, id);
      if (edtFirstFare == null) {
        break missingId;
      }

      id = R.id.edtFirstPass;
      TextView edtFirstPass = ViewBindings.findChildViewById(rootView, id);
      if (edtFirstPass == null) {
        break missingId;
      }

      id = R.id.edtName;
      TextView edtName = ViewBindings.findChildViewById(rootView, id);
      if (edtName == null) {
        break missingId;
      }

      id = R.id.edtStart;
      TextView edtStart = ViewBindings.findChildViewById(rootView, id);
      if (edtStart == null) {
        break missingId;
      }

      id = R.id.form;
      View form = ViewBindings.findChildViewById(rootView, id);
      if (form == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.nameGr;
      LinearLayout nameGr = ViewBindings.findChildViewById(rootView, id);
      if (nameGr == null) {
        break missingId;
      }

      id = R.id.tableLayout;
      TableLayout tableLayout = ViewBindings.findChildViewById(rootView, id);
      if (tableLayout == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.timeGr;
      LinearLayout timeGr = ViewBindings.findChildViewById(rootView, id);
      if (timeGr == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.txtArrive;
      TextView txtArrive = ViewBindings.findChildViewById(rootView, id);
      if (txtArrive == null) {
        break missingId;
      }

      id = R.id.txtDate;
      TextView txtDate = ViewBindings.findChildViewById(rootView, id);
      if (txtDate == null) {
        break missingId;
      }

      id = R.id.txtMail;
      TextView txtMail = ViewBindings.findChildViewById(rootView, id);
      if (txtMail == null) {
        break missingId;
      }

      id = R.id.txtName;
      TextView txtName = ViewBindings.findChildViewById(rootView, id);
      if (txtName == null) {
        break missingId;
      }

      id = R.id.txtTime;
      TextView txtTime = ViewBindings.findChildViewById(rootView, id);
      if (txtTime == null) {
        break missingId;
      }

      id = R.id.txtTo;
      TextView txtTo = ViewBindings.findChildViewById(rootView, id);
      if (txtTo == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      return new UserViewTrainBinding((ConstraintLayout) rootView, addGr, arrGr, bt, btBack,
          btCreate, cardView5, dateGr, edtArrive, edtBusFare, edtBusPass, edtDate, edtEcoFare,
          edtEcoPass, edtEmail, edtEnd, edtFirstFare, edtFirstPass, edtName, edtStart, form,
          imageView4, nameGr, tableLayout, textView2, timeGr, title, txtArrive, txtDate, txtMail,
          txtName, txtTime, txtTo, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
