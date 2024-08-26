package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CountryRepository2Test {

    @Autowired
    private CountryRepository2 repository;

    @Test
    void findById() {

        // This stored entries in cache
        List<Country> list = repository.findAll();
        assertThat(list).isNotEmpty();

        // This still executes SQL, the data is NOT fetched from cache. Why ?
        Country byId = repository.findById(1L);
        assertThat(byId.getId()).isEqualTo(1L);

    }
}
