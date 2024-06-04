package com.example.driverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {

    Button Staus_btn;
    TextView complaint_no,Complaint_date,complaint_time,complaint_status;
    ImageView Complaint_Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_task);

        Staus_btn=findViewById(R.id.Status_button);
        complaint_no=findViewById(R.id.Complaint_no);
        Complaint_date=findViewById(R.id.Complaint_Date);
        complaint_time=findViewById(R.id.Complaint_Time);
        complaint_status=findViewById(R.id.Complaint_Status);
        Complaint_Image=findViewById(R.id.complaint_image);

        Staus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Staus_btn.setText("Completed");
            }
        });
    }
}