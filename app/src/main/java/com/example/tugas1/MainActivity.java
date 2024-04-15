package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText edtaktif, edttugas, edtuts, edtuas;
    Button hasil;
    TextView angka, abjad;

    Double keaktifan, tugas, uts, uas, Hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtaktif = findViewById(R.id.edtkeaktifan);
        edttugas = findViewById(R.id.edtTugas);
        edtuts = findViewById(R.id.edtUTS);
        edtuas = findViewById(R.id.edtUAS);
        hasil = findViewById(R.id.btnhitung);
        angka = findViewById(R.id.textViewHasilAngka);
        abjad = findViewById(R.id.textViewHasilHuruf);

        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validasi apakah nilai yang dimasukkan pengguna lebih dari 100
                if (!isInputValid()) {
                    // Tampilkan Snackbar jika ada nilai yang diinputkan lebih dari 100
                    Snackbar.make(v, "Nilai tidak boleh lebih dari 100", Snackbar.LENGTH_SHORT)
                            .setAnchorView(v) // Menggunakan tombol "hasil" sebagai anchor
                            .show();
                } else {
                    try {
                        keaktifan = Double.valueOf(edtaktif.getText().toString().trim());
                        tugas = Double.valueOf(edttugas.getText().toString().trim());
                        uts = Double.valueOf(edtuts.getText().toString().trim());
                        uas = Double.valueOf(edtuas.getText().toString().trim());

                        Hitung = (keaktifan * 0.10) + (tugas * 0.15) + (uts * 0.30) + (uas * 0.45);
                        angka.setText("Nilai Angka: " + Hitung);

                        if (Hitung > 85) {
                            abjad.setText("Nilai Huruf: A");
                        } else if (Hitung >= 75) {
                            abjad.setText("Nilai Huruf: B");
                        } else if (Hitung > 65) {
                            abjad.setText("Nilai Huruf: C");
                        } else {
                            abjad.setText("Anda Tidak Lulus");
                        }
                    } catch (NumberFormatException e) {

                    }
                }
            }
        });
    }

    // ini berfungsi untuk memeriksa apakah nilai-nilai yang dimasukkan pengguna dari masing-masing EditText tidak melebihi 100
    private boolean isInputValid() {
        double maxaktif = Double.parseDouble(edtaktif.getText().toString().trim());
        double maxtugas = Double.parseDouble(edttugas.getText().toString().trim());
        double maxuts = Double.parseDouble(edtuts.getText().toString().trim());
        double maxuas = Double.parseDouble(edtuas.getText().toString().trim());
        //Method ini akan mengembalikan true jika semua nilai valid, dan false jika ada nilai yang melebihi 100.
        return (maxaktif <= 100 && maxtugas <= 100 && maxuts <= 100 && maxuas <= 100);
    }
}