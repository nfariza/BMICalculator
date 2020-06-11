package com.example.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ThankYou extends AppCompatActivity {

    RadioGroup RGloop;
    RadioButton Yes;
    RadioButton No;
    Button  submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        RGloop = (RadioGroup)findViewById(R.id.RGrepeat);
        submit = (Button)findViewById(R.id.BTNsubmit);


    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (RGloop.getCheckedRadioButtonId()!=-1){
                int radioButtonID = RGloop.getCheckedRadioButtonId();
                RadioButton radioButtonSubmit = (RadioButton)RGloop.findViewById(radioButtonID);
                int index = RGloop.indexOfChild(radioButtonSubmit);

                if (index == 0) {
                    Intent page1 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(page1);
                } else if (index == 1) {

                    //use to display dialog message
                    AlertDialog.Builder builder = new AlertDialog.Builder(ThankYou.this); //use to create an AlertDialog
                    builder.setTitle("Exit");
                    builder.setMessage("Do you want to exit?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogBox, int i) { //add action button - accept to continue
                            finishAffinity(); //exit all activity
                        }

                });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogBox, int i) { //add action button - cancel action
                            dialogBox.dismiss(); //dismiss the dialog box (will stay at the last page

                        }
                    });
                    AlertDialog dialog = builder.create(); //create the alert dialog - call the builder
                    dialog.show(); //display the dialog
                }
            }

            else {
                Toast.makeText(getApplicationContext(), "PLEASE CHOOSE AN OPTION", Toast.LENGTH_LONG).show();
            }
        }
    });

    }
}
