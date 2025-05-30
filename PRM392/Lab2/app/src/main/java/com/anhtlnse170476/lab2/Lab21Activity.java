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
        setupNavigation(MainActivity.class, Lab22Activity.class);
    }

    private void initViews() {
        etMin = findViewById(R.id.etMin);
        etMax = findViewById(R.id.etMax);
        acpBtnGenerate = findViewById(R.id.acBtnGenerate);
        tvResult = findViewById(R.id.tvResult);
    }

    public void onGenerate(View view) {
        String minStr = etMin.getText() != null ? etMin.getText().toString() : "";
        String maxStr = etMax.getText() != null ? etMax.getText().toString() : "";

        if (minStr.isEmpty()) {
            Toast.makeText(this, "Please enter min value!", Toast.LENGTH_SHORT).show();
            etMin.requestFocus();
            return;
        }

        if (maxStr.isEmpty()) {
            Toast.makeText(this, "Please enter max value!", Toast.LENGTH_SHORT).show();
            etMax.requestFocus();
            return;
        }

        int min, max;

        try {
            min = Integer.parseInt(minStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Min value must be a valid integer!", Toast.LENGTH_SHORT).show();
            etMin.requestFocus();
            return;
        }

        try {
            max = Integer.parseInt(maxStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Max value must be a valid integer!", Toast.LENGTH_SHORT).show();
            etMax.requestFocus();
            return;
        }

        if (min > max) {
            Toast.makeText(this, "Min value must be less than or equal to Max value!", Toast.LENGTH_SHORT).show();
            etMin.requestFocus();
            return;
        }

        int result = (int) (Math.random() * (max - min + 1) + min);
        tvResult.setText(String.valueOf(result));
    }
}
