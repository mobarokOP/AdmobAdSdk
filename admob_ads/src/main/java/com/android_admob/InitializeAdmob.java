package com.android_admob;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class InitializeAdmob extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        AdNetwork.setForChild(false);
        AdNetwork.loadInterstitial(this);

        Application application = getApplication();
        ((MyApplication) application).loadAd(this);
    }
}
