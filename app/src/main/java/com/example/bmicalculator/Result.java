package com.example.bmicalculator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView BMIgetindex;
    TextView BMIgetreading;
    ImageView BMIimage;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        BMIgetreading = (TextView)findViewById(R.id.TVresult);
        BMIgetindex = (TextView)findViewById(R.id.TVgetresult);
        next = (Button)findViewById(R.id.BTNnext3);
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("read image");
        Bitmap BMI = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        BMIimage = (ImageView)findViewById(R.id.IVBMI);
        BMIimage.setImageBitmap(BMI);

        if (getIntent().hasExtra("calculator")){
            Double captureTheValue = getIntent().getExtras().getDouble("calculator");
            BMIgetindex.setText(captureTheValue+"");
        }

        if (getIntent().hasExtra("read data")){
            String captureTheData = getIntent().getExtras().getString("read data");
            BMIgetreading.setText(captureTheData);
        }


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getIntent().hasExtra("calculator")){ //check the Extra data
                    Double captureTheBMI = getIntent().getExtras().getDouble("calculator"); //get the data

                    //tips to gain weight, maintain BMI or lose weight
                    if (captureTheBMI < 18.5 ){
                        Intent page4 = new Intent(getApplicationContext(), UnderweightAdvice.class);
                        startActivity(page4);
                    }

                    else if (captureTheBMI >= 18.5 && captureTheBMI <= 24.9){
                        Intent page5 = new Intent(getApplicationContext(), NormalAdvice.class);
                        startActivity(page5);
                    }

                    else if (captureTheBMI >= 25){
                        Intent page6 = new Intent(getApplicationContext(), OverweightObese.class);
                        startActivity(page6);
                    }
            }
            }
        });


    }
}
