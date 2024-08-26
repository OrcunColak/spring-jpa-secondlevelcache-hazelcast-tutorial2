package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CountryRepository2Test {

    @Autowired
    private CountryRepository2 repository;

    @Test
    void findById() {
        // The data is stored in the cache
        Country byId = repository.findById(1L);
        assertThat(byId.getId()).isEqualTo(1L);

    }
}
