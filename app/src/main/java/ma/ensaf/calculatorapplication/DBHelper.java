package ma.ensaf.calculatorapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public static final String DBName= "Login.db";

    public DBHelper(Context context) {
        super(context,"login.db",null,1);
    }

    @Override
        public void onCreate(SQLiteDatabase mydatabase) {
            mydatabase.execSQL("create Table users(username TEXT primary key,password TEXT,email TEXT)");



        }

    @Override
    public void onUpgrade(SQLiteDatabase mydatabase, int i, int i1) {
        mydatabase.execSQL("drop Table if exists users");
        onCreate(mydatabase);

    }

    public boolean InsertData(String username,String password,String email){
        SQLiteDatabase myDB= this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("username", username);
            values.put("password", password);
            values.put("email", email);

        Long result= myDB.insert("users", null, values);
            if(result==-1) return false;
            else return true;
    }


    public Boolean checkusername(String username)
    {
        SQLiteDatabase myDB= this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ?",new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else {
            return false;
        }

    }

    public boolean checkusernamePassword(String username,String password)
    {
        SQLiteDatabase myDB= this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ? and password = ?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else {
            return false;
        }


    }
}
