package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CountryRepositoryTest {

    @Autowired
    private CountryRepository repository;

    @Test
    void findAll() {
        // This stored entries in cache
        List<Country> all = repository.findAll();
        assertThat(all).isNotEmpty();

        // This does not execute an SQL, the data is fetched from cache
        Optional<Country> byId = repository.findById(1L);
        assertThat(byId)
                .isPresent();

        assertThat(byId.get().getId()).isEqualTo(1L);

    }
}
