package com.example.mypkg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mypkg.Repo.UserRepo;
import com.example.mypkg.Repo.medRepo;
import com.example.mypkg.models.Droneadded;
import com.example.mypkg.models.Medication;
import com.example.mypkg.models.drone;
import com.example.mypkg.serviceAp.DroneService;

import com.example.mypkg.serviceAp.MedService;

@RestController
public class Apicontroller {
    @Autowired
	private UserRepo userRepo;
    @Autowired
	private medRepo medRepo;
    @Autowired
    private DroneService droneservice;
    @Autowired
    private MedService medservice;
    @Autowired
   
    

   
   
   

@RequestMapping(value="/home")
   public String getPage() {
	   return "Welcome";
   }
   
   /*
    * This is The part of the API function that get all data from the database
    * */
   @GetMapping(value ="/drone")
   public List<drone> getDrone() {
	   return userRepo.findAll();
   }
   
   
   
   /*
    * This is The part of the API function that get all data from the database Medication
    * */
   @GetMapping(value ="/medication")
   public List<Medication> getMedication() {
	   return medRepo.findAll();
   }
   
   
   
   
   /*
    * This is the part of the API method that post to the Drone Database
    * */
   @PostMapping(value="/save")
   public String savedrone(@RequestBody drone d) {
	   userRepo.save(d);
	   return "Save........";
	   
	   
   }
   
   /*
    * This is the part of the API method that post to the Medication Database
    * */
   @PostMapping(value="/save_medication")
   public String savemedication(@RequestBody Medication medication) {
	   medRepo.save(medication);
	   return "Save........";
	   
	   
   }
   
   
   
   /*
    * This is the part of the API method that updates to the database
    * */
   @PutMapping(value="update/{id}")
   public String updateDrone(@PathVariable long id, @RequestBody drone d) {
	   drone updatedDrone = userRepo.findById(id).get();
	   updatedDrone.setWeight(d.getWeight());
	   updatedDrone.setBattery_capacity(d.getBattery_capacity());
	   updatedDrone.setState(d.getState());
	   updatedDrone.setSerialnumber(d.getSerialnumber());
	   updatedDrone.setModelweight(d.getModelweight());
	   updatedDrone.setName(d.getName());
	   userRepo.save(updatedDrone);
	   return "Updated..........";
   }
   
   /*This is the function API that deletes Data from the Database*/
   @DeleteMapping(value="delte/{id}")
   public String deleteDrone(@PathVariable long id) {
	   drone deltedDrone = userRepo.findById(id).get();
	   userRepo.delete(deltedDrone);
	   return "Delete user with the Id"+id;
   }
   
   /*Work on the drone select Id*/
   @GetMapping(value ="dronid/{id}")
   public List<drone> GetDrone(@PathVariable long id) {
	   return null;
   }
   
   @RequestMapping(value = "dronId/{id}")
   public Optional<drone> getDr(@PathVariable("id") long id) {
	   return this.droneservice.getdroneById(id);
   }
   
   /*Med By ID*/
   @RequestMapping(value = "medId/{id}")
   public Optional<Medication> getMEd(@PathVariable("id") long id) {
	   return this.medservice.getmedById(id);
   }
   
  // @RequestMapping(value = "dronId/{id}")
   //public Optional<Medication> getMed(@PathVariable("medname") String medname) {
	///   return this.droneservice.getdroneById(id);
  // }
   
   //@GetMapping(value ="/all")
   //public ResponseEntity<List<Droneadded>>searchDronemed(String query){
   ///	   return ResponseEntity.ok(joinservice.searchDronemed(query));
   //}

   
   //@RequestMapping(value="dronid/{id}")
   //public String GetDrone(@PathVariable long id) {
	//   drone GDrone = userRepo.findById(id).get();
	//   
	//   return userRepo.findAll();
  // }
   
   
   @PutMapping("/{medicationId}/drone/{droneId}")
   drone assignDroneToMedication(
		   @PathVariable long droneId,
		   @PathVariable long medicationId
		  
   ) {
	   drone drone = userRepo.findById(droneId).get();
	   Medication medication = medRepo.findById(medicationId).get();
	  // drone drone = UserRepo.findById(droneId).get();
	   drone.assignDrone(medication);
	   
	   return userRepo.save(drone);
   }
   
   
   
} 
