package com.test.PersonApi.services;

import com.test.PersonApi.dto.mapper.PersonMapper;
import com.test.PersonApi.dto.request.PersonDTO;
import com.test.PersonApi.dto.response.MessageResponseDTO;
import com.test.PersonApi.entities.Person;
import com.test.PersonApi.exception.PersonNotFoundException;
import com.test.PersonApi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public MessageResponseDTO create(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPerson.getId());
        return messageResponse;
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());
        return messageResponse;
    }

    public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        personRepository.deleteById(id);
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    private MessageResponseDTO createMessageResponse(String message, Long id) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }

}
