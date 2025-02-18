package com.traini8.service;

import com.traini8.model.TrainingCenter;
import com.traini8.repository.TrainingCenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {

	// Custom Exception to be thrown when a resource is not found
	public static class ResourceNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public ResourceNotFoundException(String message) {
			super(message);
		}
	}

	private final TrainingCenterRepository repository;

	public TrainingCenterService(TrainingCenterRepository repository) {
		this.repository = repository;
	}

	/**
	 * Save a new training center
	 * 
	 * @param trainingCenter The training center to be saved
	 * @return The saved training center
	 */
	public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter) {
		return repository.save(trainingCenter);
	}

	/**
	 * Get all training centers
	 * 
	 * @return A list of all training centers
	 */
	public List<TrainingCenter> getAllTrainingCenters() {
		return repository.findAll();
	}

	/**
	 * Get a training center by ID
	 * 
	 * @param id The ID of the training center to fetch
	 * @return The training center with the given ID
	 */
	public TrainingCenter getTrainingCenterById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Training Center not found with id: " + id));
	}

	/**
	 * Filter training centers by city
	 * 
	 * @param city The city to filter by
	 * @return A list of training centers in the given city
	 */
	public List<TrainingCenter> getTrainingCentersByCity(String city) {
		return repository.findByAddressCityContainingIgnoreCase(city);
	}
}
