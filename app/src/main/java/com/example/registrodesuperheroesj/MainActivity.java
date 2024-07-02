package com.example.registrodesuperheroesj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.registrodesuperheroesj.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SuperHero superHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initialize();
        setupListeners();
    }

    private void initialize() {
        initSuperHero();
        bindSuperHeroToView();
    }

    private void initSuperHero() {
        superHero = new SuperHero("", "", "", 0);
    }

    private void bindSuperHeroToView() {
        binding.setSuperHero(superHero);
    }

    private void setupListeners() {
        binding.buttonStorage.setOnClickListener(this::onStorageButtonClick);
        binding.buttonClear.setOnClickListener(this::onClearButtonClick);
    }

    private void onStorageButtonClick(View view) {
        navigateToDetailsActivity();
    }

    private void onClearButtonClick(View view) {
        clearFields();
    }

    private void navigateToDetailsActivity() {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(Constants.SUPER_HERO_NAME, superHero.getName());
        intent.putExtra(Constants.SUPER_HERO_ALTER_EGO, superHero.getAlterEgo());
        intent.putExtra(Constants.SUPER_HERO_DESCRIPTION, superHero.getDescription());
        intent.putExtra(Constants.SUPER_HERO_RATING, superHero.getRating());
        startActivity(intent);
    }

    private void clearFields() {
        superHero.setName("");
        superHero.setAlterEgo("");
        superHero.setDescription("");
        superHero.setRating(0);
        binding.invalidateAll();
    }
}
