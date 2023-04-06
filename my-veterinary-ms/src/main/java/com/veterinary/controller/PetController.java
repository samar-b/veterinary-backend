package com.veterinary.controller;

import com.veterinary.dto.PetDto;
import com.veterinary.manager.PetManager;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/pets")
@Validated
@AllArgsConstructor
@Timed
@CrossOrigin(origins = "http://localhost:4200")

public class PetController {

    private final PetManager petManager;


    @ApiOperation("get all pets")
    @Timed
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/pets")
    ResponseEntity<List<PetDto>> getAllPets() {
        List<PetDto> pets = petManager.findAll();
        return ResponseEntity.ok(pets);
    }

    @ApiOperation("add pet")
    @Timed
    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/addpet")
    @ResponseBody
    public PetDto addPetDto(@RequestBody PetDto pDto){

        return petManager.addPet(pDto);
    }

    @ApiOperation("get pet by id")
    @Timed
    @GetMapping("/{id}")
    @ResponseBody
    public PetDto getPetDtoById(@PathVariable("id") Long id){
        return petManager.getPetDtoById(id);
    }

    @ApiOperation("update")
    @Timed
    @PutMapping("/updatePet")
    @ResponseBody
    public PetDto updatePetDto(@RequestBody PetDto pDto) {
        return petManager.updatePet(pDto);
    }


    @ApiOperation("delete")
    @Timed
    @DeleteMapping("/deletePet/{id}")
    @ResponseBody
    public void deletePet(@PathVariable("id") Long id) {
        petManager.deletePet(id);
    }

    @ApiOperation("getNamePetByWeight")
    @Timed
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/getNames")
    @ResponseBody
    public ResponseEntity<List<String>> getPetNameByWeight() {
        List<String> names = petManager.getNamesWhileWeightConditioned();
        return ResponseEntity.ok(names);
    }

    /*@ApiOperation("getNamesAndCategoriesById")
    @Timed
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/getNamesAndCategories")
    @ResponseBody
    public ResponseEntity<List<String>> getNamesAndCategories(@RequestBody List<Long> ids ) {
        List<String> namesAndCategories = petManager.getNamesAndCategoriesByIds(ids);
        return (ResponseEntity<List<String>>) ResponseEntity.ok();
    }*/


}
