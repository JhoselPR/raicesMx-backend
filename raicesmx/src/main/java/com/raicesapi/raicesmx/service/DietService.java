package com.raicesapi.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raicesapi.raicesmx.models.Diet;
import com.raicesapi.raicesmx.repository.DietRepository;

@Service
public class DietService {
	@Autowired
	private DietRepository dietRepository;
	
	// Get
		public List<Diet> findAllDiets(){
			return dietRepository.findAll();
		}
		
		public Optional<Diet> findDietById(Integer id){
			return dietRepository.findById(id);
		}
		
		// Post
		public Diet saveDiet(Diet diet) {
			return dietRepository.save(diet);
		}
		
		// Put
		
		
		// Delete
		public void deleteDiet(Integer id) {
			dietRepository.deleteById(id);
		}
}
