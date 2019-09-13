package com.example.latihansqlkelompok;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class detail_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        Context context=this;
        EditText nomor = findViewById(R.id.nomor);
        EditText nama =  findViewById(R.id.nama);
        EditText tanggal =  findViewById(R.id.tanggal);
        EditText kelamin =  findViewById(R.id.kelamin);
        EditText alamat =  findViewById(R.id.alamat);
        Button btn = findViewById(R.id.btn_simpan);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        final DatabaseHelper db =  new DatabaseHelper(context);

        String no = bundle.getString("no");
        final Data data = db.selectUserData(no);
        nomor.setText(data.getNo()+"");
        nama.setText(data.getNama());
        tanggal.setText(data.getTgl());
        kelamin.setText(data.getJenkel());
        alamat.setText(data.getAlamat());
        nomor.setFocusable(false);
        nomor.setFocusableInTouchMode(false);
        nama.setFocusable(false);
        nama.setFocusableInTouchMode(false);
        tanggal.setFocusable(false);
        tanggal.setFocusableInTouchMode(false);
        kelamin.setFocusable(false);
        kelamin.setFocusableInTouchMode(false);
        alamat.setFocusable(false);
        alamat.setFocusableInTouchMode(false);
    }
}
