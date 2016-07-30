package com.zeeshan.hirearide.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeeshan.hirearide.ui.model.Car;
import com.zeeshan.hirearide.ui.model.TripInfoBean;
import com.zeeshan.hirearide.ui.restclient.HireARideRestClient;
import com.zeeshan.hirearide.ui.restclient.MyRestTemplateService;
/**
 * <h1>MainController</h1>
 * Local Controller Class for the hirearide-springboot-web
 * application. It handles the requests from the web forms and their validation etc.
 * 
 * 
 * @author Muhammad Zeeshan
 * @version 1.0.0
 * @category RestController
 * @since July 2016
 * 
 */
@Controller
@RequestMapping("/")
public class MainController {
	
	/**
	 * restService -- RestService object 
	 */
	@Autowired
	MyRestTemplateService restService;
	
	
	/**
	 * Handles the first call to homepage of the application
	 * 
	 * @param tripInfo -- TripInfoBean modelAttribute object
	 * @return new ModelAndView to homepage
	 */
	@RequestMapping( method = RequestMethod.GET)
	public ModelAndView createForm(@ModelAttribute("tripInfo") TripInfoBean tripInfo) {
		
		return new ModelAndView("/rideUI/home", "tripInfo", new TripInfoBean());
	}
	
	
	/**
	 * does the task of booking a car on rent. 
	 * uses the RestService to send the post request to Rest application 
	 * and expects a TripInfoBean object in response to provide the details
	 * about booking information to user. 
	 * 
	 * @param tripInfo -- TripInfoBean object containing the booking information
	 * @return ModelAndView as rideBooked.html on success and searchResult on failure 
	 */
	@RequestMapping("/ridebook")
	public ModelAndView successBooking(@ModelAttribute("tripInfo") TripInfoBean tripInfo) {
		Car carDetail = tripInfo.getCar()!=null?tripInfo.getCar():new Car(); 
		
		//calling the restTemplate's method to save the booking information at the rest server
		tripInfo = restService.saveTripInfo("http://localhost:8080/hireARide1/bookRide", tripInfo);
		
		if(tripInfo==null){
			//returning to same page when the response body of rest call contains null
			return new ModelAndView("/rideUI/searchResult", "tripInfo", tripInfo);
		}

		//setting the car details as the rest server omits the car and user objects from the TripInfoBean object
		tripInfo.setCar(carDetail);
		return new ModelAndView("/rideUI/rideBooked", "tripInfo", tripInfo);
	}
	

	/**
	 * <ul><li>handles the form request from homepage. 
	 * <li>validates the form fields for any error.(currently null check is applied only for pickupplace field)
	 * <li>returns to homepage in case of error
	 * otherwise calls a rest service's method to get the list of available cars from rest server
	 * and returns to searchResult page which renders the available cars
	 * 
	 * @param tripInfo -- TripInfoBean Object as ModelAttribute
	 * @param result   -- BindingResult object
	 * @return - ModelAndView on success searchResult, on failure homepage.
	 */
	@RequestMapping("/form")
	public ModelAndView create(@Valid @ModelAttribute("tripInfo") TripInfoBean tripInfo, BindingResult result) {
		if (result.hasErrors()) {
			
			return new ModelAndView("rideUI/home", "formErrors", result.getAllErrors());
		}
		
		return new ModelAndView("rideUI/searchResult" ).addObject("cars", restService.restCallToGetCars());
	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	                         		 new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"), true));   
	}
	

}
