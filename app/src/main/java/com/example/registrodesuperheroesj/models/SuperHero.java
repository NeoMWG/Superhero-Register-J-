package com.example.registrodesuperheroesj.models;

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

    public String getName() { return name; }
    public String getAlterEgo() { return alterEgo; }
    public String getDescription() { return description; }
    public float getRating() { return rating; }
}
