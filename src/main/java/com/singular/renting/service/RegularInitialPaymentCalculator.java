package com.singular.renting.service;

import com.singular.renting.domain.Rental;

public class RegularInitialPaymentCalculator implements RentalInitialPaymentCalculator{

    private final Float PRICE = 1f;
    private final int RENTAL_DAYS_DURATION = 3;


    @Override
    public Float getRentalInitialPrice(Rental rental) {
        Float price = PRICE;
        price += rental.getDays() > RENTAL_DAYS_DURATION ? rental.getDays() - RENTAL_DAYS_DURATION * PRICE : 0;
        return price;
    }
}
