package com.anhtlnse170476.lab1;

import android.os.Bundle;

public class Lab3Activity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        setHeaderTitle("Lab 3 - Constraint Layout");

        setupNavigation(Lab2Activity.class, null);

    }
}
