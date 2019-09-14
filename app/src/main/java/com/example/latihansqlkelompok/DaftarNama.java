package com.example.latihansqlkelompok;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DaftarNama extends AppCompatActivity implements View.OnClickListener,RecyclerviewAdapter.OnUserClickListener {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    Context context;
    List<Data> listData;
    boolean test = true;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_nama);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        recyclerView = findViewById (R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager (layoutManager);

        setupRecyclerView();

    }

    public void inputData(View view) {
        Intent formTambah = new Intent(DaftarNama.this, InputData.class);
        startActivity(formTambah);
    }

    private void setupRecyclerView() {
        DatabaseHelper db = new DatabaseHelper(this);
        listData = db.selectUserData();

        RecyclerviewAdapter adapter = new RecyclerviewAdapter(this, listData,this);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tv_input){
            inputData(v);
        }

    }

    @Override
    public void onUserClick(final Data currentMahasiwa) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pilih Menu");

            String[] isiDialog = {"Lihat Data", "Update Data", "Hapus Data"};
            builder.setItems(isiDialog, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            Data mPerson = new Data();
                            mPerson.setNo (currentMahasiwa.getNo ());
                            mPerson.setNama (currentMahasiwa.getNama ());
                            mPerson.setTanggal (currentMahasiwa.getTanggal ());
                            mPerson.setJeniskelamin (currentMahasiwa.getJeniskelamin ());
                            mPerson.setAlamat (currentMahasiwa.getAlamat ());
                            Intent detail = new Intent(DaftarNama.this, DetailData.class);
                            detail.putExtra(DetailData.EXTRA_PERSON,mPerson);
                            startActivity(detail);
                            break;
                        case 1:
                            Data data = new Data();
                            data.setNo (currentMahasiwa.getNo ());
                            data.setNama (currentMahasiwa.getNama ());
                            data.setTanggal (currentMahasiwa.getTanggal ());
                            data.setJeniskelamin (currentMahasiwa.getJeniskelamin ());
                            data.setAlamat (currentMahasiwa.getAlamat ());
                            Intent update = new Intent(DaftarNama.this, InputData.class);
                            update.putExtra("Update","Update");
                            update.putExtra(InputData.EXTRA_PERSON, data);
                            startActivity(update);
                            break;
                        case 2:
                            DatabaseHelper db=new DatabaseHelper(DaftarNama.this);
                            db.delete(currentMahasiwa.getNama ());
                            setupRecyclerView();
                            break;
                    }
                }
            });

// create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }


}
