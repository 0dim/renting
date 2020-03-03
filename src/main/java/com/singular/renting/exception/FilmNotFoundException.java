package com.singular.renting.exception;

public class FilmNotFoundException extends RuntimeException {

    public FilmNotFoundException (Long id) {
        super("Couldb't find film " + id);
    }
}
