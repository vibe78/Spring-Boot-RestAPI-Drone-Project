package com.example.mypkg.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Droneadded {

   private long drone_id;

   private long medication_id;
/**
 * @return the drone_id
 */
public long getDrone_id() {
	return drone_id;
}
/**
 * @param drone_id the drone_id to set
 */
public void setDrone_id(long drone_id) {
	this.drone_id = drone_id;
}
/**
 * @return the medication_id
 */
public long getMedication_id() {
	return medication_id;
}
/**
 * @param medication_id the medication_id to set
 */
public void setMedication_id(long medication_id) {
	this.medication_id = medication_id;
}
   
   
}
