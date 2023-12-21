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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ck_room.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MenuBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btBack;

  @NonNull
  public final ImageView imageView9;

  @NonNull
  public final RecyclerView recyclerView3;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView34;

  @NonNull
  public final TextView textView40;

  @NonNull
  public final TextView title;

  @NonNull
  public final View view;

  @NonNull
  public final View view26;

  private MenuBinding(@NonNull ConstraintLayout rootView, @NonNull Button btBack,
      @NonNull ImageView imageView9, @NonNull RecyclerView recyclerView3,
      @NonNull TextView textView16, @NonNull TextView textView34, @NonNull TextView textView40,
      @NonNull TextView title, @NonNull View view, @NonNull View view26) {
    this.rootView = rootView;
    this.btBack = btBack;
    this.imageView9 = imageView9;
    this.recyclerView3 = recyclerView3;
    this.textView16 = textView16;
    this.textView34 = textView34;
    this.textView40 = textView40;
    this.title = title;
    this.view = view;
    this.view26 = view26;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btBack;
      Button btBack = ViewBindings.findChildViewById(rootView, id);
      if (btBack == null) {
        break missingId;
      }

      id = R.id.imageView9;
      ImageView imageView9 = ViewBindings.findChildViewById(rootView, id);
      if (imageView9 == null) {
        break missingId;
      }

      id = R.id.recyclerView3;
      RecyclerView recyclerView3 = ViewBindings.findChildViewById(rootView, id);
      if (recyclerView3 == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView34;
      TextView textView34 = ViewBindings.findChildViewById(rootView, id);
      if (textView34 == null) {
        break missingId;
      }

      id = R.id.textView40;
      TextView textView40 = ViewBindings.findChildViewById(rootView, id);
      if (textView40 == null) {
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

      id = R.id.view26;
      View view26 = ViewBindings.findChildViewById(rootView, id);
      if (view26 == null) {
        break missingId;
      }

      return new MenuBinding((ConstraintLayout) rootView, btBack, imageView9, recyclerView3,
          textView16, textView34, textView40, title, view, view26);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
