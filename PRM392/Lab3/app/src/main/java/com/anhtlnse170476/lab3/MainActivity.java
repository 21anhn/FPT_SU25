package com.anhtlnse170476.lab3;

import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setHeaderTitle("Lab 3");

        setupNavigation(null, Lab31Activity.class);
    }
}