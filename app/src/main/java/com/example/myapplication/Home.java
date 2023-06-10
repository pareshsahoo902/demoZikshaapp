package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private TextView textView2;
    private ArrayList<UserModel> userList;
    private RecyclerView recycler;

    private UserListAdapter adapter;
    private ImageButton logout;

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView2 = (TextView) findViewById(R.id.textview2);
        recycler = (RecyclerView) findViewById(R.id.recylerView);
        logout = (ImageButton) findViewById(R.id.logout);
        userList = new ArrayList<UserModel>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(layoutManager);
        recycler.hasFixedSize();

        sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myEditor = sharedPreferences.edit();
                myEditor.clear();
                myEditor.apply();
                finish();
            }
        });

        Intent i = getIntent();
        String str = i.getStringExtra("name");

        textView2.setText("Hello !! "+str.toUpperCase());

        userList.add(new UserModel("001","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("002","Paresh Kumar Sahoo",false));
        userList.add(new UserModel("003","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("004","Paresh Kumar Sahoo",false));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));
        userList.add(new UserModel("005","Paresh Kumar Sahoo",true));

        adapter = new UserListAdapter(userList);
        recycler.setAdapter(adapter);



    }
}