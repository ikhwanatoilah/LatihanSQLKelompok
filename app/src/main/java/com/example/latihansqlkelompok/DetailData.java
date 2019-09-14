package com.example.latihansqlkelompok;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailData extends AppCompatActivity {
    public static String EXTRA_PERSON = " extra_person";
    EditText no,nama,alamat,tanggal,jk;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        Data data = getIntent ().getParcelableExtra (EXTRA_PERSON);

        setContentView (R.layout.detail_data);
        no = findViewById (R.id.detailNo);
        nama = findViewById (R.id.detailNama);
        alamat = findViewById (R.id.detailAlamat);
        tanggal = findViewById (R.id.detailTanggal);
        jk = findViewById (R.id.detailJk);



        no.setText (data.getNo ()+"");
        nama.setText (data.getNama ()+"");
        alamat.setText (data.getAlamat ()+"");
        tanggal.setText (data.getTanggal ()+"");
        jk.setText (data.getJeniskelamin ()+"");
    }
}
