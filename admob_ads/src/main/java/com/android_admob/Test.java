package com.android_admob;


import android.content.Context;
import android.widget.Toast;

public class Test {
    Context context;
    public Test(Context context){
        this.context = context;
        Toast.makeText(context, context.getString(R.string.TOAST), Toast.LENGTH_SHORT).show();
    }
}
