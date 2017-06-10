package com.example.vektorel.kutuphane;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vektorel on 10.06.2017.
 */
public class MyDB extends SQLiteOpenHelper {

    static final String dbName = "KUTUPHANE";
    static final int dbVersiyon = 1;

    final String createUyeTablosu = "CREATE TABLE UYE "
                                    //+"IF NOT EXISTS " +
                                    +"(ID INTEGER PRIMARY KEY, " +
                                    "NAME TEXT);";

    final String getKisiList = "SELECT * FROM UYE";

    public MyDB(Context context) {
        super(context, dbName, null, dbVersiyon);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUyeTablosu);
    }




    public void kisiEkle(int id, String name){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID",id);
        values.put("NAME",name);
        db.insert("UYE",null,values);
    }

    public List<Uye> getKisiList(){
        List<Uye> uyeList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(getKisiList,null);
        Uye uye = null;
        while(cursor.moveToNext()){
            uye = new Uye(cursor.getInt(0),cursor.getString(1));
            uyeList.add(uye);
        }
        return uyeList;
    }


    public Uye getKisi(int ID){
        String id = String.valueOf(ID);

        String[] myArray = {id};

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("UYE",
                    new String[]{"ID", "NAME"}, "ID = ?",
                    myArray, "", "", "");


        Uye uye = null;
        if (cursor.moveToFirst()){
            uye = new Uye(cursor.getInt(0),cursor.getString(1));
        }

        return uye;
    }

    public boolean getKisiSil(int ID){
        String id = String.valueOf(ID);
        String[] myArray = {id};
        SQLiteDatabase db = this.getReadableDatabase();
        if(db.delete("UYE", "ID = ?",
                myArray)>0){
            return true;
        }
        return false;
    }






    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
