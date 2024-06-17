package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.DummyModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DummyService {

    List<DummyModel> getDummyList();
    DummyModel getDummyById(Long id);
    DummyModel createDummy(DummyModel dummy);
    DummyModel updateDummy(DummyModel dummy);
    void deleteDummyById(Long id);
}
