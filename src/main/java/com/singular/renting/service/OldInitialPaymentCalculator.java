package com.singular.renting.service;

import com.singular.renting.domain.Rental;

public class OldInitialPaymentCalculator implements RentalInitialPaymentCalculator {

    private final int RENTAL_DAYS_DURATION = 5;

    @Override
    public Float getRentalInitialPrice(Rental rental) {
        Float price = rental.getFilm().getPriceType().getValue();
        price += rental.getDays() > RENTAL_DAYS_DURATION ? (rental.getDays() - RENTAL_DAYS_DURATION) * price : 0;

        return price;
    }

}
