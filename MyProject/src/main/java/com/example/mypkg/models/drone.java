package com.example.mypkg.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class drone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column
    private int weight;
	
	/**
	 * @return the medication
	 */


	
	
	/**
	 * @param addedmedication the addedmedication to set
	 */
	public void setAddedmedication(Set<Medication> addedmedication) {
		this.addedmedication = addedmedication;
	}

	
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "drone")
	@ManyToMany
	@JoinTable(
		name="dron_added",
		joinColumns = @JoinColumn(name= "drone_id"), 
		inverseJoinColumns =  @JoinColumn(name= "medication_id")
	)
	private Set<Medication>addedmedication = new HashSet<>();
    /**
	 * @return the addedmedication
	 */
	public Set<Medication> getAddedmedication() {
		return addedmedication;
	}
	/**
	 * @return the medication
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
	 * @return the battery_capacity
	 */
	public int getBattery_capacity() {
		return battery_capacity;
	}
	/**
	 * @param battery_capacity the battery_capacity to set
	 */
	public void setBattery_capacity(int battery_capacity) {
		this.battery_capacity = battery_capacity;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	@Column
	private int battery_capacity;
	@Column
    private String state;
	
	@Column
	private String serialnumber;
	@Column
	private String modelweight;
	@Column
	private String Name;
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the serialnumber
	 */
	public String getSerialnumber() {
		return serialnumber;
	}
	/**
	 * @param serialnumber the serialnumber to set
	 */
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	/**
	 * @return the modelweight
	 */
	public String getModelweight() {
		return modelweight;
	}
	/**
	 * @param modelweight the modelweight to set
	 */
	public void setModelweight(String modelweight) {
		this.modelweight = modelweight;
	}

	public void assignDrone(Medication medication) {
		// TODO Auto-generated method stub
		addedmedication.add(medication);
	}





}
