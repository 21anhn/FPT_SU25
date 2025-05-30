package com.anhtlnse170476.lab2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class Lab22Activity extends BaseActivity {
    private EditText etNum1;
    private EditText etNum2;
    private AppCompatButton btnAdd;
    private AppCompatButton btnSub;
    private AppCompatButton btnMul;
    private AppCompatButton btnDiv;
    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lab2_2);

        setHeaderTitle("Lab 2 - Calculator");
        setupNavigation(Lab21Activity.class, Lab231Activity.class);

        initViews();

        btnAdd.setOnClickListener(v -> performOperation("+"));
        btnSub.setOnClickListener(v -> performOperation("-"));
        btnMul.setOnClickListener(v -> performOperation("*"));
        btnDiv.setOnClickListener(v -> performOperation("/"));
    }

    private void initViews() {
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);
    }

    private void performOperation(String operator) {
        try {
            double num1 = Double.parseDouble(etNum1.getText().toString());
            double num2 = Double.parseDouble(etNum2.getText().toString());
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        tvResult.setText("Không thể chia cho 0");
                        return;
                    }
                    break;
            }

            tvResult.setText(String.format("Kết quả: %.2f", result));

        } catch (NumberFormatException e) {
            tvResult.setText("Vui lòng nhập đúng định dạng số");
        }
    }
}
