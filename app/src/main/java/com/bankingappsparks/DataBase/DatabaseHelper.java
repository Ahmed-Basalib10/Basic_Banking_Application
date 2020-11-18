package com.bankingappsparks.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


import com.bankingappsparks.Params.parm;
import com.bankingappsparks.model.Accounts;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    public DatabaseHelper(Context context) {
        super(context, parm.DB_NAME, null, parm.DB_version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+parm.TABLE_NAME+"("
                +parm.KEY_ID+" INTEGER PRIMARY KEY ,"
                +parm.Name+" TEXT ,"
                +parm.Account_no+" TEXT ,"
                +parm.Phone+" TEXT, "
                +parm.Email+" TEXT, "
                +parm.Balance+" INTEGER "+")");


        sqLiteDatabase.execSQL("CREATE TABLE "+parm.TABLE_NAME_1+"("
                +parm.KEY_ID1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +parm.Date+" TEXT ,"
                +parm.Time+" TEXT ,"
                +parm.Sender_acc+" TEXT ,"
                +parm.Receiver_acc+" TEXT ,"
                +parm.Amount+" INTEGER ,"
                +parm.Status+" TEXT ,"
                +parm.UserId+" INTEGER"+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + parm.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + parm.TABLE_NAME_1);
        onCreate(sqLiteDatabase);

    }
    //Function to add accounts
    public void addAccount(Accounts accounts)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        //values.put(Params.KEY_ID,accounts.getId1());
        values.put(parm.Name,accounts.getName());
        values.put(parm.Account_no,accounts.getAccount_no());
        values.put(parm.Email,accounts.getEmail());
        values.put(parm.Phone,accounts.getPhone());
        values.put(parm.Balance,accounts.getBalance());

        db.insert(parm.TABLE_NAME,null,values);
        Log.d("db","Successfully inserted");
        db.close();
    }



    public Cursor readAll(){
        String query = "SELECT * FROM " + parm.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public void deleteall(){
        SQLiteDatabase db =this.getWritableDatabase();
        db.delete(parm.TABLE_NAME, null, null);
    }

    public Cursor readAllEx(String sender) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=null;
        if(db != null) {
             cursor = db.rawQuery("SELECT * FROM " +     parm.TABLE_NAME + " WHERE " + parm.KEY_ID +
                    "!='" + sender + "'", null);
        }

        return cursor;

    }

    public boolean insertTransferData(String date,String time,String from_acc, String to_acc, int amount, String status,int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(parm.Date, date);
        contentValues.put(parm.Time, time);
        contentValues.put(parm.Sender_acc, from_acc);
        contentValues.put(parm.Receiver_acc, to_acc);
        contentValues.put(parm.Amount, amount);
        contentValues.put(parm.Status, status);
        contentValues.put(parm.UserId,userid);
        long a=db.insert(parm.TABLE_NAME_1,null,contentValues);
        if(a ==-1){
          return false;
        }else{
            return true;
        }
    }

    public void updateSender(String valueOf,int id) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(parm.Balance,valueOf);
        db.update(parm.TABLE_NAME,values,parm.KEY_ID+"=?",new String[]{String.valueOf(id)});
    }

    public void updateRec(String valueOf,int id) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(parm.Balance,valueOf);
        db.update(parm.TABLE_NAME,values,parm.KEY_ID+"=?",new String[]{String.valueOf(id)});
    }

    public Cursor readAllTransactions(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=null;
        if(db != null) {
            cursor = db.rawQuery("SELECT * FROM " +     parm.TABLE_NAME_1 + " WHERE " + parm.UserId +
                    "='" + id + "'", null);
        }

        return cursor;
    }
}
