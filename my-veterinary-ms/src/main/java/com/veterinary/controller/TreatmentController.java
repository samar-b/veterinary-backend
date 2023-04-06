package com.veterinary.controller;


import com.veterinary.dto.TreatmentDto;
import com.veterinary.manager.TreatmentManager;
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
@AllArgsConstructor
@RestController
@RequestMapping("/api")
@Validated
@Timed
@CrossOrigin(origins = "http://localhost:4200")
public class TreatmentController {

    private final TreatmentManager treatmentManager;

    @ApiOperation("get all treatments")
    @Timed
    @GetMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/treatments")
    ResponseEntity<List<TreatmentDto>> getAllTreatments() {
        List<TreatmentDto> treatments = treatmentManager.findAll();
        return ResponseEntity.ok(treatments);
    }


    /*@ApiOperation("add treatment")
    @Timed
    @PostMapping(produces = APPLICATION_JSON_VALUE, path = "/v1/treatments/add")
    @ResponseBody
    public TreatmentDto addTreatmentDto(@RequestBody TreatmentDto tDto){

        return TreatmentManager.addTreatment(tDto);
    }
*/

    @ApiOperation("get treatment by id")
    @Timed
    @GetMapping("/{id}")
    @ResponseBody
    public TreatmentDto getTreatmentDtoById(@PathVariable("id") Long id){
        return treatmentManager.getTreatmentDtoById(id);
    }


    @ApiOperation("update")
    @Timed
    @PutMapping("/v1/treatments")
    @ResponseBody
    public TreatmentDto updateTreatmentDto(@RequestBody TreatmentDto tDto) {
        return treatmentManager.updateTreatment(tDto);
    }

    @ApiOperation("delete")
    @Timed
    @DeleteMapping("/v1/treatments/delete/{id}")
    @ResponseBody
    public void deleteTreatment(@PathVariable("id") Long id) {
        treatmentManager.deleteTreatment(id);
    }










/*

    @GetMapping
    public ResponseEntity<List<TreatmentDto>> getAllTreatments() {
        return ResponseEntity.ok(treatmentManager.getAllTreatments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentDto> getTreatment(@PathVariable Long id) {
        TreatmentDto treatmentDto = treatmentManager.getTreatment(id);
        if (treatmentDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(treatmentDto);
    }

    @PostMapping
    public ResponseEntity<TreatmentDto> addTreatment(@RequestBody TreatmentDto treatmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(treatmentManager.addTreatment(treatmentDto));
    }

    @PostMapping("/add")
    public ResponseEntity<List<TreatmentDto>> addTreatments(@RequestBody List<TreatmentDto> treatmentDtos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(treatmentManager.addTreatments(treatmentDtos));
    }

    @GetMapping("/{id}/find")
    public ResponseEntity<TreatmentDto> findTreatmentById(@PathVariable Long id) {
        TreatmentDto treatmentDto = treatmentManager.findTreatmentById(id);
        if (treatmentDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(treatmentDto);
    }
*/
}