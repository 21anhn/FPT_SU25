package com.anhtlnse170476.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private TextView tvHeaderTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);

        tvHeaderTitle = findViewById(R.id.tvHeaderTitle);
    }

    @Override
    public void setContentView(int layoutResID) {
        var contentContainer = (FrameLayout) findViewById(R.id.content_container);
        getLayoutInflater().inflate(layoutResID, contentContainer, true);
    }

    public void setHeaderTitle(String title) {
        if (tvHeaderTitle != null) {
            tvHeaderTitle.setText(title);
        }
    }

    public void setupNavigation(@Nullable Class<?> prevActivity, @Nullable Class<?> nextActivity) {
        var btnPrev = findViewById(R.id.btnPrev);
        var btnNext = findViewById(R.id.btnNext);

        btnPrev.setVisibility(prevActivity == null ? View.GONE : View.VISIBLE);
        btnNext.setVisibility(nextActivity == null ? View.GONE : View.VISIBLE);

        btnPrev.setOnClickListener(v -> {
            if (prevActivity != null) {
                startActivity(new Intent(this, prevActivity));
                finish();
            }
        });

        btnNext.setOnClickListener(v -> {
            if (nextActivity != null) {
                startActivity(new Intent(this, nextActivity));
                finish();
            }
        });
    }
}
