package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OverweightObese extends AppCompatActivity {

    Button next5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overweight_obese);

        next5 = (Button)findViewById(R.id.BTNnext5);

        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page7 = new Intent(getApplicationContext(), ThankYou.class);
                startActivity(page7); //go to the last page
            }
        });
    }
}
