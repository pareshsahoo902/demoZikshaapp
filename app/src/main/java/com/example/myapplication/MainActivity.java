package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText email, password, name;

    private ImageView image;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onResume() {
        super.onResume();
        email.setText("");
        password.setText("");
        name.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        name = (EditText) findViewById(R.id.name);
        image = (ImageView) findViewById(R.id.image);



        image.setImageResource(R.drawable.download);

        sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);
        String nm = sharedPreferences.getString("name","");
        boolean isLoggedIn =  nm.length()>0 ?true :false;
        if(isLoggedIn){
            Intent intent = new Intent(MainActivity.this, Home.class);
            intent.putExtra("name",nm);
            startActivity(intent);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().length() < 1){
                    Toast.makeText(MainActivity.this, "Please enter a email address to Login", Toast.LENGTH_SHORT).show();

                }
                else if(password.getText().length() < 1){
                    Toast.makeText(MainActivity.this, "Please enter a password to Login", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences.Editor myEditor = sharedPreferences.edit();
                    myEditor.putString("name",name.getText().toString());
                    myEditor.apply();

                    Intent intent = new Intent(MainActivity.this, Home.class);
                    intent.putExtra("name",name.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}