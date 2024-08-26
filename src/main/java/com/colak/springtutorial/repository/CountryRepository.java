package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
