package ar.edu.utn.frc.tup.lciii.controllers;

import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frc.tup.lciii.dtos.ResponseDummyDTO;
import ar.edu.utn.frc.tup.lciii.dtos.SaveDummyDTO;
import ar.edu.utn.frc.tup.lciii.models.DummyModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ar.edu.utn.frc.tup.lciii.services.DummyService;

@RestController
@RequestMapping("/dummy")
public class DummyController {
	@Autowired
	private DummyService dummyService;
	@Qualifier("modelMapper")
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<ResponseDummyDTO> getDummyList() {
		List<DummyModel> dummyList = dummyService.getDummyList();

		List<ResponseDummyDTO> responseDummyList = new ArrayList<>();
		for (DummyModel dummy : dummyList) {
			responseDummyList.add(modelMapper.map(dummy, ResponseDummyDTO.class));
		}

		return responseDummyList;
	}

	@GetMapping("/{id}")
	public ResponseDummyDTO getDummyById(@PathVariable Long id) {
		return modelMapper.map(dummyService.getDummyById(id), ResponseDummyDTO.class);
	}

	@PostMapping
	public ResponseDummyDTO createDummy(@RequestBody SaveDummyDTO saveDummyDTO) {
		DummyModel dummy = modelMapper.map(saveDummyDTO, DummyModel.class);
		return modelMapper.map(dummyService.createDummy(dummy), ResponseDummyDTO.class);
	}

	@PutMapping("/{id}")
	public ResponseDummyDTO updateDummy(@PathVariable Long id, @RequestBody SaveDummyDTO saveDummyDTO) {
		DummyModel dummy = modelMapper.map(saveDummyDTO, DummyModel.class);
		dummy.setId(id);
		return modelMapper.map(dummyService.updateDummy(dummy), ResponseDummyDTO.class);
	}

	@DeleteMapping("/{id}")
	public void deleteDummyById(@PathVariable Long id) {
		dummyService.deleteDummyById(id);
	}
}
