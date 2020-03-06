package com.example.pages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;



import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainFourth extends AppCompatActivity {
    private Button mButton;
    private EditText ed;
    DatabaseReference ref;
    FirebaseDatabase db;
    Location location;
   // long c=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_main);
        mButton = findViewById(R.id.button3);
        ed = findViewById(R.id.editText);
        db=FirebaseDatabase.getInstance();
        ref=db.getReference("Location");
        location=new Location();
        ref= FirebaseDatabase.getInstance().getReference().child("Location");
       /* ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    c=(dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainFourth.this, com.example.pages.MainFifth.class));
                location.setLocation(ed.getText().toString().trim());
                ref.push().setValue(location);
                Toast.makeText(MainFourth.this,"Inserted location",Toast.LENGTH_LONG).show();
          //  ref.child(String.valueOf(c+1)).setValue(location);
            }
        });
        Toast.makeText(MainFourth.this,"Firebase Connection Success",Toast.LENGTH_LONG).show();
    }
}
