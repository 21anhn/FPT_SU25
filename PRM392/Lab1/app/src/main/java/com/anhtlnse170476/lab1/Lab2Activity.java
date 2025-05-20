package com.anhtlnse170476.lab1;

import android.os.Bundle;

public class Lab2Activity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        setHeaderTitle("Lab 2 - Relative Layout");

        setupNavigation(Lab1bActivity.class, Lab3Activity.class);
    }
}
