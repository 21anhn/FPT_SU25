package com.anhtlnse170476.lab1;

import android.os.Bundle;

public class Lab1bActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1b);
        setHeaderTitle("Lab 1b - Linear Layout");

        setupNavigation(Lab1aActivity.class, null);
    }
}
