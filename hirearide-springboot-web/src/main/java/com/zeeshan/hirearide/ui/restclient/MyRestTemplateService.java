package com.zeeshan.hirearide.ui.restclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zeeshan.hirearide.ui.model.Car;
import com.zeeshan.hirearide.ui.model.TripInfoBean;

/**
 *<h1>Interface TripInfoService</h1>
 * provides service layer functionality mainly related to Trip Information or Booking Information
 *  
 * 
 * 
 * @author Muhammad Zeeshan
 * @version 1.0.0
 * @category Service Class
 * @since July 2016
 *
 */
@Service
public class MyRestTemplateService {

    /**
     * restTemplate -- RestTemplate Object 
     * 
     */
    private final RestTemplate restTemplate = new RestTemplate();

 

    /**
     * this method sends a GET request to rest server at http://localhost:8080/hireARide1/getCars 
     * and expects an array of type Car. The Car Array is converted into List then this list is returned.
     * 
     * @return List<Car> -- list of cars
     */
    @SuppressWarnings("unchecked")
	public List<Car> restCallToGetCars() {
    	// Calling rest GET request
    	Car[] obj =  this.restTemplate.getForObject("http://localhost:8080/hireARide1/getCars", Car[].class);
    
    	List<Car> cars = new ArrayList<Car>();
    	// Converting array to list
    	for(Car objItr : obj)
    	{
    		cars.add(objItr);
    		
    	}
    	
        return cars;
    }

    
    /**
     * this method sends a POST request to rest server at URL in parameter with a TripInfoBean Object in Request body.  
     * The responseEntity contains the response from the server, 
     * HTTP status and a TripInfoBean object in ResponseBody.
     * 
     * @param url -- URL to send POST Request to REST server
     * @param tib -- TripInfoBean Object to be send attached in the POST request
     * @return TripInfoBean -- TripInfoBean Object contained in response body.
     */
    public TripInfoBean saveTripInfo(String url, TripInfoBean tib){
    	// sending the POST request to REST Server 
    	ResponseEntity<TripInfoBean> tripInfoResp = this.restTemplate.postForEntity(url, tib, TripInfoBean.class);
    	HttpStatus status = tripInfoResp.getStatusCode();   // HTTPStatus from Response
    	TripInfoBean restCall = tripInfoResp.getBody();     // TripInfoBean Object from Response Body
    	
//    	TripInfoBean restCall = this.restTemplate.postForObject(url, tib, TripInfoBean.class); we can use this code alternatively.
    	
    			
    	System.out.println("status = "+status );
    	return restCall;
    }
}