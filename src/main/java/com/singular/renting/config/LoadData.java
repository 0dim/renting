package com.singular.renting.config;

import com.singular.renting.domain.Customer;
import com.singular.renting.domain.Film;
import com.singular.renting.domain.FilmType;
import com.singular.renting.domain.PriceType;
import com.singular.renting.repository.CustomerRepository;
import com.singular.renting.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData {

    CustomerRepository customerRepository;
    FilmRepository filmRepository;

    public LoadData(CustomerRepository customerRepository, FilmRepository filmRepository) {
        this.customerRepository = customerRepository;
        this.filmRepository = filmRepository;
    }

    @Bean
    CommandLineRunner loadInitialData() {
        return args -> {
            Film film = new Film();
            film.setPriceType(PriceType.PREMIUM);
            film.setFilmType(FilmType.NEW_RELEASE);
            film.setQuantity(10);
            filmRepository.save(film);
            Customer customer = new Customer();
            customer.setBonusPoints(20);
            customerRepository.save(customer);
        };
    }
}