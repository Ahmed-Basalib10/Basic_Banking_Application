package com.bankingappsparks.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bankingappsparks.DataBase.DatabaseHelper;
import com.bankingappsparks.R;
import com.bankingappsparks.model.Accounts;

public class MainActivity extends AppCompatActivity {
    ImageView users;
    Button viewUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        users=(ImageView) findViewById(R.id.imageView);
        viewUsers=(Button) findViewById(R.id.viewUsers);

        DatabaseHelper db=new DatabaseHelper(MainActivity.this);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String check = sharedPreferences.getString("FIRST","");
        if(!check.equals("true")){
            Accounts a1= new Accounts(1,"Ahmed","xxxxxxxxxx1234","ahmed@gmail.com","7619348394",10000);
            db.addAccount(a1);
            Accounts a2= new Accounts(2,"Alawi","xxxxxxxxxx1235","alawi@gmail.com","7619348395",1000);
            db.addAccount(a2);
            Accounts a3= new Accounts(3,"Abdullah","xxxxxxxxxx1236","abdul@gmail.com","7619348396",50000);
            db.addAccount(a3);
            Accounts a4= new Accounts(4,"Ali","xxxxxxxxxx1237","ali@gmail.com","7619348397",10000);
            db.addAccount(a4);
            Accounts a5= new Accounts(5,"Salem","xxxxxxxxxx1238","salem@gmail.com","7619348398",7000);
            db.addAccount(a5);
            Accounts a6= new Accounts(6,"Saeed","xxxxxxxxxx1239","saeed@gmail.com","7619348399",8000);
            db.addAccount(a6);
            Accounts a7= new Accounts(7,"Omar","xxxxxxxxxx2234","omar@gmail.com","8619348394",10000);
            db.addAccount(a7);
            Accounts a8= new Accounts(8,"Mohammed","xxxxxxxxxx3234","moh@gmail.com","9619348394",89000);
            db.addAccount(a8);
            Accounts a9= new Accounts(9,"Khalid","xxxxxxxxxx4234","khalid@gmail.com","7719348394",10000);
            db.addAccount(a9);
            Accounts a10= new Accounts(10,"Ahmed2","xxxxxxxxxx5234","ahmed2@gmail.com","7919348394",10000);
            db.addAccount(a10);

            editor.putString("FIRST","true");
            editor.apply();
        }
        
        viewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animations();
            }
        });
    }

    private void animations() {
        users.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.usersanim));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,UsersListActivity.class));

            }
        },400);

    }
}