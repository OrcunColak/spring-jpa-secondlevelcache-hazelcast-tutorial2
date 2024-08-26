package com.colak.springtutorial.jpa;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Table(name = "countries")
@Entity
@Cacheable
// This will create an IMap having name "country"
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "country")

@Getter
@Setter
public class Country {

    @Id
    private Long id;

    @Convert(converter = MyConvertor.class)
    private String name;
}
