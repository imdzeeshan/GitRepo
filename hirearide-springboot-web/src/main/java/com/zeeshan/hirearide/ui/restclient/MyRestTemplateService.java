package com.zeeshan.hirearide.ui.restclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zeeshan.hirearide.ui.model.Car;
import com.zeeshan.hirearide.ui.model.TripInfoBean;

@Service
public class MyRestTemplateService {

    private final RestTemplate restTemplate = new RestTemplate();

 

    @SuppressWarnings("unchecked")
	public List<Car> restCallToGetCars() {
    	Car[] obj =  this.restTemplate.getForObject("http://localhost:8080/hireARide1/getCars", Car[].class);
    
    	List<Car> cars = new ArrayList<Car>();
    	for(Car objItr : obj)
    	{
    		cars.add(objItr);
    		
    	}
    	
        return cars;
    }

    
    public TripInfoBean saveTripInfo(String url, TripInfoBean tib){
    	
    	ResponseEntity<TripInfoBean> tripInfoResp = this.restTemplate.postForEntity(url, tib, TripInfoBean.class);
    	HttpStatus status = tripInfoResp.getStatusCode();
    	TripInfoBean restCall = tripInfoResp.getBody();
    	
//    	TripInfoBean restCall = this.restTemplate.postForObject(url, tib, TripInfoBean.class);
    	
    			
    	System.out.println("status = "+status );
    	return restCall;
    }
}