package com.veterinary.manager;

import com.veterinary.converter.TreatmentConverter;
import com.veterinary.converter.TreatmentDtoConverter;
import com.veterinary.dto.TreatmentDto;
import com.veterinary.model.Treatment;
import com.veterinary.repository.TreatmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class TreatmentManager {

    private final TreatmentRepository treatmentRepository;

    public List<TreatmentDto> findAll() {
        return treatmentRepository.findAll().stream()
                .map(treatment -> TreatmentConverter.newInstance().convert(treatment))
                .collect(Collectors.toList());
    }

    public TreatmentDto getTreatmentDtoById(Long id) {
        Treatment treatment = treatmentRepository.findById(id).orElseThrow(()->new RuntimeException("Treatment not found"));

        return TreatmentConverter.newInstance().convert(treatment);
    }

    public TreatmentDto addTreatment(TreatmentDto trDto) {
        Treatment tr = TreatmentDtoConverter.newInstance().convert(trDto);
        treatmentRepository.save(tr);

        return TreatmentConverter.newInstance().convert(tr);
    }




    public TreatmentDto updateTreatment(TreatmentDto tDto){
        Treatment t = TreatmentDtoConverter.newInstance().convert(tDto);
        Treatment c = treatmentRepository.findById(t.getId()).get();
        c.setId(t.getId());
        c.setPrice(t.getPrice());
        c.setDate(t.getDate());
        c.setStatus(t.getStatus());
        c.setType(t.getType());
        treatmentRepository.save(c);
        TreatmentDto cDto = TreatmentConverter.newInstance().convert(c) ;

        return cDto;
    }


    public void deleteTreatment(Long id){
        Optional<Treatment> d = treatmentRepository.findById(id);
        if (d.isPresent()) {
            treatmentRepository.deleteById(id);
        } else {
            System.out.println("treatment not found");

        }

    }




   /* public List<TreatmentDto> addTreatments(List<TreatmentDto> treatmentDtos) {
        List<Treatment> treatments = treatmentDtos.stream()
                .map(treatmentDto -> TreatmentDtoConverter.newInstance().convert(treatmentDto))
                .collect(Collectors.toList());
        List<Treatment> savedTreatments = treatmentRepository.saveAll(treatments);
        return savedTreatments.stream()
                .map(treatment -> TreatmentConverter.newInstance().convert(treatment))
                .collect(Collectors.toList());
    }*/

   /* public TreatmentDto findTreatmentById(Long id) {
        return TreatmentConverter.newInstance().convert(treatmentRepository.findById(id).orElse(null));
    }*/

}