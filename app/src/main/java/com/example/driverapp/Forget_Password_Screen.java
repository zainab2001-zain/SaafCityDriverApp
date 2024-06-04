package com.example.driverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forget_Password_Screen extends AppCompatActivity {

    EditText Emailfield;
    Button sendbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forget_password_screen);
        Emailfield=findViewById(R.id.emailtextfield);
        sendbtn=findViewById(R.id.sendbtn);
        String email = Emailfield.getText().toString();

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateEmail(Emailfield);
            }});
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    private boolean validateEmail(EditText email){
        String emailInput=email.getText().toString();
        if(isEmpty(Emailfield)){
            Toast.makeText(Forget_Password_Screen.this, "Please provide an email!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Toast.makeText(this,"Please check your email",Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            Toast.makeText(this,"Invalid Email Adrees",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    }
