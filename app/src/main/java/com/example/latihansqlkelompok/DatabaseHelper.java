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
    private static final String TABLE_NAME="tbl_user";
    private static final String PRIMARY_KEY="nomor";
    private static final String COLUMN_NAME="nama";
    private static final String COLUMN_DATE="tgl";
    private static final String COLUMN_TYPE="jenkel";
    private static final String COLUMN_HOME="alamat";

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="Create Table OldBear(id_bear INTEGER PRIMARY KEY, bear_name TEXT,bear_date TEXT,bear_type TEXT,bear_home TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = ("drop table if exists " +TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);

    }
    public List<Data> selectUserData(){
        ArrayList<Data> userList=new ArrayList<Data>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns={PRIMARY_KEY,COLUMN_NAME,COLUMN_DATE,COLUMN_TYPE,COLUMN_HOME};
        Cursor c = db.query(TABLE_NAME,columns,null,null,null,null,null);

        while(c.moveToNext()){
            int no=c.getInt(0);
            String nama=c.getString(1);
            String tgl=c.getString(2);
            String jenkel=c.getString(3);
            String alamat=c.getString(4);
            Data data=new Data();
            data.setNo(no);
            data.setNama(nama);
            data.setTgl(tgl);
            data.setJenkel(jenkel);
            data.setAlamat(alamat);
            userList.add(data);

            Data personBean=new Data();
            personBean.setNo(no);
            personBean.setNama(nama);
            personBean.setTgl(tgl);
            personBean.setJenkel(jenkel);
            personBean.setAlamat(alamat);
            userList.add(personBean);
        }
        return userList;
    }
    public Data selectUserData(String ids){
        Data data =new Data();
        SQLiteDatabase db= getReadableDatabase();
        String[] columns={PRIMARY_KEY,COLUMN_NAME,COLUMN_DATE,COLUMN_TYPE,COLUMN_HOME};
        String query2 = "select * from "+TABLE_NAME+" where "+PRIMARY_KEY+" = "+ids;
        System.out.println(query2);
        Cursor c = db.rawQuery(query2,null);
        while (c.moveToNext()){
            System.out.println("In");
            int no =c.getInt(0);
            String nama=c.getString(1);
            String tgl=c.getString(2);
            String jenkel=c.getString(3);
            String alamat=c.getString(4);
            data.setNo(no);
            data.setNama(nama);
            data.setTgl(tgl);
            data.setJenkel(jenkel);
            data.setAlamat(alamat);
        }
        return data;
    }
    public void delete(String no){
        SQLiteDatabase db =getWritableDatabase();
        String whereClause=PRIMARY_KEY+"='"+no+"'";
        db.delete(TABLE_NAME,whereClause,null);
    }
    public void update(Data data){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE,data.getTgl());
        values.put(COLUMN_NAME,data.getNama());
        values.put(COLUMN_TYPE,data.getJenkel());
        values.put(COLUMN_HOME,data.getAlamat());
        String whereClause=PRIMARY_KEY+"='"+data.getNo()+"'";
        db.update(TABLE_NAME,values,whereClause,null);
    }
    public void insert(Data data){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRIMARY_KEY,data.getNo());
        values.put(COLUMN_NAME,data.getNama());
        values.put(COLUMN_DATE,data.getTgl());
        values.put(COLUMN_TYPE,data.getJenkel());
        values.put(COLUMN_HOME,data.getAlamat());

        db.insert(TABLE_NAME,null,values);
    }
}
