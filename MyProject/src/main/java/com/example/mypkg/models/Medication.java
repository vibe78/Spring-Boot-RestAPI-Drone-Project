package com.example.mypkg.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Medication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@Column
	private int weight;
	@Column
	private String code;
	@Column
	private String medname;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "addedmedication")
	private Set<drone> drone = new HashSet<>();
	
	
	
	
	
	
	
	
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="drone_id", referencedColumnName = "id")
   // private drone drone;
	



	/**
	 * @return the drone
	 */
	//public drone getDrone() {
	//	return drone;
	//}

	/**
	 * @param drone the drone to set
	 */
	//public void setDrone(drone drone) {
	//	this.drone = drone;
	//}

	/**
	 * @return the drone
	 */
	public Set<drone> getDrone() {
		return drone;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the medname
	 */
	public String getMedname() {
		return medname;
	}

	/**
	 * @param medname the medname to set
	 */
	public void setMedname(String medname) {
		this.medname = medname;
	}

	//public void assignDrone(com.example.mypkg.models.drone drone) {
		// TODO Auto-generated method stub
		//  this.drone = drone;
	//}





    
    
}
