package com.raicesapi.raicesmx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raicesapi.raicesmx.models.Diet;
import com.raicesapi.raicesmx.service.DietService;

@RestController
@RequestMapping("/api/diet")
public class DietController {
	@Autowired
	private DietService dietService;

	// Get
	@GetMapping
	public List<Diet> getAllDiets() {
		return dietService.findAllDiets();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Diet> getDietById(@PathVariable("id") Integer id) {
		return dietService.findDietById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
