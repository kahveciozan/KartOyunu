package com.example.kartoyunu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatDrawableManager;

public class Kart extends androidx.appcompat.widget.AppCompatButton {
    boolean acikMi=false;
    boolean cevrilebiler = true;
    int arkaPlanID;
    int onPlanID=0;
    Drawable arka;
    Drawable on;


    @SuppressLint("RestrictedApi")
    public Kart(Context context, int id) {
        super(context);
        setId(id);

        arkaPlanID = R.drawable.arka_plan;

        if(id%8 == 0)
            onPlanID = R.drawable.irem8;
        if(id%8 == 1)
            onPlanID = R.drawable.irem1;
        if(id%8 == 2)
            onPlanID = R.drawable.irem2;
        if(id%8 == 3)
            onPlanID = R.drawable.irem3;
        if(id%8 == 4)
            onPlanID = R.drawable.irem4;
        if(id%8 == 5)
            onPlanID = R.drawable.irem5;
        if(id%8 == 6)
            onPlanID = R.drawable.irem6;
        if(id%8 == 7)
            onPlanID = R.drawable.irem7;


        arka= AppCompatDrawableManager.get().getDrawable(context,arkaPlanID);
        on=AppCompatDrawableManager.get().getDrawable(context,onPlanID);
        setBackground(arka);
    }

    public void cevir(){
        if(cevrilebiler) {
            if (!acikMi) {
                setBackground(on);
                acikMi = true;
            } else {
                setBackground(arka);
                acikMi = false;
            }
        }
    }

}
