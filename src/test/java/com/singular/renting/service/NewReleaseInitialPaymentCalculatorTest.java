package com.singular.renting.service;

import com.singular.renting.domain.Film;
import com.singular.renting.domain.PriceType;
import com.singular.renting.domain.Rental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewReleaseInitialPaymentCalculatorTest {

    NewReleaseInitialPaymentCalculator calculator = new NewReleaseInitialPaymentCalculator();
    Rental newRental = new Rental();
    Film film = new Film();

    // it should return 3 if I rent for 1 day a premium new release movie
    @Test
    public void itShouldReturn3WhenRentingFor1DayAPremiumNewRelease() {
        film.setPriceType(PriceType.PREMIUM);
        newRental.setDays(1);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(3.0f, price);
    }

    // it should return 6 if I rent for 2 day a premium new release movie
    @Test
    public void itShouldReturn6WhenRentingFor2DayAPremiumNewRelease() {
        film.setPriceType(PriceType.PREMIUM);
        newRental.setDays(2);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(6.0f, price);
    }

    // it should return 4 if I rent for 4 day a basic new release movie
    @Test
    public void itShouldReturn4WhenRentingFor4DayABasicNewRelease() {
        film.setPriceType(PriceType.BASIC);
        newRental.setDays(4);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(4.0f, price);
    }

    // it should return 7 if I rent for 7 day a basic new release movie
    @Test
    public void itShouldReturn7WhenRentingFor7DayABasicNewRelease() {
        film.setPriceType(PriceType.BASIC);
        newRental.setDays(7);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(7.0f, price);
    }
}
