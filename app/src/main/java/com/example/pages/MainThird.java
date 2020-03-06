
package com.example.pages;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckBox;

public class MainThird extends AppCompatActivity {
    private Button mButton1;
private int ct1=0,ct2=0,ct3=0,ct4=0,ct5=0,ct6=0;

    protected void getSelected(View view){
        CheckBox c1=(CheckBox)findViewById(R.id.checkBox3);
        CheckBox c2=(CheckBox)findViewById(R.id.checkBox4);

        CheckBox c3=(CheckBox)findViewById(R.id.checkBox5);

        CheckBox c4=(CheckBox)findViewById(R.id.checkBox6);

        CheckBox c5=(CheckBox)findViewById(R.id.checkBox7);

        CheckBox c6=(CheckBox)findViewById(R.id.checkBox8);

        if (c1.isChecked() ) {
            ct1+=1;
            //displayMessage="";
            //displayMessage = displayMessage + checkJava.getText() + "\n";

        }
        if (c2.isChecked() ) {
            ct2 += 1;
        }
        if (c3.isChecked() ) {
            ct3 += 1;
        }
        if (c4.isChecked() ) {
            ct4 += 1;
        }
        if (c5.isChecked() ) {
            ct5 += 1;
        }
        if (c6.isChecked() ) {
            ct6 += 1;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_main);
        mButton1 = (Button) findViewById(R.id.button1);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // openActivity2();
                if(ct1>=1 && ct2>=1 && ct3>=1 && ct4>=1 &&ct5>=1 &&ct6>=1 ){
                    startActivity(new Intent(MainThird.this, com.example.pages.MainSixth.class));
                }
                else if(ct1>=1 && ct2>=1 && ct3>=1){
                    startActivity(new Intent(MainThird.this, com.example.pages.MainSeventh.class));
                }
                else if(ct1>=4 && ct5>=1 && ct6>=1){
                    startActivity(new Intent(MainThird.this, com.example.pages.MainSeventh.class));
                }
                else{
                    startActivity(new Intent(MainThird.this, com.example.pages.MainSeventh.class));
                }
               // startActivity(new Intent(MainThird.this, com.example.pages.MainFourth.class));
                // startActivity(new Intent(this,Main2Activity.class));
            }
        });

    }
}




    //  }
   /* public void  openActivity2(){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }*/

   /*
package com.example.pages;
import android.content.Intent;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;


public class MainThird extends AppCompatActivity {

    ListView myList;
    Button getChoice, clearAll, button1;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyUserChoice";
    ArrayList<String> selectedItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_main);
        myList = (ListView) findViewById(R.id.list);
        getChoice = (Button) findViewById(R.id.getchoice);
        clearAll = (Button) findViewById(R.id.clearall);
        button1 = (Button) findViewById(R.id.button1);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                // code snippet to retrieve array values in ArrayAdapter
                getResources().getStringArray(R.array.Questionnaire));
        myList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        myList.setAdapter(adapter);
        sharedpreferences = getSharedPreferences(MyPREFERENCES,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(MyPREFERENCES)) {
            LoadSelections();
        }

        getChoice.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                String selected = "";
                int cntChoice = myList.getCount();

                SparseBooleanArray sparseBooleanArray = myList
                        .getCheckedItemPositions();
                for (int i = 0; i < cntChoice; i++) {
                    if (sparseBooleanArray.get(i)) {
                        selected += myList.getItemAtPosition(i).toString()
                                + "\n";
                        System.out.println("Checking list while adding:"
                                + myList.getItemAtPosition(i).toString());
                        SaveSelections();
                    }

                }

                Toast.makeText(CheckBoxSharedPreferences.this, selected,
                        Toast.LENGTH_LONG).show();
            }
        });

        //listener for clear all button
        clearAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ClearSelections();
            }
        });

        //listener for button1 (that transfers the activity to another intent
        button1.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(CheckBoxSharedPreferences.this,
                        result.class);
                startActivity(intent);
            }
        });
    }

    private void SaveSelections() {
        // save the selections in the shared preference in private mode for the
        // user

        SharedPreferences.Editor prefEditor = sharedpreferences.edit();
        String savedItems = getSavedItems();
        prefEditor.putString(MyPREFERENCES.toString(), savedItems);
        prefEditor.commit();
    }

    private String getSavedItems() {
        String savedItems = "";
        int count = this.myList.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.myList.isItemChecked(i)) {
                if (savedItems.length() > 0) {
                    savedItems += "," + this.myList.getItemAtPosition(i);
                } else {
                    savedItems += this.myList.getItemAtPosition(i);
                }
            }
        }
        return savedItems;
    }

    private void LoadSelections() {
        // if the selections were previously saved load them

        if (sharedpreferences.contains(MyPREFERENCES.toString())) {

            String savedItems = sharedpreferences.getString(
                    MyPREFERENCES.toString(), "");
            selectedItems.addAll(Arrays.asList(savedItems.split(",")));

            int count = this.myList.getAdapter().getCount();

            for (int i = 0; i < count; i++) {
                String currentItem = (String) myList.getAdapter().getItem(i);
                if (selectedItems.contains(currentItem)) {
                    myList.setItemChecked(i, true);
                    Toast.makeText(getApplicationContext(),
                            "Current Item: " + currentItem, Toast.LENGTH_LONG)
                            .show();
                } else {
                    myList.setItemChecked(i, false);
                }

            }
        }
    }
*/