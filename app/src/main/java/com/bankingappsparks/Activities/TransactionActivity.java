package com.bankingappsparks.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bankingappsparks.Adapters.UsersAdapter;
import com.bankingappsparks.Adapters.UsersAdapter2;
import com.bankingappsparks.DataBase.DatabaseHelper;
import com.bankingappsparks.R;
import com.bankingappsparks.model.Accounts;
import com.bankingappsparks.model.Transactions;

import java.util.ArrayList;

public class TransactionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Transactions> accountsArrayList;
    private UsersAdapter2 usersAdapter;
    private DatabaseHelper db;
    ImageView empty_imageview;
    TextView no_data;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        id=getIntent().getStringExtra("ID");

        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);

        db = new DatabaseHelper(TransactionActivity.this);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        accountsArrayList = new ArrayList<>();


        storedata(id);

        usersAdapter=new UsersAdapter2(TransactionActivity.this,accountsArrayList);
        recyclerView.setAdapter(usersAdapter);
    }

    private void storedata(String id) {
        Cursor cursor =db.readAllTransactions(id);
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                Transactions transactions= new Transactions(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getString(6),cursor.getInt(7));
                accountsArrayList.add(transactions);
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }


    }
}