package com.anhtlnse170476.lab2;

import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setHeaderTitle("Lab 2");

        setupNavigation(null, Lab21Activity.class);
    }
}