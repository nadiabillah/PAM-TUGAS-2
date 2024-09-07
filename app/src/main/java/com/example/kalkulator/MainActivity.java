package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hitungAngka(View view){
        EditText angka1 = findViewById(R.id.angka1);
        EditText angka2 = findViewById(R.id.angka2);

        Spinner hitung = findViewById(R.id.operasi);
        String tipeOperasi = String.valueOf(hitung.getSelectedItem());

        Intent intent = new Intent(this, HasilHitung.class);

        double nilai1 = Double.parseDouble(angka1.getText().toString());
        double nilai2 = Double.parseDouble(angka2.getText().toString());
        double hasil = 0;

        if(tipeOperasi.equals("Tambah")){
            hasil = nilai1 + nilai2;
        }else if(tipeOperasi.equals("Kurang")){
            hasil = nilai1 - nilai2;
        }else if(tipeOperasi.equals("Kali")){
            hasil = nilai1 * nilai2;
        }else if(tipeOperasi.equals("Bagi")){
            if(nilai2 != 0){
                hasil = nilai1 / nilai2;
            }else{
                String pesanError1 = getString(R.string.error1);
                intent.putExtra("pesanError", pesanError1);
            }
        }else if(tipeOperasi.equals("Modulus")){
            hasil = nilai1 % nilai2;
        }

        intent.putExtra("hasil", hasil);
        startActivity(intent);
    }
}