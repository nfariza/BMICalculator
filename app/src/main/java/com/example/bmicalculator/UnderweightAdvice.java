package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UnderweightAdvice extends AppCompatActivity {

    Button  next4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_underweight_advice);

        next4 = (Button)findViewById(R.id.BTNnext4);

        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page7 = new Intent(getApplicationContext(), ThankYou.class);
                startActivity(page7); //go to the last page
            }
        });
    }
}
