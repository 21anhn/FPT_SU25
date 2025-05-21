package com.anhtlnse170476.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class Lab21Activity extends BaseActivity {
    private EditText etMin;
    private EditText etMax;
    private AppCompatButton acpBtnGenerate;
    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_1);
        initViews();
        setHeaderTitle("Lab 2 - Random Number Generator");
        setupNavigation(MainActivity.class, null);
    }

    private void initViews() {
        etMin = findViewById(R.id.etMin);
        etMax = findViewById(R.id.etMax);
        acpBtnGenerate = findViewById(R.id.acBtnGenerate);
        tvResult = findViewById(R.id.tvResult);
    }

    public void onGenerate(View view) {
        if (etMin.getText() == null || etMin.getText().toString().isEmpty()) {
            Toast.makeText(Lab21Activity.this, "Please enter min value!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (etMax.getText() == null || etMax.getText().toString().isEmpty()) {
            Toast.makeText(Lab21Activity.this, "Please enter max value!", Toast.LENGTH_SHORT).show();
            return;
        }

        var min = Integer.parseInt(etMin.getText().toString());
        var max = Integer.parseInt(etMax.getText().toString());


        var result = (int) (Math.random() * (max - min) + min);
        tvResult.setText(String.valueOf(result));
    }
}
