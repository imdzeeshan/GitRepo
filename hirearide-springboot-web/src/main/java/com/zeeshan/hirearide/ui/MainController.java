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




@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	MyRestTemplateService restService;
	
	
	@RequestMapping( method = RequestMethod.GET)
	public ModelAndView createForm(@ModelAttribute("tripInfo") TripInfoBean tripInfo) {
		
		return new ModelAndView("/rideUI/home", "tripInfo", new TripInfoBean());
	}
	
	
	@RequestMapping("/ridebook")
	public ModelAndView successBooking(@ModelAttribute("tripInfo") TripInfoBean tripInfo) {
		Car carDetail = tripInfo.getCar()!=null?tripInfo.getCar():new Car(); 
		
		tripInfo = restService.saveTripInfo("http://localhost:8080/hireARide1/bookRide", tripInfo);
		
		if(tripInfo==null){
			
			return new ModelAndView("/rideUI/searchResult", "tripInfo", tripInfo);
		}

		tripInfo.setCar(carDetail);
		return new ModelAndView("/rideUI/rideBooked", "tripInfo", tripInfo);
	}
	

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
