package com.anhtlnse170476.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class Lab231Activity extends BaseActivity {
    private EditText etUsername, etPassword;
    private TextView tvRegister;
    private AppCompatButton btnSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lab2_31);
        setHeaderTitle("Lab 2 - Sign In Form");
        setupNavigation(Lab22Activity.class, null);

        initViews();

        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(Lab231Activity.this, Lab232Activity.class);
            startActivity(intent);
        });

        btnSignIn.setOnClickListener(v -> {
            if (validateSignIn()) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvRegister = findViewById(R.id.tvRegister);
        btnSignIn = findViewById(R.id.btnSignIn);
    }

    private boolean validateSignIn() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString();

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
        return true;
    }
}
