package com.singular.renting.service;

import com.singular.renting.domain.Rental;

public interface RentalInitialPaymentCalculator {

    public Float getRentalInitialPrice(Rental rental);
}
