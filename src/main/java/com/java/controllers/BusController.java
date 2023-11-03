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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.beans.Bus;
import com.java.beans.BusType;
import com.java.beans.Driver;
import com.java.dao.BusDao;
import com.java.dao.BusTypeDao;

@Controller
public class BusController {

	@Autowired
	BusDao busDao;// will inject dao from XML file
	
	@Autowired
	BusTypeDao busTypeDao;
	
	LocalDateTime localDateTime=LocalDate.now().atStartOfDay();
	LocalDate localDate=localDateTime.toLocalDate();
	
    String currentDate=String.valueOf(localDate); 

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */

	@RequestMapping("/busListForm")
	public String showBusListForm(Model m) {
		m.addAttribute("bus", new Bus());
		m.addAttribute("flag",0);	
		
		List<Bus> list = busDao.getBuses();
		
		m.addAttribute("busList",list);
		m.addAttribute("currentDate",currentDate);
		
		return "manager/bus/busList";
	}
	
	@RequestMapping("/allBusListForm")
	public String showAllDriverListForm(Model m) {
		m.addAttribute("bus", new Bus());
		m.addAttribute("flag",0);
        
		List<Bus> list = busDao.getBuses();
		
		m.addAttribute("busList",list);
		m.addAttribute("currentDate",currentDate);
		
		return "manager/bus/busList";
		
	}
	
	@RequestMapping(value="/availableBusForm",method = RequestMethod.POST)
	public String showDesiredDriverListForm(@ModelAttribute("bus") Bus bus,Model m) {
		m.addAttribute("bus", new Bus());
		m.addAttribute("desiredDate",bus.getDesiredDate());
		m.addAttribute("flag",1);
		
		List<Bus> list = busDao.getDesiredBuses(bus.getDesiredDate());
		m.addAttribute("busList",list);
		return "manager/bus/busList";
		
	}
	
	
	@RequestMapping("/busForm")
	public String showBusAddForm(Model m) {
		List<BusType> busTypeList=busTypeDao.getBusTypes();
		m.addAttribute("busTypeList",busTypeList);
		m.addAttribute("bus", new Bus());
		return "manager/bus/busAddForm";
	}
	
	@RequestMapping(value ="/saveBus", method = RequestMethod.POST)
	public String saveBus(@ModelAttribute("bus") Bus bus,RedirectAttributes reAtt) {
		busDao.saveBus(bus);
		reAtt.addFlashAttribute("resultFlag",1);
		reAtt.addFlashAttribute("message","Successfully create new Bus");
		return "redirect:/busListForm";
	}

	@RequestMapping(value = "/editBus/{busId}")
	public String editBus(@PathVariable int busId, Model m) {	
		
		Bus bus = busDao.getBusById(busId);
		m.addAttribute("bus", bus);
		List<BusType> busTypeList=busTypeDao.getBusTypes();
		m.addAttribute("busTypeList",busTypeList);	
		return "manager/bus/busEditForm";
	}

	@RequestMapping(value = "/editsaveBus", method = RequestMethod.POST)
	public String eidtsaveBus(@ModelAttribute("bus") Bus bus,RedirectAttributes reAtt) {
		busDao.updateBus(bus);
		reAtt.addFlashAttribute("resultFlag",1);
		reAtt.addFlashAttribute("message","Successfully Update Bus Information");
		return "redirect:/busListForm";
	}

	@RequestMapping(value = "/deletBus/{busId}", method = RequestMethod.GET)
	public String deleteBus(@PathVariable int busId, Model m,RedirectAttributes reAtt) {
		int i=busDao.confirmBusForDelete(busId);
		if(i>0) {
			String message="Can't delete this bus! Already used in Inuse.";
			reAtt.addFlashAttribute("resultFlag",0);
			reAtt.addFlashAttribute("message",message);
			return "redirect:/busListForm";
		}else {
			busDao.deleteBus(busId);
			String message="Successfully delete";
			reAtt.addFlashAttribute("resultFlag",1);
			reAtt.addFlashAttribute("message",message);
			return "redirect:/busListForm";
		}
	}


}
