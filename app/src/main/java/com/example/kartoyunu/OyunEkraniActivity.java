package com.example.kartoyunu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class OyunEkraniActivity extends AppCompatActivity {
    int sonKart=-1;
    int skor =0;
    int eslesmeSayisi=0;
    int hata = 10;
    TextView tvSkor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_ekrani);

        tvSkor = findViewById(R.id.textViewSkor);

        final Intent i = getIntent();
        String isim = i.getStringExtra("mesaj");
        TextView tv = findViewById(R.id.textViewRestart);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OyunEkraniActivity.this,OyunEkraniActivity.class);
                startActivity(intent);
                finish();
            }
        });



        GridLayout gl =findViewById(R.id.gl);

        Kart kartlar[] = new Kart[16];


        //Yeni kart olustur
        for(int j=0;j<16;j++){
            kartlar[j] = new Kart(this,j);
            kartlar[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Kart k1 = (Kart)v;            // View nesnesini Kart olarak cast ettim
                    k1.cevir();

                    if(sonKart>-1){
                        final Kart k2 = findViewById(sonKart);

                        if (k2.onPlanID == k1.onPlanID && k2.getId() != k1.getId()){
                            //Eslesme oldu

                            if (k1.cevrilebiler && k2.cevrilebiler) {
                                skor = skor + 5;
                                eslesmeSayisi++;
                            }

                            k2.cevrilebiler = false;
                            k1.cevrilebiler = false;




                                tvSkor.setText("Skor: "+skor);

                            if(eslesmeSayisi==8){
                                //Oyun Bitti
                                Intent intent = new Intent(OyunEkraniActivity.this,SkorActivity_Win.class);
                                intent.putExtra("skor",skor);
                                startActivity(intent);
                            }
                        }
                        else{
                            //Eslesmediler kartları geri cevir
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k1.cevir();
                                    k2.cevir();
                                }
                            },900);
                            hata--;
                            if(hata==0){
                                //Oyun Bitti
                                Intent intent = new Intent(OyunEkraniActivity.this,SkorActivity.class);
                                intent.putExtra("skor",skor);
                                startActivity(intent);
                            }


                            TextView tvHata = findViewById(R.id.textViewHata);
                            tvHata.setText("Kalan Hak: "+hata);
                            skor--;
                            tvSkor.setText("Skor: "+skor);


                        }
                        sonKart=-1;
                    }
                    else{
                        sonKart=k1.getId();
                    }
                }
            });
        }

            // Kartlari Karıstır
        for(int j=0;j<16;j++){
            int rdm = (int)(Math.random()*16);
            Kart k = kartlar[rdm];
            kartlar[rdm] = kartlar[j];
            kartlar[j] = k;
        }

            //GiridView ile  ekrana bas
        for(int j=0;j<16;j++){
            gl.addView(kartlar[j]);
        }
    }
}
