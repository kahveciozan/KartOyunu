package com.example.kartoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SkorActivity extends AppCompatActivity {
    TextView textViewSkor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);

        textViewSkor = findViewById(R.id.textViewSkor);

        Intent intent =getIntent();
        int skor = intent.getIntExtra("skor",0);

        textViewSkor.setText("SKOR : "+skor);


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkorActivity.this,OyunEkraniActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
