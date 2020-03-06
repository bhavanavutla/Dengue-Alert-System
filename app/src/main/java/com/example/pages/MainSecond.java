package com.example.pages;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;

public class MainSecond extends AppCompatActivity {
    private Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        b1 = findViewById(R.id.button2);
        b2 = findViewById(R.id.button4);
        b3 = findViewById(R.id.button5);
        // while(mButton==null) {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // openActivity2();
                startActivity(new Intent(MainSecond.this, com.example.pages.MainThird.class));
                // startActivity(new Intent(this,Main2Activity.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // openActivity2();
                startActivity(new Intent(MainSecond.this, com.example.pages.MainThird.class));
                // startActivity(new Intent(this,Main2Activity.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // openActivity2();
                startActivity(new Intent(MainSecond.this, com.example.pages.MainThird.class));
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



