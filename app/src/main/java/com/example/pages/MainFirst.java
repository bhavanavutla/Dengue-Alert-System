package com.example.pages;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainFirst extends AppCompatActivity {
   private Button mButton;
    FirebaseDatabase fd;
    DatabaseReference ref1,ref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_main);
        mButton = findViewById(R.id.button);
        // while(mButton==null) {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // openActivity2();
                startActivity(new Intent(MainFirst.this, com.example.pages.MainSecond.class));
                // startActivity(new Intent(this,Main2Activity.class));
            }
        });
    }
    //  }
   /* public void  openActivity2(){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }*/
}



