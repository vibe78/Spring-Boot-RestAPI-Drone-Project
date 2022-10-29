/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import retrofit2.Retrofit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author VIBE
 */
public class APIclient {
    private static Retrofit retrofit = null;
    public static Retrofit getClient(){
     HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
     interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
     OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
     retrofit = new Retrofit.Builder().baseUrl
        ("http://localhost:8080/").addConverterFactory(GsonConverterFactory.create()).client(client).build();
        return retrofit;
   
    
    }
}
