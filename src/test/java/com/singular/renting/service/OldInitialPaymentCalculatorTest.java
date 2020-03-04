package com.singular.renting.service;

import com.singular.renting.domain.Film;
import com.singular.renting.domain.PriceType;
import com.singular.renting.domain.Rental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OldInitialPaymentCalculatorTest {

    OldInitialPaymentCalculator calculator = new OldInitialPaymentCalculator();
    Rental newRental = new Rental();
    Film film = new Film();

    // it should return 3 if I rent for 5 days a premium old movie
    @Test
    public void itShouldReturn3WhenRentingFor5DayAPremiumOld() {
        film.setPriceType(PriceType.PREMIUM);
        newRental.setDays(5);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(3.0f, price);
    }

    // it should return 3 if I rent for 3 days a premium old movie
    @Test
    public void itShouldReturn3WhenRentingFor3DayAPremiumOld() {
        film.setPriceType(PriceType.PREMIUM);
        newRental.setDays(3);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(3.0f, price);
    }

    @Test
    public void itShouldReturn9WhenRentingFor7DayAPremiumOld() {
        film.setPriceType(PriceType.PREMIUM);
        newRental.setDays(7);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(9.0f, price);
    }

    @Test
    public void itShouldReturn1WhenRentingFor5DayABasicOld() {
        film.setPriceType(PriceType.BASIC);
        newRental.setDays(5);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(1.0f, price);
    }

    @Test
    public void itShouldReturn1WhenRentingFor3DayABasicOld() {
        film.setPriceType(PriceType.BASIC);
        newRental.setDays(3);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(1.0f, price);
    }

    @Test
    public void itShouldReturn3WhenRentingFor7DayAPremiumOld() {
        film.setPriceType(PriceType.BASIC);
        newRental.setDays(7);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(3.0f, price);
    }
}
