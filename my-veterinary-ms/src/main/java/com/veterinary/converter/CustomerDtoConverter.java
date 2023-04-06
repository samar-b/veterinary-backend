package com.veterinary.converter;

import com.veterinary.dto.CustomerDto;
import com.veterinary.dto.PetDto;
import com.veterinary.dto.TreatmentDto;
import com.veterinary.model.Customer;
import com.veterinary.model.Pet;
import com.veterinary.model.Treatment;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;
import java.util.Optional;

@Data(staticConstructor = "newInstance")
public class CustomerDtoConverter implements Converter<CustomerDto, Customer> {
    @Override
    public Customer convert(CustomerDto customerDto) {
        if (Objects.isNull(customerDto)) {
            return null;
        }
        return Customer.builder()
                .id(customerDto.getId())
                .firstname(customerDto.getFirstname())
                .lastname(customerDto.getLastname())
                .idNumber(customerDto.getIdNumber())
                .mail(customerDto.getMail())
                .phoneNumber(customerDto.getPhoneNumber())
                .build();
    }
}
