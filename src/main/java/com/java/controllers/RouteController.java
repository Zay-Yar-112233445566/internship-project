package com.java.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.beans.Route;
import com.java.dao.RouteDao;

@Controller
public class RouteController {

	@Autowired
	RouteDao routeDao;

	@RequestMapping("/routeListForm")
	public String showRouteListForm(Model m) {
		
		List<Route> list = routeDao.getRoutes();
		m.addAttribute("routeList",list);
		return "manager/route/routeList";
	}
	@RequestMapping("/routeForm")
	public String showRouteAddForm(Model m) {
		m.addAttribute("route", new Route());
		return "manager/route/routeAddForm";
	}

	@RequestMapping(value = "/saveRoute", method = RequestMethod.POST)
	public String saveRoute(@ModelAttribute("route") Route route,RedirectAttributes reAtt) {
		String destinationPoint=route.getDestinationPoint();
		String departurePoint=route.getDeparturePoint();	
		int i=routeDao.checkRouteDuplicate(departurePoint,destinationPoint);

		if(i>0) {
			String message="Duplicate Route  Information!";
			reAtt.addFlashAttribute("message",message);
			reAtt.addFlashAttribute("resultFlag",0);
			return "redirect:/routeListForm";
		}else {
			routeDao.saveRoute(route);
			String message="Successfully create new route";
			reAtt.addFlashAttribute("message",message);
			reAtt.addFlashAttribute("resultFlag",1);
			return "redirect:/routeListForm";
		}
	
	}

	@RequestMapping(value = "/editRoute/{id}",method = RequestMethod.GET)
	public String editRoute(@PathVariable int id, Model m) {
		Route route = routeDao.getRouteById(id);
		m.addAttribute("route", route);
		return "manager/route/routeEditForm";
	}

	@RequestMapping(value = "/editsaveRoute", method = RequestMethod.POST)
	public String eidtsaveRoute(@ModelAttribute("route") Route route,RedirectAttributes reAtt) {
		routeDao.updateRoute(route);
		reAtt.addFlashAttribute("resultFlag",1);
		reAtt.addFlashAttribute("message","Successfully Update Route Type Information");
		return "redirect:/routeListForm";
	}

	@RequestMapping(value = "/deletRoute/{routeId}", method = RequestMethod.GET)
	public String deleteRoute(@PathVariable int routeId,Model m,RedirectAttributes reAtt) {
		int i=routeDao.confirmRouteForDelete(routeId);
		if(i>0) {
			String message="Can't delete this route! Already used in bus Calendar!";
			reAtt.addFlashAttribute("resultFlag",0);
			reAtt.addFlashAttribute("message",message);
			return "redirect:/routeListForm";
		}else {
			routeDao.deleteRoute(routeId);
			String message="Successfully delete";
			reAtt.addFlashAttribute("resultFlag",1);
			reAtt.addFlashAttribute("message",message);
			return "redirect:/routeListForm";
		}
	}

}
