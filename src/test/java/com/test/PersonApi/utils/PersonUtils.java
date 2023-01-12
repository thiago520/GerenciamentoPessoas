package com.test.PersonApi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.test.PersonApi.dto.request.PersonDTO;
import com.test.PersonApi.entities.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String NAME = "Thiago";
    private static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);
    private static final long PERSON_ID = 1l;

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .name(NAME)
                .birthDate("02-04-2010")
                .addresses(Collections.singletonList(AddressUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .name(NAME)
                .birthDate(BIRTH_DATE)
                .addresses(Collections.singletonList(AddressUtils.createFakeEntity()))
                .build();
    }

    public static String asJsonString(PersonDTO personDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(personDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
