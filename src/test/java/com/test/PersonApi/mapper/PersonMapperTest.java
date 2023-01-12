package com.test.PersonApi.mapper;

import com.test.PersonApi.dto.mapper.PersonMapper;
import com.test.PersonApi.dto.request.AddressDTO;
import com.test.PersonApi.dto.request.PersonDTO;
import com.test.PersonApi.entities.Address;
import com.test.PersonApi.entities.Person;
import com.test.PersonApi.repositories.PersonRepository;
import com.test.PersonApi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private PersonRepository personRepository;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person person = personMapper.toModel(personDTO);

        assertEquals(personDTO.getName(), person.getName());
        assertEquals(personDTO.getBirthDate(), person.getBirthDate());

        Address address = person.getAddresses().get(0);
        AddressDTO addressDTO = personDTO.getAddresses().get(0);

        assertEquals(addressDTO.getCity(), addressDTO.getCity());
        assertEquals(addressDTO.getNumber(), addressDTO.getNumber());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Person person = PersonUtils.createFakeEntity();
        PersonDTO personDTO = personMapper.toDTO(person);

        assertEquals(person.getName(), personDTO.getName());
        assertEquals(person.getBirthDate(), personDTO.getBirthDate());

        Address address = person.getAddresses().get(0);
        AddressDTO addressDTO = personDTO.getAddresses().get(0);

        assertEquals(address.getCity(), addressDTO.getCity());
        assertEquals(address.getNumber(), addressDTO.getNumber());
    }
}
