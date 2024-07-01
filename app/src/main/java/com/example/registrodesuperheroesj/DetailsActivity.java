package com.example.registrodesuperheroesj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.registrodesuperheroesj.databinding.ActivityDetailsBinding;
import com.example.registrodesuperheroesj.databinding.ActivityMainBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        String superHeroName = extras.getString("superHeroName");
        String superHeroAlterEgo = extras.getString("superHeroAlterEgo");
        String superHeroDescription = extras.getString("superHeroDescription");
        float superHeroRating = extras.getFloat("superHeroRating");
        binding.tvSuperheroNamedDa.setText(superHeroName);
        binding.tvSuperheroAlteregoDa.setText(superHeroAlterEgo);
        binding.tvBiographyDescriptionDa.setText(superHeroDescription);
        binding.rbRatingbarDa.setRating(superHeroRating);

        binding.btnCloseLayoutDa.setOnClickListener(v -> {
            finish();
        });
    }
}