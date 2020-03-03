package com.singular.renting.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.singular.renting.domain.Customer;
import com.singular.renting.domain.Rental;
import com.singular.renting.exception.CustomerNotFoundException;
import com.singular.renting.exception.RentalNotFoundException;
import com.singular.renting.factory.RentalInitialPaymentCalculatorFactory;
import com.singular.renting.repository.CustomerRepository;
import com.singular.renting.repository.RentalRepository;
import com.singular.renting.resource.RentalAssembler;
import com.singular.renting.service.RentalBonusPointsCalculator;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalController {

    private final RentalRepository repository;
    private final CustomerRepository customerRepository;
    private final RentalAssembler assembler;
    private final RentalBonusPointsCalculator bonusPointsCalculator;
    private final RentalInitialPaymentCalculatorFactory rentalInitialPaymentCalculatorFactory;

    RentalController(
            RentalRepository repository,
            RentalAssembler assembler,
            CustomerRepository customerRepository,
            RentalBonusPointsCalculator bonusPointsCalculator,
            RentalInitialPaymentCalculatorFactory rentalInitialPaymentCalculatorFactory
    ) {
        this.repository = repository;
        this.assembler = assembler;
        this.customerRepository = customerRepository;
        this.bonusPointsCalculator = bonusPointsCalculator;
        this.rentalInitialPaymentCalculatorFactory = rentalInitialPaymentCalculatorFactory;
    }

    @GetMapping("/Rental")
    public EntityModel<Rental> one(Long id) {
        Rental rental = repository.findById(id)
                .orElseThrow(() -> new RentalNotFoundException(id));
        return assembler.toModel(rental);
    }

    @PostMapping("/Rental")
    public ResponseEntity<EntityModel<Rental>> newRental (@RequestBody Rental rental) {
        // rental.setPrice(rentalInitialPaymentCalculatorFactory.getInitialPaymentCalculator(rental).getRentalInitialPrice(rental));
        Rental newRental = repository.save(rental);
        Customer customer = customerRepository.findById(rental.getCustomer().getId())
                .orElseThrow(() -> new CustomerNotFoundException(rental.getCustomer().getId()));
        customer.setBonusPoints(customer.getBonusPoints() + this.bonusPointsCalculator.getRentalBonusPoints(rental));
        customerRepository.save(customer);
        return ResponseEntity
                .created(linkTo(methodOn(RentalController.class).one(newRental.getId())).toUri())
                .body(assembler.toModel(rental));
    }
}
