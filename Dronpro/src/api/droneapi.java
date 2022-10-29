/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package api;

import entities.DroneList;
import java.util.List;

import retrofit2.Call;

import retrofit2.Call;
import retrofit2.http.GET;



/**
 *
 * @author VIBE
 */
public interface droneapi {
    @GET("http://localhost:8080/drone")
    Call<List<DroneList>> findAll();
}
