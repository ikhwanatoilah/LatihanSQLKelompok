package com.example.latihansqlkelompok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnLihatData;
    ImageButton btnInputData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        btnLihatData = (ImageButton)findViewById(R.id.btn_lat23);
        btnLihatData.setOnClickListener(this);
        btnInputData = (ImageButton)findViewById(R.id.btn_lat2);
        btnInputData.setOnClickListener(this);

    }
//    public void inputdata(View view) {
//        Intent i = new Intent(MainActivity.this,InputData.class);
//        startActivity(i);
//    }
//
//    public void lihatdata(View view) {
//        Intent i = new Intent(MainActivity.this,detail_data.class);
//        startActivity(i);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lat2:
                Intent moveInputData = new Intent(MainActivity.this,InputData.class);
                startActivity(moveInputData);
                break;
            case R.id.btn_lat23:
                Intent moveLihatData = new Intent(MainActivity.this, detail_data.class );
                startActivity(moveLihatData);
                break;
        }
    }
}
