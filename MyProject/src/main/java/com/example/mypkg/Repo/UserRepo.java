package com.example.mypkg.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mypkg.models.drone;

public interface UserRepo extends JpaRepository<drone, Long>{
      
}
