package com.example.registrodesuperheroesj;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.registrodesuperheroesj.databinding.ActivityMainBinding;
import com.example.registrodesuperheroesj.models.SuperHero;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupButtonListeners();
    }

    private void setupButtonListeners() {
        binding.buttonStorage.setOnClickListener(v -> handleStorageButtonClick());
        binding.buttonClear.setOnClickListener(v -> clearFields());
    }

    private void handleStorageButtonClick() {
        SuperHero superHero = getSuperHeroFromInputs();
        openDetailActivity(superHero);
    }

    private SuperHero getSuperHeroFromInputs() {
        String name = binding.etNameMa.getText().toString();
        String alterEgo = binding.etAlterEgoMa.getText().toString();
        String description = binding.etDescriptionMa.getText().toString();
        float rating = binding.ratingBarMa.getRating();

        return new SuperHero(name, alterEgo, description, rating);
    }

    private void openDetailActivity(SuperHero superHero) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.SUPER_HERO_NAME, superHero.getName());
        intent.putExtra(DetailsActivity.SUPER_HERO_ALTER_EGO, superHero.getAlterEgo());
        intent.putExtra(DetailsActivity.SUPER_HERO_DESCRIPTION, superHero.getDescription());
        intent.putExtra(DetailsActivity.SUPER_HERO_RATING, superHero.getRating());
        startActivity(intent);
    }

    private void clearFields() {
        binding.etNameMa.setText("");
        binding.etAlterEgoMa.setText("");
        binding.etDescriptionMa.setText("");
        binding.ratingBarMa.setRating(0);
    }
}