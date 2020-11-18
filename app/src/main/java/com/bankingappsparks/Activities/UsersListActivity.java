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
import com.bankingappsparks.DataBase.DatabaseHelper;
import com.bankingappsparks.R;
import com.bankingappsparks.model.Accounts;

import java.util.ArrayList;
import java.util.List;

public class UsersListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Accounts> accountsArrayList;
    private UsersAdapter usersAdapter;
    private DatabaseHelper db;
    ImageView empty_imageview;
    TextView no_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);

         db = new DatabaseHelper(UsersListActivity.this);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        accountsArrayList = new ArrayList<>();

      //  List<Accounts> accountsList = db.getAllAccounts();
       // accountsArrayList.addAll(accountsList);

        storedata();

        usersAdapter=new UsersAdapter(UsersListActivity.this,accountsArrayList);
        recyclerView.setAdapter(usersAdapter);
    }

    private void storedata() {
        Cursor cursor =db.readAll();
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
             Accounts accounts1= new Accounts(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(4),cursor.getString(3),cursor.getInt(5));
             accountsArrayList.add(accounts1);
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }

    }
}