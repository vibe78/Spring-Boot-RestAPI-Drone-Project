package com.example.mypkg.serviceAp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mypkg.Repo.medRepo;
import com.example.mypkg.models.Medication;

@Service
public class MedService {

	@Autowired
	medRepo MedRepo;
	
	public Optional<Medication> getmedById(long id) {
		
		return MedRepo.findById(id);
		
	}
	
	
}
