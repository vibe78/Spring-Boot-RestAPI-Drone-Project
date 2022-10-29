/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dronpro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author VIBE
 */
public class Dronpro {

    /**
     * @param args the command line arguments
     */
    	private static HttpURLConnection connection;
	public static void GetFun() {
		System.out.println("Hello");
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		try {
			URL url = new URL("http://localhost:8080/drone");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			//System.out.println(status);
			
			if(status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			
			
			parse(responseContent.toString());
                        System.out.println("TOTO"+responseContent.toString());
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
        	public static void PostFun(){
		try {
		URL url = new URL("http://localhost:8080/save");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{\n  \"battery_capacity\":50,\n  \"state\": \"RETURNING\",\n  \"weight\": 400,\n   \"serialnumber\": \"123456\",\n   \"modelweight\": \"Middleweight\"\n}";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();
		}
	  catch (IOException e) {
		  e.printStackTrace();
	    }
		
	}
	
    public static void main(String[] args) {
        // TODO code application logic here
        //PostFun();
	GetFun();
    }
    	public static String parse(String responseBody) {
		System.out.println("Action");
		JSONArray con = new JSONArray(responseBody);
                System.out.println("TOTO2"+con);
		for(int i=0; i<con.length(); i++) {
			JSONObject cons = con.getJSONObject(i);
                        System.out.println("TOTO3"+cons);
			int id = cons.getInt("id");
			int battery_capacity = cons.getInt("battery_capacity");
			String state = cons.getString("state");
			int weight = cons.getInt("weight");
                        
                        String serialnumber = cons.getString("serialnumber");
                        String modelweight = cons.getString("modelweight");
			System.out.println(" ID: "+id+ " Battery Level: "+battery_capacity+" State: "+state+" weight: "+weight+ " serialnumber: "+serialnumber+" modelweight: "+modelweight);
			
			
		}
		return null;
	}
	
}
