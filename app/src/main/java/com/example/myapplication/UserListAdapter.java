package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private ArrayList<UserModel> userlist;

    public UserListAdapter(ArrayList<UserModel> list){
        this.userlist = list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_view_holder,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserModel user = userlist.get(position);
        holder.name.setText(user.getUsername());
        holder.btn.setText(user.isOnline ?"ONLINE":"OFFLINE");

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }
}
