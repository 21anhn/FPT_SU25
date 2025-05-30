package com.anhtlnse170476.lab2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class Lab232Activity extends BaseActivity {
    private EditText etUsername, etPassword, etConfirmPassword;
    private TextView tvAlreadyAccount;
    private AppCompatButton btnSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lab2_32);
        setHeaderTitle("Lab 2 - Sign Up Form");
        setupNavigation(Lab22Activity.class, null);

        initViews();

        tvAlreadyAccount.setOnClickListener(v -> {
            finish();
        });

        btnSignUp.setOnClickListener(v -> {
            if (validateSignUp()) {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void initViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        tvAlreadyAccount = findViewById(R.id.tvAlreadyAccount);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private boolean validateSignUp() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();

        if (username.isEmpty()) {
            etUsername.setError("Username không được để trống");
            etUsername.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password không được để trống");
            etPassword.requestFocus();
            return false;
        }
        if (confirmPassword.isEmpty()) {
            etConfirmPassword.setError("Confirm Password không được để trống");
            etConfirmPassword.requestFocus();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Confirm Password phải giống Password");
            etConfirmPassword.requestFocus();
            return false;
        }
        return true;
    }
}
