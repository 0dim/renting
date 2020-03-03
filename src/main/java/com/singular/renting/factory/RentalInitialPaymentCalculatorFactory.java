package com.singular.renting.factory;

import com.singular.renting.domain.FilmType;
import com.singular.renting.domain.Rental;
import com.singular.renting.service.NewReleaseInitialPaymentCalculator;
import com.singular.renting.service.OldInitialPaymentCalculator;
import com.singular.renting.service.RegularInitialPaymentCalculator;
import com.singular.renting.service.RentalInitialPaymentCalculator;
import org.springframework.stereotype.Component;

@Component
public class RentalInitialPaymentCalculatorFactory {

    public RentalInitialPaymentCalculator getInitialPaymentCalculator(Rental rental) {
        RentalInitialPaymentCalculator calculator = null;

        switch (rental.getFilm().getFilmType()){
            case NEW_RELEASE:
                calculator = new NewReleaseInitialPaymentCalculator();
                break;
            case REGULAR:
                calculator = new RegularInitialPaymentCalculator();
                break;
            case OLD:
                calculator = new OldInitialPaymentCalculator();
                break;
        }

        return calculator;
    }
}
