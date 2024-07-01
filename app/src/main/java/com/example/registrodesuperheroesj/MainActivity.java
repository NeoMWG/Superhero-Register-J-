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
            String superHeroName = binding.etNameMa.getText().toString();
            String superHeroAlterEgo = binding.etAlterEgoMa.getText().toString();
            String superHeroDescription = binding.etDescriptionMa.getText().toString();
            float superHeroRating = binding.ratingBarMa.getRating();
            openDetailActivity(superHeroName, superHeroAlterEgo, superHeroDescription,superHeroRating);
        });

        binding.buttonClear.setOnClickListener(v -> {
            clearFields();
        });
    }

    private void openDetailActivity(String superHeroName, String superHeroAlterEgo, String superHeroDescription, float superHeroRating) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("superHeroName", superHeroName);
        intent.putExtra("superHeroAlterEgo", superHeroAlterEgo);
        intent.putExtra("superHeroDescription", superHeroDescription);
        intent.putExtra("superHeroRating", superHeroRating);
        startActivity(intent);
    }

    private void clearFields() {
        binding.etNameMa.setText("");
        binding.etAlterEgoMa.setText("");
        binding.etDescriptionMa.setText("");
        binding.ratingBarMa.setRating(0);
    }

}
