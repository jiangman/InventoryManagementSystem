package com.kossine.ims.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.PowerSupply;
import com.kossine.ims.service.PowerSupplyService;

@RestController
@RequestMapping("/powersupply")
public class PowerSupplyController {

	@Autowired
	PowerSupplyService powersupplyService;

	@GetMapping("/get/all")
	public List<PowerSupply> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return powersupplyService.findAllPowerSupply(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(powersupplyService.findPowerSupplyById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addPowerSupply(@Valid @RequestBody PowerSupply powersupply){

		return ResponseEntity.ok("{ \"id\" : " + powersupplyService.savePowerSupplyToDB(powersupply) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updatePowerSupply(@PathVariable Long id, @RequestBody PowerSupply powersupply)
			throws ModelNotFoundException  {
		powersupplyService.updatePowerSupply(id, powersupply);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deletePowerSupplyById(@PathVariable Long id) throws ModelNotFoundException {
		powersupplyService.deletePowerSupplyById(id);
		return ResponseEntity.ok().build();
	}
}
