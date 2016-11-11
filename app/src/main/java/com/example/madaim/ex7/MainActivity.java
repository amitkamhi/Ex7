package com.example.madaim.ex7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REGISTER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRegister(View view){
        Intent intent = new Intent(this,Register.class);
        intent.setAction(Register.ACTION_REGISTER);
        startActivityForResult(intent,REGISTER_REQUEST );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REGISTER_REQUEST && resultCode == RESULT_OK){

            String firstName = data.getExtras().getString("First Name");
            String lastName = data.getExtras().getString("Last Name");
            String gender = data.getExtras().getString("Gender");


            Toast.makeText(this, "Welcome " + gender + firstName + " " + lastName ,Toast.LENGTH_LONG).show();
        }
    }


}
