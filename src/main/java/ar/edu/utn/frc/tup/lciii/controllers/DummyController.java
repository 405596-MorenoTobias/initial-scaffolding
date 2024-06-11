package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.DummyDto;
import ar.edu.utn.frc.tup.lciii.models.DummyModel;
import ar.edu.utn.frc.tup.lciii.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dummy")
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("")
    private ResponseEntity<DummyDto> getDummyList() {
        List<DummyModel> dummyModelList = dummyService.getDummyList();

        return null;
    }

    @GetMapping("/{id}")
    private ResponseEntity<DummyDto> getDummyList(@PathVariable Long id) {
        DummyModel dummyModel = dummyService.getDummy(id);
        return null;
    }

    @PostMapping("")
    private ResponseEntity<DummyDto> createDummy(DummyDto dummyDto) {
        DummyModel dummyModel = dummyService.createDummy(null);
        return null;
    }

    @PutMapping("")
    private ResponseEntity<DummyDto> updateDummy(DummyDto dummyDto) {
        DummyModel dummyModel = dummyService.updateDummy(null);
        return null;
    }

    @DeleteMapping("")
    private ResponseEntity<DummyDto> deleteDummy(DummyDto dummyDto) {
        dummyService.deleteDummy(null);
        return null;
    }


}
