package com.bankingappsparks.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bankingappsparks.R;

public class UserAccountActivity extends AppCompatActivity {
    private String id,name,acno,email,phone,balance;
    private TextView text1 ,text2,text3,text4,text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        id=getIntent().getStringExtra("ID");
        name=getIntent().getStringExtra("NAME");
        acno=getIntent().getStringExtra("ACNO");
        email=getIntent().getStringExtra("EMAIL");
        phone=getIntent().getStringExtra("PHONE");
        balance=getIntent().getStringExtra("BALANCE");

        text1=(TextView) findViewById(R.id.nameUser);
        text2=(TextView) findViewById(R.id.useraccount);
        text3=(TextView) findViewById(R.id.useremail);
        text4=(TextView) findViewById(R.id.userphone);
        text5=(TextView) findViewById(R.id.userbalance);

        text1.setText(name);
        text2.setText(acno);
        text3.setText(email);
        text4.setText(phone);
        text5.setText("Rs."+balance+"/-");


    }
}