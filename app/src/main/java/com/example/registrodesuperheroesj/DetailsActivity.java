package com.example.registrodesuperheroesj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.registrodesuperheroesj.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    public static final String SUPER_HERO_NAME = "superHeroName";
    public static final String SUPER_HERO_ALTER_EGO = "superHeroAlterEgo";
    public static final String SUPER_HERO_DESCRIPTION = "superHeroDescription";
    public static final String SUPER_HERO_RATING = "superHeroRating";

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        initializeViews();
        setCloseButtonListener();
    }

    private void initializeViews() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String superHeroName = extras.getString(SUPER_HERO_NAME, "");
            String superHeroAlterEgo = extras.getString(SUPER_HERO_ALTER_EGO, "");
            String superHeroDescription = extras.getString(SUPER_HERO_DESCRIPTION, "");
            float superHeroRating = extras.getFloat(SUPER_HERO_RATING, 0f);

            setSuperheroDetails(superHeroName, superHeroAlterEgo, superHeroDescription, superHeroRating);
        }
    }

    private void setSuperheroDetails(String name, String alterEgo, String description, float rating) {
        binding.tvSuperheroNamedDa.setText(name);
        binding.tvSuperheroAlteregoDa.setText(alterEgo);
        binding.tvBiographyDescriptionDa.setText(description);
        binding.rbRatingbarDa.setRating(rating);
    }

    private void setCloseButtonListener() {
        binding.btnCloseLayoutDa.setOnClickListener(v -> finish());
    }
}
