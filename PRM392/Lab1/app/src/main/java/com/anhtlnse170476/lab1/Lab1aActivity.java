package com.anhtlnse170476.lab1;

import android.os.Bundle;

public class Lab1aActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1a);
        setHeaderTitle("Lab 1a - Linear Layout");

        setupNavigation(MainActivity.class, Lab1bActivity.class);
    }
}
