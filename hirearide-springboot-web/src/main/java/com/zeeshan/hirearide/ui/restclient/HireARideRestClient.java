package com.zeeshan.hirearide.ui.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



import com.zeeshan.hirearide.ui.model.Car;

//was writing to work with the get and post requests of REST using gson.
public class HireARideRestClient {

	@SuppressWarnings("unchecked")
	public List<Car> findCarsFromRestApi(){
		List<Car> carListJson = null;
//		try {
//     		//String s = "http://localhost:8080/WS/rest/HiRESTApplication/msg/"+req.getParameter("response");
//     		
//    		String s = "http://localhost:8080/hireARide1/getCars";
//    		URL url = new URL(s);
//    	
//    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//    		System.out.println("im in "+s); 
//    		conn.setRequestMethod("GET");
//    		conn.setRequestProperty("Accept", "application/json");
//     
//    		if (conn.getResponseCode() != 200) {
//    			throw new RuntimeException("Failed : HTTP error code : "
//    					+ conn.getResponseCode());
//    		}
//     
//    		BufferedReader br = new BufferedReader(new InputStreamReader(
//    			(conn.getInputStream())));
//     
//    		String output="";
//    		String resp="";
//    		while ((output = br.readLine()) != null) {
//    			System.out.println("Output from Server .... \n"+output); 
//    		
//    			resp+=output;
//    		}
//    		Gson gson = new Gson();
//    		System.out.println("op "+resp);
//    		
//			 carListJson = (List<Car>) gson.fromJson(resp, Car.class);
//    		
//			 if(carListJson!=null && carListJson.size()>0)
//			System.out.println("res "+carListJson.get(0)!=null?carListJson.get(0).getModel():"no obj");
//    	
//    		conn.disconnect();
//    	
//    		
//    	  } catch (MalformedURLException e) {
//     
//    		e.printStackTrace();
//     
//    	  } catch (IOException e) {
//     
//    		e.printStackTrace();
//     
//    	  }
		return carListJson;
	}
}
