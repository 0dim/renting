package com.singular.renting.service;

import com.singular.renting.domain.Rental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewReleaseInitialPaymentCalculatorTest {

    NewReleaseInitialPaymentCalculator calculator = new NewReleaseInitialPaymentCalculator();

    // it should return 3 if I rent for 1 day a premium new release movie
    @Test
    public void itShouldReturn3WhenRentingFor1DayAPremiumNewRelease() {
        Rental newRental = new Rental();

        Float price = calculator.getRentalInitialPrice(newRental);
        assertEquals(3.0f, price);
    }
}
