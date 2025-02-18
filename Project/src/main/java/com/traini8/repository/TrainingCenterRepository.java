package com.traini8.repository;

import com.traini8.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {

	/**
	 * Custom method to find training centers by city
	 * 
	 * @param city The city name to search for
	 * @return A list of training centers in the specified city
	 */
	List<TrainingCenter> findByAddressCityContainingIgnoreCase(String city);
}
