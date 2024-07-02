package com.example.registrodesuperheroesj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.registrodesuperheroesj.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        initialize();
    }

    private void initialize() {
        SuperHero superHero = extractSuperHeroFromIntent();
        bindSuperHeroToView(superHero);
        setupListeners();
    }

    private SuperHero extractSuperHeroFromIntent() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String superHeroName = extras.getString(Constants.SUPER_HERO_NAME);
            String superHeroAlterEgo = extras.getString(Constants.SUPER_HERO_ALTER_EGO);
            String superHeroDescription = extras.getString(Constants.SUPER_HERO_DESCRIPTION);
            float superHeroRating = extras.getFloat(Constants.SUPER_HERO_RATING);
            return new SuperHero(superHeroName, superHeroAlterEgo, superHeroDescription, superHeroRating);
        }
        return new SuperHero("", "", "", 0);
    }

    private void bindSuperHeroToView(SuperHero superHero) {
        binding.setSuperHero(superHero);
    }

    private void setupListeners() {
        binding.btnCloseLayoutDa.setOnClickListener(v -> finish());
    }
}
