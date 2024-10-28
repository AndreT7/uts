package com.example.uts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNama, editTextEmail, editTextNoTelp;
    private RadioGroup radioGroupKelamin;
    private CheckBox checkBoxHobi1, checkBoxHobi2, checkBoxHobi3;
    private Button buttonKirim;
    private TextView textViewHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNama = findViewById(R.id.editTextNama);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextNoTelp = findViewById(R.id.editTextNoTelp);
        radioGroupKelamin = findViewById(R.id.radioGroupKelamin);
        checkBoxHobi1 = findViewById(R.id.checkBoxHobi1);
        checkBoxHobi2 = findViewById(R.id.checkBoxHobi2);
        checkBoxHobi3 = findViewById(R.id.checkBoxHobi3);
        buttonKirim = findViewById(R.id.buttonKirim);
        textViewHasil = findViewById(R.id.textViewHasil);

        buttonKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editTextNama.getText().toString();
                String email = editTextEmail.getText().toString();
                String noTelp = editTextNoTelp.getText().toString();

                // Mendapatkan jenis kelamin
                int selectedId = radioGroupKelamin.getCheckedRadioButtonId();
                String kelamin = "";
                if (selectedId == R.id.radioLakiLaki) {
                    kelamin = "Laki-laki";
                } else if (selectedId == R.id.radioPerempuan) {
                    kelamin = "Perempuan";
                }

                // Mendapatkan hobi
                StringBuilder hobi = new StringBuilder();
                if (checkBoxHobi1.isChecked()) hobi.append("Membaca, ");
                if (checkBoxHobi2.isChecked()) hobi.append("Olahraga, ");
                if (checkBoxHobi3.isChecked()) hobi.append("Travelling, ");

                // Menghilangkan koma terakhir jika ada
                if (hobi.length() > 0) {
                    hobi.setLength(hobi.length() - 2);
                }

                // Menampilkan data dalam TextView
                String message = "Nama: " + nama + "\nEmail: " + email + "\nNo. Telepon: " + noTelp +
                        "\nJenis Kelamin: " + kelamin + "\nHobi: " + hobi.toString();
                textViewHasil.setText(message);
            }
        });
    }
}