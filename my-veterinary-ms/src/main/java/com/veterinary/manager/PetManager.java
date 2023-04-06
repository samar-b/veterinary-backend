package com.veterinary.manager;

import com.veterinary.converter.PetConverter;
import com.veterinary.converter.PetDtoConverter;
import com.veterinary.dto.PetDto;
import com.veterinary.model.Pet;
import com.veterinary.repository.PetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class PetManager {

    private final PetRepository petRepository;

   public List<PetDto> findAll() {
        return petRepository.findAll().stream()
                .map(pet -> PetConverter.newInstance().convert(pet))
                .collect(Collectors.toList());
    }

    public PetDto getPetDtoById(Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(()->new RuntimeException("pet not found"));
        return  PetConverter.newInstance().convert(pet);
    }


    public PetDto addPet(PetDto pitoDto){
        Pet pito = PetDtoConverter.newInstance().convert(pitoDto);
        petRepository.save(pito);

        return PetConverter.newInstance().convert(pito);

    }

    public PetDto updatePet(PetDto pDto){
        Pet p = PetDtoConverter.newInstance().convert(pDto);
        Pet c = petRepository.findById(p.getId()).get();
        c.setId(p.getId());
        c.setName(p.getName());
        c.setCategory(p.getCategory());
        c.setCustomer(p.getCustomer());
        c.setEntryDate(p.getEntryDate());
        c.setWeight(p.getWeight());
        petRepository.save(c);
        PetDto cDto = PetConverter.newInstance().convert(c) ;

        return cDto;
    }
    public void deletePet(Long id){
        Optional<Pet> d = petRepository.findById(id);
        if (d.isPresent()) {
            petRepository.deleteById(id);
        } else {
            System.out.println("pet not found");

        }

    }

    public List<String> getNamesWhileWeightConditioned() {

        return petRepository.findAll().stream()
                .filter(pet -> (pet.getWeight() > 3))
                .map(pet -> pet.getName())
                .collect(Collectors.toList());
    }




}

