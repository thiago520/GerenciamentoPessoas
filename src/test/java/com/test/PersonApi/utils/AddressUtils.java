package com.test.PersonApi.utils;

import com.test.PersonApi.dto.request.AddressDTO;
import com.test.PersonApi.entities.Address;

public class AddressUtils {

    private static final String NAME_ADDRESS = "Avenida Paraná";
    private static final String ZIP_CODE = "87510000";
    private static final String NUMBER = "1755";
    private static final String CITY = "Curitiba";
    private static final Boolean MAIN_ADDRESS = true;
    private static final long ADDRESS_ID = 1L;

    public static AddressDTO createFakeDTO() {
        return AddressDTO.builder()
                .nameAddress(NAME_ADDRESS)
                .zipCode(ZIP_CODE)
                .number(NUMBER)
                .city(CITY)
                .mainAddress(MAIN_ADDRESS)
                .build();
    }

    public static Address createFakeEntity() {
        return Address.builder()
                .id(ADDRESS_ID)
                .nameAddress(NAME_ADDRESS)
                .zipCode(ZIP_CODE)
                .number(NUMBER)
                .city(CITY)
                .mainAddress(MAIN_ADDRESS)
                .build();
    }


}
