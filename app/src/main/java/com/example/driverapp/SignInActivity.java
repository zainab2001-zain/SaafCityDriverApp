package com.example.driverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    EditText Email_Phone,Password;
    TextView Forget_Password;
    Button SignInbtn;
    TextView SignUpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_in);

        //hooks
        Email_Phone=findViewById(R.id.emailtextfield);
        Password=findViewById(R.id.password_field);
        Forget_Password=findViewById(R.id.forget_pass);
        SignInbtn=findViewById(R.id.signinbtn);


        SignInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean check=validateinfo(Email_Phone,Password);
                if(check==true){
                    if (Email_Phone.getText().toString().equals("10581")  && Password.getText().toString().equals("1234")){

                        Toast.makeText(SignInActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(SignInActivity.this,Dashboard_Screen.class);
                        startActivity(intent);

                    }

                    else{
                        Toast.makeText(SignInActivity.this,"Incorrect Password or Email",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //forgetpassword
        Forget_Password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignInActivity.this,Forget_Password_Screen.class);
                startActivity(intent);

            }
        });

    }

    private boolean validateinfo(EditText email_phone, EditText password) {
        if(email_phone.length()==0){
            Email_Phone.requestFocus();
            Email_Phone.setError("Field cannot be empty");
            return false;
        }
        else if(password.length()==0){
            Password.requestFocus();
            Password.setError("Field cannot be empty");
            return false;
        }
        return true;

    }
}