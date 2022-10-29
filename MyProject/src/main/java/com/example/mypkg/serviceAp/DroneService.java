package com.example.mypkg.serviceAp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mypkg.Repo.UserRepo;
import com.example.mypkg.models.drone;

@Service
public class DroneService {
	
	@Autowired
    UserRepo userRepo;
	
	public Optional<drone> getdroneById(long id) {
		
		return userRepo.findById(id);
		
	}
}
