package com.example.kartoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SkorActivity_Win extends AppCompatActivity {
    TextView textViewSkor3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor__win);

        textViewSkor3 = findViewById(R.id.textViewSkor3);

        Intent intent =getIntent();
        int skor = intent.getIntExtra("skor",0);

        textViewSkor3.setText("SKOR : "+skor);


        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkorActivity_Win.this,OyunEkraniActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
