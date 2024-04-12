package com.example.aplikasiku;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit_nama, edit_nik, edit_ttl, edit_alamat, edit_email, edit_tel;
    private RadioButton radio_btn_lk, radio_btn_pr;
    private Button btn_smb, btn_clr;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_nama = findViewById(R.id.edit_nama);
        edit_nik = findViewById(R.id.edit_nik);
        edit_ttl = findViewById(R.id.edit_ttl);
        edit_alamat = findViewById(R.id.edit_alamat);
        edit_email = findViewById(R.id.edit_email);
        edit_tel = findViewById(R.id.edit_tel);
        radio_btn_lk = findViewById(R.id.radio_btn_lk);
        radio_btn_pr = findViewById(R.id.radio_btn_pr);
        btn_smb = findViewById(R.id.btn_smb);
        btn_clr = findViewById(R.id.btn_clr);

        btn_smb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edit_nama.getText().toString().equals("") && !edit_nik.getText().toString().equals("")
                        && !edit_ttl.getText().toString().equals("") && !edit_alamat.getText().toString().equals("")
                        && !edit_email.getText().toString().equals("") && !edit_tel.getText().toString().equals("")) {
                    if (radio_btn_lk.isChecked() || radio_btn_pr.isChecked()) {

                        Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, DataActivity.class);
                        intent.putExtra("nama", edit_nama.getText().toString().toUpperCase());
                        intent.putExtra("nik", edit_nik.getText().toString());
                        if (radio_btn_lk.isChecked()) {
                            intent.putExtra("lk", radio_btn_lk.getText().toString());
                        } else {
                            intent.putExtra("pr", radio_btn_pr.getText().toString());
                        }
                        intent.putExtra("ttl", edit_ttl.getText().toString().toUpperCase());
                        intent.putExtra("alamat", edit_alamat.getText().toString().toUpperCase());
                        intent.putExtra("email", edit_email.getText().toString());
                        intent.putExtra("tel", edit_tel.getText().toString());
                        startActivity(intent);
                    } else if (!radio_btn_lk.isChecked() && !radio_btn_pr.isChecked()) {
                        Toast.makeText(MainActivity.this, "Jenis Kelamin Harap Dipilih !!!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Data Harap Diisi SEMUA !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_nama.setText("");
                edit_nik.setText("");
                edit_ttl.setText("");
                edit_alamat.setText("");
                edit_email.setText("");
                edit_tel.setText("");
                radio_btn_lk.setChecked(false);
                radio_btn_pr.setChecked(false);
                edit_nama.requestFocus();
            }
        });
    }
}