package com.test.PersonApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameAddress;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String city;

    private Boolean mainAddress;

}
