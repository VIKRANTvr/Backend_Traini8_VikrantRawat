package com.traini8.controller;

import com.traini8.model.TrainingCenter;
import com.traini8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

	private final TrainingCenterService service;
	// Constructor-based dependency injection for TrainingCenterService

	public TrainingCenterController(TrainingCenterService service) {
		this.service = service;
	}

	// Created a new Training Center

	@PostMapping
	public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
		// Calls the service layer to save the new TrainingCenter

		TrainingCenter savedCenter = service.saveTrainingCenter(trainingCenter);
		return ResponseEntity.status(201).body(savedCenter); // Return with 201 Created status
	}

	// Get all Training Centers

	@GetMapping
	public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
		// Fetches the list of all training centers from the service layer

		List<TrainingCenter> centers = service.getAllTrainingCenters();
		return ResponseEntity.ok(centers); // Return list with 200 OK status
	}

	// Get a specific Training Center by ID

	@GetMapping("/{id}")
	public ResponseEntity<TrainingCenter> getTrainingCenterById(@PathVariable Long id) {
		TrainingCenter center = service.getTrainingCenterById(id);
		return ResponseEntity.ok(center); // Return the found training center with 200 OK status
	}
}
