package com.singular.renting.service;

import com.singular.renting.domain.Rental;

public class NewReleaseInitialPaymentCalculator implements RentalInitialPaymentCalculator {

    @Override
    public Float getRentalInitialPrice(Rental rental) {

        return rental.getFilm().getPriceType().getValue() * rental.getDays();
    }
}
