package com.ar;

public class Melody {
    private int id;
    private String title;
    private String genre;
    private String duration;
    private String images;

    // Constructor vacío necesario para deserialización de JSON
    public Melody() {}

    // Constructor con parámetros para inicializar todos los atributos
    public Melody(int id, String title, String genre, String duration, String images) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.images = images;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
