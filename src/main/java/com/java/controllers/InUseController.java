package com.java.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.beans.Bus;
import com.java.beans.Driver;
import com.java.beans.InUse;
import com.java.beans.Route;
import com.java.dao.InUseDao;
import com.java.dao.BusDao;
import com.java.dao.DriverDao;
import com.java.dao.RouteDao;

@Controller
public class InUseController {

	@Autowired
	InUseDao inUseDao;// will inject dao from XML file
	@Autowired
	DriverDao driverDao;
	@Autowired
	BusDao busDao;
	@Autowired
	RouteDao routeDao;
	
	LocalDateTime localDateTime=LocalDate.now().atStartOfDay();
	LocalDate localDate=localDateTime.toLocalDate();
	
    String currentDate=String.valueOf(localDate);

	@RequestMapping("/inUseListForm")
	public String showInUseListForm(Model m) {
		
		List<InUse> list = inUseDao.getInUses();
		m.addAttribute("inUseList",list);
		
		m.addAttribute("inuse",new InUse());
		m.addAttribute("flag",0);
		m.addAttribute("currentDate",currentDate);
		
		return "manager/inUse/inUseList";
	}
	
	@RequestMapping("/allInUseListForm")
	public String showAllInUseListForm(Model m) {
		
		List<InUse> list = inUseDao.getInUses();
		m.addAttribute("inUseList",list);
		
		m.addAttribute("inuse",new InUse());
		m.addAttribute("flag",0);
		
		m.addAttribute("currentDate",currentDate);
		
		return "manager/inUse/inUseList";
	}
	
	
	
	@RequestMapping("/inUseForm")
	public String showInUseAddForm(Model m) {
		
		m.addAttribute("inUse", new InUse());
		m.addAttribute("inUse1", new InUse());
		
		return "manager/inUse/inUseAddForm";
	}
	
	@RequestMapping(value = "/searchValidInfo",method = RequestMethod.POST)
	public String showValidInUseForm(@ModelAttribute("inUse") InUse inUse1, Model m) {
		
		List<Driver> availableDriver=driverDao.getDesiredDrivers(inUse1.getDepartureDate());
		m.addAttribute("availableDriver",availableDriver);
		
		List<Bus> availableBus=busDao.getDesiredBuses(inUse1.getDepartureDate());
		m.addAttribute("availableBus",availableBus);
		
		List<Route> routeList=routeDao.getRoutes();
		m.addAttribute("routeList",routeList);
		
		m.addAttribute("departureDate", inUse1.getDepartureDate());
		
		m.addAttribute("inUse", new InUse());
		m.addAttribute("inUse1", new InUse());
		return "manager/inUse/inUseAddForm";
	}

	
	@RequestMapping(value = "/saveInUse", method = RequestMethod.POST)
	public String saveInUse(@ModelAttribute("inUse") InUse inUse,@ModelAttribute("inUse1") InUse inUse1,Model m,RedirectAttributes reAtt) {
		System.out.println(inUse1.getDepartureDate());
		if(inUseDao.saveInUse(inUse)==1) {
			m.addAttribute("successFlag",1);
			
			m.addAttribute("inUse", new InUse());
			
			LocalDateTime localDateTime=LocalDate.now().atStartOfDay();
			LocalDate localDate=localDateTime.toLocalDate();
			
	        String date=String.valueOf(localDate);
	        
			List<Driver> availableDriver=driverDao.getDesiredDrivers(date);
			m.addAttribute("availableDriver",availableDriver);
			
			
			List<Bus> availableBus=busDao.getDesiredBuses(date);
			m.addAttribute("availableBus",availableBus);
			
			List<Route> routeList=routeDao.getRoutes();
			m.addAttribute("routeList",routeList);
			
			String message = "Successfully register new bus calendar";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag",1);
			
			return "redirect:/inUseListForm";
		}else {
	
			return "redirect:/inUseListForm";
		}
	}

	
	@RequestMapping(value = "/availableInUseForm", method = RequestMethod.POST)
	public String showDesiredInUseListForm(@ModelAttribute("inUse") InUse inUse,Model m) {
		
		List<InUse> inUseList=inUseDao.getDesiredInUses(inUse);
		m.addAttribute("inUseList",inUseList);
		m.addAttribute("flag",1);
		
		m.addAttribute("desiredDate",inUse.getDesiredDate());
		m.addAttribute("inuse", new InUse());
		
		return "manager/inUse/inUseList";
	}
	
	@RequestMapping(value = "/editInUse/{id}",method = RequestMethod.GET)
	public String editInUse(@PathVariable int id, Model m) {
		
		InUse inUse = inUseDao.getInUseById(id);
		
		List<Driver> availableDriverList=driverDao.getDesiredDrivers(inUse.getDepartureDate());
		m.addAttribute("availableDriverList",availableDriverList);
		
		List<Bus> availableBusList=busDao.getDesiredBuses(inUse.getDepartureDate());
		m.addAttribute("availableBusList",availableBusList);
		
		List<Route> routeList=routeDao.getRoutes();
		m.addAttribute("routeList",routeList);
		
		m.addAttribute("inUse", inUse);
		return "manager/inUse/inUseEditForm";
	}

	@RequestMapping(value = "/editsaveInUse", method = RequestMethod.POST)
	public String eidtsaveInUse(@ModelAttribute("inUse") InUse inUse,RedirectAttributes reAtt) {
		inUseDao.updateInUse(inUse);
		String message = "Successfully update bus calendar information !";
		reAtt.addFlashAttribute("message", message);
		reAtt.addFlashAttribute("resultFlag",1);
		return "redirect:/inUseListForm";
	}

	@RequestMapping(value = "/deletInUse/{inUseId}", method = RequestMethod.GET)
	public String deleteInUse(@PathVariable int inUseId,RedirectAttributes reAtt) {
		inUseDao.deleteInUse(inUseId);
		
		String message = "Successfully delete bus calendar!";
		reAtt.addFlashAttribute("message", message);
		reAtt.addFlashAttribute("resultFlag",1);
		
		return "redirect:/inUseListForm";
	}
	

}
