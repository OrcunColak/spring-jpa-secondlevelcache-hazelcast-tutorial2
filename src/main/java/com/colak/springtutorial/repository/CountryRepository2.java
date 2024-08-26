package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Country;
import jakarta.persistence.CacheRetrieveMode;
import jakarta.persistence.CacheStoreMode;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.hibernate.jpa.SpecHints;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CountryRepository2 {

    private final EntityManager entityManager;

    public List<Country> findAll() {
        String sql = "SELECT c FROM Country c";
        TypedQuery<Country> typedQuery = entityManager.createQuery(sql, Country.class);

        typedQuery.setHint(SpecHints.HINT_SPEC_CACHE_RETRIEVE_MODE, CacheRetrieveMode.USE);
        typedQuery.setHint(SpecHints.HINT_SPEC_CACHE_STORE_MODE, CacheStoreMode.REFRESH);

        return typedQuery.getResultList();
    }

    public Country findById(long id) {
        String sql = "SELECT c FROM Country c WHERE c.id=:id";
        TypedQuery<Country> typedQuery = entityManager.createQuery(sql, Country.class);

        typedQuery.setParameter("id", id);
        typedQuery.setHint(SpecHints.HINT_SPEC_CACHE_RETRIEVE_MODE, CacheRetrieveMode.USE);
        typedQuery.setHint(SpecHints.HINT_SPEC_CACHE_STORE_MODE, CacheStoreMode.REFRESH);

        return typedQuery.getResultList().getFirst();
    }
}
