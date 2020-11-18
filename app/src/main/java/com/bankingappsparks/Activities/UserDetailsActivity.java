package com.bankingappsparks.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bankingappsparks.R;

public class UserDetailsActivity extends AppCompatActivity {
    private TextView textView, userName;
    private String id,name,acno,email,phone,balance;
    private LinearLayout ll1,ll2,ll3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        id=getIntent().getStringExtra("ID");
        name=getIntent().getStringExtra("NAME");
        acno=getIntent().getStringExtra("ACNO");
        email=getIntent().getStringExtra("EMAIL");
        phone=getIntent().getStringExtra("PHONE");
        balance=getIntent().getStringExtra("BALANCE");

        textView=(TextView) findViewById(R.id.balance);
        userName=(TextView)findViewById(R.id.userName);
        userName.setText("Mr "+name);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Rs."+balance+"/-");
            }
        });


        ll1=(LinearLayout) findViewById(R.id.ll1) ;
        ll2=(LinearLayout) findViewById(R.id.ll2) ;
        ll3=(LinearLayout) findViewById(R.id.ll3) ;
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(UserDetailsActivity.this,UserAccountActivity.class);
                intent.putExtra("ID",id);
                intent.putExtra("NAME",name);
                intent.putExtra("ACNO",acno);
                intent.putExtra("EMAIL",email);
                intent.putExtra("PHONE",phone);
                intent.putExtra("BALANCE",balance);
                startActivity(intent);
            }
        });
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(UserDetailsActivity.this,TransferActivity.class);
                intent.putExtra("ID",id);
                intent.putExtra("ACNO",acno);
                intent.putExtra("BALANCE",balance);
                startActivity(intent);
            }
        });
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(UserDetailsActivity.this,TransactionActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
            }
        });

    }

}