package com.example.madaim.ex7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    public static final String ACTION_REGISTER = "com.Ex7.Register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Intent intent = getIntent();
        if(intent == null || intent.getAction() == null || (!intent.getAction().equals(ACTION_REGISTER)) ){
            Toast.makeText(getApplicationContext(), R.string.messageOnCreate, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void sendResult(View view){
        Intent intent = new Intent();

        EditText firstName = (EditText)findViewById(R.id.eTFirst);
        EditText lastName = (EditText) findViewById(R.id.eTLast);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rG);

        RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        int index = radioGroup.indexOfChild(radioButton);

        if((firstName.getText().toString().isEmpty() || (lastName.getText().toString().isEmpty() || index == -1))){
            Toast.makeText(this, R.string.messageReturn, Toast.LENGTH_SHORT).show();
        }
        else{
            String firstN = firstName.getText().toString();
            String lastN = lastName.getText().toString();
            int radioButtonId = radioGroup.getCheckedRadioButtonId();

            intent.putExtra("First Name", firstN);
            intent.putExtra("Last Name", lastN);
            intent.putExtra("Gender", radioButtonId == R.id.rBMale ? "Mr." : "Ms.");

            setResult(RESULT_OK, intent);
            finish();
        }


    }
}
