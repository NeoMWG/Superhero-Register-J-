package com.example.registrodesuperheroesj;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.registrodesuperheroesj.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.buttonStorage.setOnClickListener(v -> {
            openDetailActivity();
        });
    }

    private void openDetailActivity() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

}
