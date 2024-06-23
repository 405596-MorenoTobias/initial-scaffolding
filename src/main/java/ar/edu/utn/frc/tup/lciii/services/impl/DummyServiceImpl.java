package ar.edu.utn.frc.tup.lciii.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.edu.utn.frc.tup.lciii.models.DummyModel;
import ar.edu.utn.frc.tup.lciii.repositories.DummyJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.utn.frc.tup.lciii.services.DummyService;
import ar.edu.utn.frc.tup.lciii.entities.DummyEntity;

@Service
public class DummyServiceImpl implements DummyService {
    @Autowired
    private DummyJpaRepository dummyJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DummyModel> getDummyList() {
        List<DummyEntity> dummyEntities = dummyJpaRepository.findAll();

        List<DummyModel> dummyList = new ArrayList<>();

        for (DummyEntity dummyEntity : dummyEntities) {
            dummyList.add(modelMapper.map(dummyEntity, DummyModel.class));
        }

        return dummyList;
    }

    @Override
    public DummyModel getDummyById(Long id) {
        DummyEntity dummyEntity = dummyJpaRepository.getReferenceById(id);
        return modelMapper.map(dummyEntity, DummyModel.class);
    }

    @Override
    public DummyModel createDummy(DummyModel dummy) {
        Optional<DummyEntity> dummyEntityFound = dummyJpaRepository.findByDummy("something");

        if (dummyEntityFound.isPresent()) {
            return null;
        }

        DummyEntity dummyEntity = modelMapper.map(dummy, DummyEntity.class);
        DummyEntity dummyEntitySaved = dummyJpaRepository.save(dummyEntity);

        return modelMapper.map(dummyEntitySaved, DummyModel.class);
    }

    @Override
    public DummyModel updateDummy(DummyModel dummy) {
        DummyEntity dummyEntity = modelMapper.map(dummy, DummyEntity.class);
        DummyEntity dummyEntitySaved = dummyJpaRepository.save(dummyEntity);

        return modelMapper.map(dummyEntitySaved, DummyModel.class);
    }

    @Override
    public void deleteDummyById(Long id) {
        dummyJpaRepository.deleteById(id);
    }
}
