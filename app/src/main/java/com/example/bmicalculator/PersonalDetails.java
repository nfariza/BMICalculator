package com.example.bmicalculator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;

public class PersonalDetails extends AppCompatActivity {

    EditText height1;
    EditText weight1;
    TextView personal;
    Button BMIcalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        height1 = (EditText)findViewById(R.id.ETheight);
        weight1 = (EditText)findViewById(R.id.ETweight);
        personal = (TextView)findViewById(R.id.TVname);
        BMIcalculate = (Button)findViewById(R.id.BTNnext2);

        if (getIntent().hasExtra("details")) { //check whether it had this data
            String captureTheValue = getIntent().getExtras().getString("details"); //retrieve the data
            personal.setText(captureTheValue);
        }

        BMIcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String BMIheight1 = height1.getText().toString(); //get the height
             String BMIweight1 = weight1.getText().toString(); //get the weight


             if (BMIheight1.isEmpty()||BMIweight1.isEmpty()) { //if both or one of it is empty, toast text will appear
                 Toast.makeText(getApplicationContext(), "PLEASE ENTER YOUR DETAILS", Toast.LENGTH_LONG).show();
             }

             else {
                 double BMIheight2 = Double.parseDouble(BMIheight1); //convert String to double
                 double BMIheight = BMIheight2/100; //convert to metre to calculate the BMI
                 Intent page3 = new Intent(getApplicationContext(), Result.class); //show result at the next page
                 double BMIweight = Double.parseDouble(BMIweight1); //convert String to double
                 double BMIresult = BMIweight / (BMIheight * BMIheight); //calculate the BMI
                 DecimalFormat oneDForm = new DecimalFormat("#.#"); //round off to 1 decimal place

                 //to check the BMI result
                 if (BMIresult >= 0 && BMIresult < 18.5) {
                     page3.putExtra("calculator", Double.valueOf(oneDForm.format(BMIresult))); //send the BMI value
                     page3.putExtra("read data", "UNDERWEIGHT"); //send the BMI result
                     Bitmap BMI = BitmapFactory.decodeResource(getResources(), R.drawable.underweight); //get image
                     ByteArrayOutputStream stream = new ByteArrayOutputStream(); //to store collection of binary data which is for image
                     BMI.compress(Bitmap.CompressFormat.PNG, 100, stream); //compress the image to byteArray
                     byte[] byteArray = stream.toByteArray(); //create new allocated byteArray and the size same with stream
                     page3.putExtra ("read image", byteArray); //send image data

                 } else if (BMIresult >= 18.5 && BMIresult <= 24.9) {
                     page3.putExtra("calculator",Double.valueOf(oneDForm.format(BMIresult)));
                     page3.putExtra("read data", "NORMAL");
                     Bitmap BMI = BitmapFactory.decodeResource(getResources(), R.drawable.normal);
                     ByteArrayOutputStream stream = new ByteArrayOutputStream();
                     BMI.compress(Bitmap.CompressFormat.PNG, 100, stream);
                     byte[] byteArray = stream.toByteArray();
                     page3.putExtra ("read image", byteArray);

                 } else if (BMIresult >= 25 && BMIresult <= 29.9) {
                     page3.putExtra("read data", "OVERWEIGHT");
                     page3.putExtra("calculator", Double.valueOf(oneDForm.format(BMIresult)));
                     Bitmap BMI = BitmapFactory.decodeResource(getResources(), R.drawable.overweight);
                     ByteArrayOutputStream stream = new ByteArrayOutputStream();
                     BMI.compress(Bitmap.CompressFormat.PNG, 100, stream);
                     byte[] byteArray = stream.toByteArray();
                     page3.putExtra ("read image", byteArray);

                 } else if (BMIresult >= 30 && BMIresult <=34.9) {
                     page3.putExtra("read data", "OBESE");
                     page3.putExtra("calculator", Double.valueOf(oneDForm.format(BMIresult)));
                     Bitmap BMI = BitmapFactory.decodeResource(getResources(), R.drawable.obese);
                     ByteArrayOutputStream stream = new ByteArrayOutputStream();
                     BMI.compress(Bitmap.CompressFormat.PNG, 100, stream);
                     byte[] byteArray = stream.toByteArray();
                     page3.putExtra ("read image", byteArray);

                 } else if (BMIresult >= 35) {
                    page3.putExtra("read data", "EXTREMELY OBESE");
                    page3.putExtra("calculator", Double.valueOf(oneDForm.format(BMIresult)));
                    Bitmap BMI = BitmapFactory.decodeResource(getResources(), R.drawable.extremelyobese);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    BMI.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    page3.putExtra ("read image", byteArray);

                }
                 startActivity(page3); //go to the next page
             }
                }
        });
    }
}
