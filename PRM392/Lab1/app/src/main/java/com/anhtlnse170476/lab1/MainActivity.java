package com.anhtlnse170476.lab1;

import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setHeaderTitle("Lab 1");

        setupNavigation(null, Lab1aActivity.class);
    }
}