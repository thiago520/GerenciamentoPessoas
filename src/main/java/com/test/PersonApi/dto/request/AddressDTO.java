package com.test.PersonApi.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;
    @NotEmpty
    private String nameAddress;
    @NotEmpty
    private String zipCode;
    @NotEmpty
    private String number;
    @NotEmpty
    private String city;
    @NotEmpty
    private Boolean mainAddress;
}
