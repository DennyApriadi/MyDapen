package com.example.aplikasiku;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    TextView data_nama, data_nik, data_jk_lk, data_jk_pr, data_ttl, data_alamat, data_email, data_tel;

    Button btn_inp;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        data_nama = findViewById(R.id.data_nama);
        data_nik = findViewById(R.id.data_nik);
        data_jk_lk = findViewById(R.id.data_jk_lk);
        data_jk_pr = findViewById(R.id.data_jk_pr);
        data_ttl = findViewById(R.id.data_ttl);
        data_alamat = findViewById(R.id.data_alamat);
        data_email = findViewById(R.id.data_email);
        data_tel = findViewById(R.id.data_tel);
        btn_inp = findViewById(R.id.btn_inp);

        data_nama.setText(getIntent().getStringExtra("nama"));
        data_nik.setText(getIntent().getStringExtra("nik"));
        data_jk_pr.setText(getIntent().getStringExtra("pr"));
        data_jk_lk.setText(getIntent().getStringExtra("lk"));
        data_ttl.setText(getIntent().getStringExtra("ttl"));
        data_alamat.setText(getIntent().getStringExtra("alamat"));
        data_email.setText(getIntent().getStringExtra("email"));
        data_tel.setText(getIntent().getStringExtra("tel"));

        btn_inp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
