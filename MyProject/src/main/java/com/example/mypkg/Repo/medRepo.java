package com.example.mypkg.Repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mypkg.models.Medication;

public interface medRepo extends JpaRepository<Medication, Long>{

}
