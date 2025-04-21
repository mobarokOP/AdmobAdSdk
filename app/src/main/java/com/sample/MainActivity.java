package com.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android_admob.CustomToast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void SHORT_TOAST(View view) {
        CustomToast.showShortToast(this, "SHORT TOAST");
    }

    public void LONG_TOAST(View view) {
        CustomToast.showLongToast(this, "LONG TOAST");
    }
}

