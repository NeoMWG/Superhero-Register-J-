package com.example.registrodesuperheroesj;

public class SuperHero {
    private String name;
    private String alterEgo;
    private String description;
    private float rating;

    public SuperHero(String name, String alterEgo, String description, float rating) {
        this.name = name;
        this.alterEgo = alterEgo;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}