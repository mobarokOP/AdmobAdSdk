package com.sample;

import android.os.Bundle;
import android.view.View;

import com.android_admob.AdNetwork;
import com.android_admob.InitializeAdmob;
import com.android_admob.Test;


public class MainActivity extends InitializeAdmob {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdNetwork.loadBannerAd(this, R.id.adLayout);

        new Test(this);

    }


    public void SHOWADS(View view) {
        AdNetwork.showAd(this);
    }
}

