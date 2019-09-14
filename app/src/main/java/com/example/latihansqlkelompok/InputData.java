package com.example.latihansqlkelompok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class InputData extends AppCompatActivity {
    public static String EXTRA_PERSON = " extra_person";
    public static String ACTION = "Insert";

    protected OnBackPressedListener onBackPressedListener;

    public interface OnBackPressedListener {
        void doBack();
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }

    @Override
    public void onBackPressed() {
        if (onBackPressedListener != null)
            onBackPressedListener.doBack();
        else
            super.onBackPressed();
    }

    EditText no,nama,alamat,jk,tanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_tambah);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        no = findViewById (R.id.tambahNo);
        nama = findViewById (R.id.tambahNama);
        alamat = findViewById (R.id.tambahAlamat);
        jk = findViewById (R.id.tambahJk);
        tanggal = findViewById (R.id.tambahTanggal);

        if(getIntent().hasExtra("Update")) {
            Data data = getIntent ().getParcelableExtra (EXTRA_PERSON);
            no.setText (data.getNo ()+"");
            nama.setText (data.getNama ()+"");
            alamat.setText (data.getAlamat ()+"");
            tanggal.setText (data.getTanggal ()+"");
            jk.setText (data.getJeniskelamin ()+"");
        }



    }

    public void simpanData(View view) {
        DatabaseHelper db = new DatabaseHelper(this);
        Data currentData = new Data();

        if(!getIntent().hasExtra("Update")) {
            currentData.setNo(Integer.parseInt(no.getText().toString()));
            currentData.setNama (nama.getText().toString ());
            currentData.setAlamat (alamat.getText().toString ());
            currentData.setJeniskelamin (jk.getText().toString ());
            currentData.setTanggal (tanggal.getText().toString ());
            db.insert(currentData);
        }else{
            currentData.setNo(Integer.parseInt(no.getText().toString()));
            currentData.setNama (nama.getText().toString ());
            currentData.setAlamat (alamat.getText().toString ());
            currentData.setJeniskelamin (jk.getText().toString ());
            currentData.setTanggal (tanggal.getText().toString ());
            db.update(currentData);
        }
        Intent simpanData = new Intent(InputData.this, DaftarNama.class);
        startActivity(simpanData);
    }
}
