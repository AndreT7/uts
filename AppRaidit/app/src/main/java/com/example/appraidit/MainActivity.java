package com.example.appraidit;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText mNama;
    private EditText mNik;
    private EditText mUmur;
    private EditText mAlamat;
    private EditText mAsalSekolah;

    private TextView mviwNama;
    private TextView mviwNik;
    private TextView mviwUmur;
    private TextView mviwAlamat;
    private TextView mviwAsalSekolah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mNama = findViewById(R.id.Nama);
        mNik = findViewById(R.id.Nik);
        mUmur = findViewById(R.id.Umur);
        mAlamat = findViewById(R.id.Alamat);
        mAsalSekolah = findViewById(R.id.AsalSekolah);

    }

    public void save (View view) {
        String nama = mNama.getText().toString();
        String nik = mNik.getText().toString();
        String umur = mUmur.getText().toString();
        String alamat = mAlamat.getText().toString();
        String asalsekolah = mAsalSekolah.getText().toString();

        mviwNama .setText(nama);
        mviwNik .setText(nik);
        mviwUmur .setText(umur);
        mviwAlamat .setText(alamat);
        mviwAsalSekolah .setText(asalsekolah);
    }
}