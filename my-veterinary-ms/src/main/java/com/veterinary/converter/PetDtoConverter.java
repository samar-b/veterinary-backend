package com.veterinary.converter;

import com.veterinary.dto.CustomerDto;
import com.veterinary.model.Customer;
import org.springframework.core.convert.converter.Converter;
import com.veterinary.dto.PetDto;
import com.veterinary.model.Pet;
import lombok.Data;

import java.util.Objects;
import java.util.Optional;

@Data(staticConstructor = "newInstance")
public class PetDtoConverter implements Converter<PetDto, Pet> {

    @Override
    public Pet convert(PetDto petDto) {
        if (Objects.isNull(petDto)) {
            return null;
        }
        return Pet.builder()
                .id(petDto.getId())
                .category(petDto.getCategory())
                .entryDate(petDto.getEntryDate())
                .name(petDto.getName())
                .weight(petDto.getWeight())
                .customer(Optional.ofNullable(petDto.getCustomerDto()).map(ed->CustomerDtoConverter.newInstance().convert(ed)).orElse(Customer.builder().build()))
                .build();
    }
}
