package com.singular.renting.service;

import com.singular.renting.domain.Film;
import com.singular.renting.domain.PriceType;
import com.singular.renting.domain.Rental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularInitialPaymentCalculatorTest {

    RegularInitialPaymentCalculator calculator = new RegularInitialPaymentCalculator();
    Film film = new Film();
    Rental newRental = new Rental();

    @Test
    public void itShouldReturn3WhenRentingFor3DaysAPremiumRegularFilm() {
        film.setPriceType(PriceType.PREMIUM);
        newRental.setDays(3);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(3.0f, price);
    }

    @Test
    public void itShouldReturn3WhenRentingFor2DaysAPremiumRegularFilm() {
        film.setPriceType(PriceType.PREMIUM);
        newRental.setDays(2);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(3.0f, price);
    }

    @Test
    public void itShouldReturn12WhenRentingFor6DaysAPremiumRegularFilm() {
        film.setPriceType(PriceType.PREMIUM);
        newRental.setDays(6);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(12.0f, price);
    }

    @Test
    public void itShouldReturn1WhenRentingFor3DaysABasicRegularFilm() {
        film.setPriceType(PriceType.BASIC);
        newRental.setDays(3);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(1.0f, price);
    }

    @Test
    public void itShouldReturn3WhenRentingFor1DayABasicRegularFilm() {
        film.setPriceType(PriceType.BASIC);
        newRental.setDays(1);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(1.0f, price);
    }

    @Test
    public void itShouldReturn8WhenRentingFor10DaysABasicRegularFilm() {
        film.setPriceType(PriceType.BASIC);
        newRental.setDays(10);
        newRental.setFilm(film);
        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(8.0f, price);
    }
}
