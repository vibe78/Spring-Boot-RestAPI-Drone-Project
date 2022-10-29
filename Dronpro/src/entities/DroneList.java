/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author VIBE
 */
import com.google.gson.annotations.SerializedName;
public class DroneList implements Serializable{
    @SerializedName("id")
    private long id;
    @SerializedName("weight")
    private int weight;
    
    @SerializedName("battery_capacity")
    private int battery_capacity;
    
    @SerializedName("state")
    private String state;
    
    @SerializedName("serialnumber")
    private String serialnumber;
    
    @SerializedName("modelweight")
    private String modelweight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(int battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getModelweight() {
        return modelweight;
    }

    public void setModelweight(String modelweight) {
        this.modelweight = modelweight;
    }
    
}
