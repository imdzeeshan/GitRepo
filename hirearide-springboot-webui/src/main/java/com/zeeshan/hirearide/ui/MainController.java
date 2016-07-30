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

import com.zeeshan.hirearide.ui.model.TripInfoBean;




@Controller
@RequestMapping("/")
public class MainController {
	
	
	@RequestMapping( method = RequestMethod.GET)
	public ModelAndView createForm(@ModelAttribute("tripInfo") TripInfoBean tripInfo) {
		
		return new ModelAndView("/rideUI/home", "tripInfo", new TripInfoBean());
	}
	
	@RequestMapping("/ridebook")
	public ModelAndView successBooking(@ModelAttribute("tripInfo") TripInfoBean tripInfo) {
		

		return new ModelAndView("/rideUI/rideBooked", "tripInfo", tripInfo);
	}


	@RequestMapping("/form")
	public ModelAndView create(@Valid @ModelAttribute("tripInfo") TripInfoBean tripInfo, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			System.out.println("here");
			List<FieldError> errors = result.getFieldErrors();
		    for (FieldError error : errors ) {
		        System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
		    }
			return new ModelAndView("rideUI/home", "formErrors", result.getAllErrors());
		}
		
	
		System.out.println("trip "+tripInfo.getPickupPlace());
		return new ModelAndView("rideUI/searchResult");
	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(       Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"), true));   
	}
	

}
