package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HasilHitung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_hitung);

        Intent intent = getIntent();

        TextView tampilHitung = findViewById(R.id.tampilHitung);

        if(intent.hasExtra("pesanError")){
            tampilHitung.setText(intent.getStringExtra("pesanError"));
        } else{
            tampilHitung.setText(String.valueOf(intent.getDoubleExtra("hasil", 0)));
        }
    }
}