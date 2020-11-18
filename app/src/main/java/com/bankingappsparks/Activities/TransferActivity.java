package com.bankingappsparks.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bankingappsparks.DataBase.DatabaseHelper;
import com.bankingappsparks.R;
import com.bankingappsparks.model.Accounts;
import com.bankingappsparks.model.Transactions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TransferActivity extends AppCompatActivity {
    private String id_sender,acno_sender,balance_sender;
    private String acnorec,balancerec;
    private int idrec;
    private TextView text1;
    private EditText amount;
    private Button transfer;
    private Spinner spinner;
    private String usersACNO[],usersBalance[];
    private int usersid[];
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        id_sender=getIntent().getStringExtra("ID");
        acno_sender=getIntent().getStringExtra("ACNO");
        balance_sender=getIntent().getStringExtra("BALANCE");
        db = new DatabaseHelper(TransferActivity.this);
        storedata(id_sender);



        text1=(TextView) findViewById(R.id.debitfrom);
        spinner=(Spinner) findViewById(R.id.creditto);
        amount=(EditText) findViewById(R.id.amount) ;
        transfer=(Button) findViewById(R.id.transfer);
        text1.setText(acno_sender);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,usersACNO);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 acnorec= adapterView.getItemAtPosition(i).toString();
                 idrec = usersid[i];
                balancerec =usersBalance[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

       transfer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String amount1 =amount.getText().toString();
               if(amount1.isEmpty()){
                   amount.setError("Amount is required");
                   amount.requestFocus();
                   return;
               }
               if(Integer.parseInt(amount1)==0){
                   amount.setError("Error");
                   amount.requestFocus();
                   return;
               }
               if(Integer.parseInt(amount1)>Integer.parseInt(balance_sender)){
                   amount.setError("No sufficient balance");
                   amount.requestFocus();
                   return;
               }

               String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
               String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());



               boolean a= db.insertTransferData(currentDate,currentTime,acno_sender,acnorec,Integer.parseInt(amount1),"Credit",idrec);
               if(a){
                   boolean b=db.insertTransferData(currentDate,currentTime,acno_sender,acnorec,Integer.parseInt(amount1),"Debit",Integer.parseInt(id_sender));
                   if(b){
                       int remainingSender = Integer.parseInt(balance_sender) - Integer.parseInt(amount1);
                       int plusRec =Integer.parseInt(balancerec) + Integer.parseInt(amount1);
                       db.updateSender(String.valueOf(remainingSender),Integer.parseInt(id_sender));
                       db.updateRec(String.valueOf(plusRec),idrec);

                       Toast.makeText(getApplicationContext(),"Your Transaction has been Done Successfully",Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(TransferActivity.this,UsersListActivity.class));
                       finishAffinity();
                   }
               }
           }
       });


    }
    private void storedata(String s) {
        Cursor cursor =db.readAllEx(s);
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"No data",Toast.LENGTH_SHORT).show();
        }else{
                usersid=new int[cursor.getCount()];
                usersACNO=new String[cursor.getCount()];
                usersBalance=new String[cursor.getCount()];
                cursor.moveToFirst();
                for(int i=0;i<usersid.length;i++){
                    usersid[i]=cursor.getInt(0);
                    usersACNO[i]=cursor.getString(2);
                    usersBalance[i]=cursor.getString(5);
                    cursor.moveToNext();
                }
        }
    }
}