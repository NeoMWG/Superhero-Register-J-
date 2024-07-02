package com.example.registrodesuperheroesj;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.registrodesuperheroesj.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final int PHOTO_REQUEST_CODE = 1000;
    private ActivityMainBinding binding;
    private SuperHero superHero;
    private Bitmap takenPhotoBitmap;

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
        binding.ivLogoSuperheroMa.setOnClickListener(this::onLogoSuperheroClick);
    }

    private void onStorageButtonClick(View view) {
        navigateToDetailsActivity();
    }

    private void onClearButtonClick(View view) {
        clearFields();
    }

    private void onLogoSuperheroClick(View view) {
        openCamera();
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, PHOTO_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PHOTO_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                takenPhotoBitmap = data.getExtras().getParcelable("data");
                binding.ivLogoSuperheroMa.setImageBitmap(takenPhotoBitmap);
            } else {
                Toast.makeText(this, "Error taking photo", Toast.LENGTH_SHORT).show();
            }
        }

        binding.ivLogoSuperheroMa.setImageURI(data.getData());
    }

    private void navigateToDetailsActivity() {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(Constants.SUPER_HERO_NAME, superHero.getName());
        intent.putExtra(Constants.SUPER_HERO_ALTER_EGO, superHero.getAlterEgo());
        intent.putExtra(Constants.SUPER_HERO_DESCRIPTION, superHero.getDescription());
        intent.putExtra(Constants.SUPER_HERO_RATING, superHero.getRating());
        intent.putExtra(Constants.BITMAP_KEY, takenPhotoBitmap);
        startActivity(intent);
    }

    private void clearFields() {
        superHero.setName("");
        superHero.setAlterEgo("");
        superHero.setDescription("");
        superHero.setRating(0);
        takenPhotoBitmap = null;
        binding.invalidateAll();
    }


}
