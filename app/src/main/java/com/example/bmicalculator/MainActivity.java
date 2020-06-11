//NUR FARIZA BINTI BAHARUDDIN (110048699)
//PUVEEMALAR A/P PARAMESWARAN (110050059)

package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.ETgetname);
        next = (Button)findViewById(R.id.BTNnext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameUser = name.getText().toString(); //get the name user insert
                if(nameUser.isEmpty()){ //if the name is empty, this text tast will appear
                    Toast.makeText(getApplicationContext(), "PLEASE ENTER YOUR NAME", Toast.LENGTH_LONG).show();
                }
                else { //it will bring to the next page.
                    Intent page2 = new Intent(getApplicationContext(), PersonalDetails.class);
                    page2.putExtra("details", "HI " +nameUser+ "!"); // putExtra use to put/send the data
                    startActivity(page2); //go to the next page
                }
            }
        });

    }
}
