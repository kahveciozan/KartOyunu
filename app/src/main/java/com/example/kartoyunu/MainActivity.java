package com.example.kartoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {       //innerclass ( içsınıf )
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OyunEkraniActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
