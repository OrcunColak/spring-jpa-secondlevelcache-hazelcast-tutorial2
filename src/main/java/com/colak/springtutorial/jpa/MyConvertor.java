package com.colak.springtutorial.jpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.Serializable;

@Converter
public class MyConvertor implements AttributeConverter<String, String>, Serializable {

    private static final String PREFIX = "name : ";

    public MyConvertor() {
        super();
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        String result = attribute;
        if (result == null) {
            return result;
        }
        if (attribute.startsWith(PREFIX)) {
            result = attribute.substring(PREFIX.length());
        }
        return result;
    }

    @Override
    public String convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return PREFIX + code;
    }
}
