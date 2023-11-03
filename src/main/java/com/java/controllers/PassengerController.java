package com.java.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.dao.InUseDao;
import com.java.dao.RouteDao;
import com.java.beans.Bus;
import com.java.beans.InUse;
import com.java.beans.Route;

@Controller
public class PassengerController {

	@Autowired
	RouteDao routeDao;
	
	@Autowired
	InUseDao inUseDao;

	
	LocalDateTime localDateTime=LocalDate.now().atStartOfDay();
	LocalDate localDate=localDateTime.toLocalDate();
	
    String currentDate=String.valueOf(localDate); 

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
    

	
	
	@RequestMapping(value="/tripList",method=RequestMethod.POST)
	public String showAvailabelTrip(@ModelAttribute("inUse") InUse  inuse,Model m,HttpSession session) {
		
		List <Route> routeList=routeDao.getRoutes();
		m.addAttribute("routeList",routeList);
		
	    m.addAttribute("inUse",new InUse());	
	    m.addAttribute("departurePoint",inuse.getDeparturePoint());
	    m.addAttribute("destinationPoint",inuse.getDestinationPoint());
	    m.addAttribute("desiredDate",inuse.getDesiredDate());
	    
		if(inUseDao.getDesiredInUses(inuse)!=null) {
			List<InUse> availableInUseList=inUseDao.getDesiredInUses(inuse);
			m.addAttribute("inUseList",availableInUseList);
			
			return "passenger/tripList";
		}else {
		
			return "passenger/tripList";
		}
	
	}
	
	
	
	@RequestMapping("/book")
	public String showSeatLayout() {
		return "passenger/layout";
	}
	
	@RequestMapping("/homePage")
	public String showHomePage(Model m) {
		
		List <Route> routeList=routeDao.getRoutes();
		m.addAttribute("routeList",routeList);
		
	    m.addAttribute("inUse",new InUse());	
		m.addAttribute("currentDate",currentDate);
		
		return "passenger/home";
	}
}
