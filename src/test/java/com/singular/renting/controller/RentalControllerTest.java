package com.singular.renting.controller;

import com.singular.renting.domain.Rental;
import com.singular.renting.factory.RentalInitialPaymentCalculatorFactory;
import com.singular.renting.repository.CustomerRepository;
import com.singular.renting.repository.RentalRepository;
import com.singular.renting.resource.RentalAssembler;
import com.singular.renting.service.RentalBonusPointsCalculator;
import com.singular.renting.service.RentalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RentalControllerTest {

    @Mock
    private RentalService rentalService;
    private RentalAssembler assembler;

    RentalController controller = new RentalController(
            assembler,
            rentalService
    );

    @Test
    public void isReturningANewRental() {
        Rental rental = new Rental();
        ResponseEntity<EntityModel<Rental>> rentalEntity = controller.newRental(rental);
        verify(rentalService).rent(rental);
        // asser<< reponse
    }

}
