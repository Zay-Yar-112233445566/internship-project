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

import com.java.beans.BusType;
import com.java.beans.Driver;
import com.java.beans.Emp;
import com.java.dao.BusTypeDao;

@Controller
public class BusTypeController {

	@Autowired
	BusTypeDao busTypeDao;

	@RequestMapping("/busTypeListForm")
	public String showBusTypeListForm(Model m) {
		List<BusType> list = busTypeDao.getBusTypes();
		m.addAttribute("busTypeList", list);
		return "manager/busType/busTypeList";
	}
	@RequestMapping("/busTypeForm")
	public String showBusTypeAddForm(Model m) {
		m.addAttribute("busType", new BusType());
		return "manager/busType/busTypeAddForm";
	}
	@RequestMapping(value = "/saveBusType", method = RequestMethod.POST)
	public String saveBusType(@ModelAttribute("busType") BusType busType,RedirectAttributes reAtt) {
		int i=busTypeDao.checkBusTypeDuplicate(busType);

		if(i>0) {
			String message="Duplicate Bus Type Information!";
			reAtt.addFlashAttribute("message",message);
			reAtt.addFlashAttribute("resultFlag",0);
			return "redirect:/busTypeListForm";
		}else {
			busTypeDao.saveBusType(busType);
			String message="Successfully create new bus Type";
			reAtt.addFlashAttribute("message",message);
			reAtt.addFlashAttribute("resultFlag",1);
			return "redirect:/busTypeListForm";
		}
	}

	@RequestMapping(value = "/editBusType/{busTypeId}")
	public String editBusType(@PathVariable int busTypeId, Model m) {
		BusType busType = busTypeDao.getBusTypeById(busTypeId);
		m.addAttribute("command", busType);
		return "manager/busType/busTypeEditForm";
	}

	@RequestMapping(value = "/editsaveBusType", method = RequestMethod.POST)
	public String eidtsaveBusType(@ModelAttribute("busType") BusType busType,RedirectAttributes reAtt) {
		busTypeDao.updateBusType(busType);
		reAtt.addFlashAttribute("resultFlag",1);
		reAtt.addFlashAttribute("message","Successfully Update Bus Type Information");
		return "redirect:/busTypeListForm";
	}

	@RequestMapping(value = "/deletBusType/{busTypeId}", method = RequestMethod.GET)
	public String deleteBusType(@PathVariable int busTypeId,RedirectAttributes reAtt) {
		int i=busTypeDao.confirmBusTypeForDelete(busTypeId);
		if(i>0) {
			String message="Can't delete this busType! Already has Bus in this type!";
			reAtt.addFlashAttribute("resultFlag",0);
			reAtt.addFlashAttribute("message",message);
			return "redirect:/busTypeListForm";
		}else {
			busTypeDao.deleteBusType(busTypeId);
			String message="Successfully delete";
			reAtt.addFlashAttribute("resultFlag",1);
			reAtt.addFlashAttribute("message",message);
			return "redirect:/busTypeListForm";
		}
	}


}
