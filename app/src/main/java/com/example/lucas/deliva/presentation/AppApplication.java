package com.example.lucas.deliva.presentation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class AppApplication extends AppCompatActivity {

    private static final String TAG = AppApplication.class.getSimpleName();

    private static WeakReference<Context> sContext = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hold application context reference
        Context context = getApplicationContext();
        sContext = new WeakReference<>(context);
    }

    public static Context getContext() {
        return sContext.get();
    }

}
