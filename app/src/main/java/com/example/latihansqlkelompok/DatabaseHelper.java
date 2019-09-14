package com.example.latihansqlkelompok;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION=1;
    private static final String DB_NAME="UserInfo";
    private static final String TABLE_NAME="tbl_mahasiswa";
    private static final String KEY_NO="no";
    private static final String KEY_NAMA="nama";
    private static final String KEY_DATE="date";
    private static final String KEY_JK="jk";
    private static final String KEY_ALAMAT="alamat";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createUserTable="Create Table " +TABLE_NAME+"("+KEY_NO+" INTEGER PRIMARY KEY,"+KEY_NAMA+" TEXT,"+KEY_DATE+" DATE,"+KEY_JK+" TEXT,"+KEY_ALAMAT+" TEXT"+")";
        db.execSQL(createUserTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql=("drop table if exists " +TABLE_NAME);
        db.execSQL (sql);
        onCreate (db);
    }

    public void insert (Data data){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(KEY_NO, data.getNo ());
        values.put(KEY_NAMA, data.getNama ());
        values.put(KEY_DATE, data.getTanggal ());
        values.put(KEY_JK, data.getJeniskelamin ());
        values.put(KEY_ALAMAT, data.getAlamat ());
        db.insert (TABLE_NAME,null,values);
    }

    public List<Data> selectUserData(){
        ArrayList<Data> userList= new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase ();
        String[] columns ={KEY_NO,KEY_NAMA,KEY_DATE,KEY_JK,KEY_ALAMAT};

        Cursor c =db.query (TABLE_NAME,columns,null,null,null,null,null);
        while (c.moveToNext ()){

            int no=c.getInt (0);
            String nama=c.getString (1);
            String date=c.getString (2);
            String jk=c.getString (3);
            String alamat=c.getString (4);

            Data data = new Data();
            data.setNo (no);
            data.setNama (nama);
            data.setTanggal (date);
            data.setJeniskelamin (jk);
            data.setAlamat (alamat);
            userList.add(data);

        }
        return userList;
    }

    public void delete(String nama){
        SQLiteDatabase db = getWritableDatabase ();
        String WhereClause = KEY_NAMA+"='"+nama+"'";
        db.delete (TABLE_NAME,WhereClause,null);
    }

    public void update(Data data){
        SQLiteDatabase db = getReadableDatabase ();
        ContentValues values = new ContentValues();
        values.put (KEY_NAMA, data.getNama ());
        values.put (KEY_ALAMAT, data.getAlamat ());
        values.put (KEY_DATE, data.getTanggal ());
        values.put (KEY_JK, data.getJeniskelamin ());
        String whereClause = KEY_NO+"='"+ data.getNo ()+"'";
        db.update (TABLE_NAME,values,whereClause,null);
    }



}
