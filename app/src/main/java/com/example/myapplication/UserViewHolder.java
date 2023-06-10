package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public Button btn;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        btn = (Button) itemView.findViewById(R.id.btn);
        name = (TextView) itemView.findViewById(R.id.textname);
    }
}
