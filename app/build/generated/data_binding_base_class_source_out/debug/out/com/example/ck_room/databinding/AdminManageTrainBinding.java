// Generated by view binder compiler. Do not edit!
package com.example.ck_room.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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

public final class AdminManageTrainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout DepartGr;

  @NonNull
  public final LinearLayout arrGr;

  @NonNull
  public final CardView bt1;

  @NonNull
  public final Button btBack;

  @NonNull
  public final Button btSearch;

  @NonNull
  public final CardView cardView5;

  @NonNull
  public final Button create;

  @NonNull
  public final LinearLayout dateGr;

  @NonNull
  public final Spinner edtArrive;

  @NonNull
  public final TextView edtDate;

  @NonNull
  public final Spinner edtDepart;

  @NonNull
  public final View form;

  @NonNull
  public final View form2;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final CardView lnLogout;

  @NonNull
  public final RecyclerView recyclerViewmanage;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView txtArrive;

  @NonNull
  public final TextView txtDate;

  @NonNull
  public final TextView txtDepart;

  @NonNull
  public final View view;

  private AdminManageTrainBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout DepartGr, @NonNull LinearLayout arrGr, @NonNull CardView bt1,
      @NonNull Button btBack, @NonNull Button btSearch, @NonNull CardView cardView5,
      @NonNull Button create, @NonNull LinearLayout dateGr, @NonNull Spinner edtArrive,
      @NonNull TextView edtDate, @NonNull Spinner edtDepart, @NonNull View form,
      @NonNull View form2, @NonNull ImageView imageView4, @NonNull CardView lnLogout,
      @NonNull RecyclerView recyclerViewmanage, @NonNull TextView title,
      @NonNull TextView txtArrive, @NonNull TextView txtDate, @NonNull TextView txtDepart,
      @NonNull View view) {
    this.rootView = rootView;
    this.DepartGr = DepartGr;
    this.arrGr = arrGr;
    this.bt1 = bt1;
    this.btBack = btBack;
    this.btSearch = btSearch;
    this.cardView5 = cardView5;
    this.create = create;
    this.dateGr = dateGr;
    this.edtArrive = edtArrive;
    this.edtDate = edtDate;
    this.edtDepart = edtDepart;
    this.form = form;
    this.form2 = form2;
    this.imageView4 = imageView4;
    this.lnLogout = lnLogout;
    this.recyclerViewmanage = recyclerViewmanage;
    this.title = title;
    this.txtArrive = txtArrive;
    this.txtDate = txtDate;
    this.txtDepart = txtDepart;
    this.view = view;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdminManageTrainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdminManageTrainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.admin_manage_train, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdminManageTrainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.DepartGr;
      LinearLayout DepartGr = ViewBindings.findChildViewById(rootView, id);
      if (DepartGr == null) {
        break missingId;
      }

      id = R.id.arrGr;
      LinearLayout arrGr = ViewBindings.findChildViewById(rootView, id);
      if (arrGr == null) {
        break missingId;
      }

      id = R.id.bt1;
      CardView bt1 = ViewBindings.findChildViewById(rootView, id);
      if (bt1 == null) {
        break missingId;
      }

      id = R.id.btBack;
      Button btBack = ViewBindings.findChildViewById(rootView, id);
      if (btBack == null) {
        break missingId;
      }

      id = R.id.btSearch;
      Button btSearch = ViewBindings.findChildViewById(rootView, id);
      if (btSearch == null) {
        break missingId;
      }

      id = R.id.cardView5;
      CardView cardView5 = ViewBindings.findChildViewById(rootView, id);
      if (cardView5 == null) {
        break missingId;
      }

      id = R.id.create;
      Button create = ViewBindings.findChildViewById(rootView, id);
      if (create == null) {
        break missingId;
      }

      id = R.id.dateGr;
      LinearLayout dateGr = ViewBindings.findChildViewById(rootView, id);
      if (dateGr == null) {
        break missingId;
      }

      id = R.id.edtArrive;
      Spinner edtArrive = ViewBindings.findChildViewById(rootView, id);
      if (edtArrive == null) {
        break missingId;
      }

      id = R.id.edtDate;
      TextView edtDate = ViewBindings.findChildViewById(rootView, id);
      if (edtDate == null) {
        break missingId;
      }

      id = R.id.edtDepart;
      Spinner edtDepart = ViewBindings.findChildViewById(rootView, id);
      if (edtDepart == null) {
        break missingId;
      }

      id = R.id.form;
      View form = ViewBindings.findChildViewById(rootView, id);
      if (form == null) {
        break missingId;
      }

      id = R.id.form2;
      View form2 = ViewBindings.findChildViewById(rootView, id);
      if (form2 == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.lnLogout;
      CardView lnLogout = ViewBindings.findChildViewById(rootView, id);
      if (lnLogout == null) {
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

      id = R.id.txtDepart;
      TextView txtDepart = ViewBindings.findChildViewById(rootView, id);
      if (txtDepart == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      return new AdminManageTrainBinding((ConstraintLayout) rootView, DepartGr, arrGr, bt1, btBack,
          btSearch, cardView5, create, dateGr, edtArrive, edtDate, edtDepart, form, form2,
          imageView4, lnLogout, recyclerViewmanage, title, txtArrive, txtDate, txtDepart, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}