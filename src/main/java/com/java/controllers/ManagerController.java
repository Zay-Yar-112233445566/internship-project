package com.java.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.beans.Driver;
import com.java.beans.Emp;
import com.java.beans.Manager;
import com.java.dao.BusDao;
import com.java.dao.BusTypeDao;
import com.java.dao.DriverDao;
import com.java.dao.InUseDao;
import com.java.dao.ManagerDao;
import com.java.dao.RouteDao;


@Controller
public class ManagerController {

	@Autowired
	BusDao busDao;
	
	@Autowired
	DriverDao driverDao;

	@Autowired
	RouteDao routeDao;
	
	@Autowired
	BusTypeDao busTypeDao;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	InUseDao inUseDao;

	@RequestMapping("/")
	public String showLoginPage(Model m) {
		
		m.addAttribute("manager",new Manager());
		m.addAttribute("driver",new Driver());
		return "manager/login";
	}

	@RequestMapping(value="/validateManager",method = RequestMethod.POST)
	public String validateManager(@ModelAttribute("manager") Manager manager,HttpSession session,Model m,RedirectAttributes reAtt) throws NoSuchAlgorithmException, IOException {
		
		int i=managerDao.authenticateManager(manager);
		
		if(i==1) {
			Manager manager2=managerDao.getManager(manager);
			session.setMaxInactiveInterval(60000);
			session.setAttribute("managerSession", manager2);
			
			String message = "Warmly Welcome";
			reAtt.addAttribute("message", message);
			reAtt.addAttribute("resultFlag", 1);
			return "redirect:/managerForm";
			
		}else {
			return "redirect:/loginForm";
		}
	}
	

	@RequestMapping("/managerForm")
	public String showManagerForm(Model m,HttpSession httpSession) {
		
		int busCount=busDao.getBusCount();
		httpSession.setAttribute("busCount", busCount);
		
		int driverCount=driverDao.getDriverCount();
		httpSession.setAttribute("driverCount", driverCount);
		
		int routeCount=routeDao.getRouteCount();
		httpSession.setAttribute("routeCount", routeCount);
		
		int busTypeCount=busTypeDao.getBusTypeCount();
		httpSession.setAttribute("busTypeCount", busTypeCount);
		
		int busCalendarCount=inUseDao.getInUseCount();
		httpSession.setAttribute("busCalendarCount", busCalendarCount);
		
		Manager manager=(Manager)httpSession.getAttribute("managerSession");
		httpSession.setAttribute("managerSession", manager);
		
		
		return "manager/manager";
	}
	
	
	@RequestMapping("/userprofile")
	public String showManagerProfile(Model m,HttpSession httpSession) {
		Manager manager = (Manager) httpSession.getAttribute("managerSession");
		Manager managerInfo = managerDao.getManagerById();
		m.addAttribute("manager", managerInfo);
		m.addAttribute("manager1",new Manager());
		m.addAttribute("managerUpdate", new Manager());
		
		return "manager/userprofile";
	}
	
	
	@RequestMapping(value="/managerUpdate",method = RequestMethod.POST)
	public String updateManagerInfo(@ModelAttribute("manager1") Manager manager,Model m,HttpSession session,  RedirectAttributes reAtt) {
		
		if (managerDao.updateManager(manager) == 1) {
			
			String message = "Successfully Update profile";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag", 1);
			return "redirect:/userprofile";
			
		} else {
			String message = "Can't update";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag", 0);
			return "redirect:/userprofile";
		}
	}
	
	
	@RequestMapping(value = "/updateManagerPassword", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("managerUpdate") Manager manager, Model m, RedirectAttributes reAtt)
			throws NoSuchAlgorithmException, IOException {

		String newPassword = manager.getNewPassword();
		String confirmPassword = manager.getConfirmPassword();

		System.out.println(manager.getManagerId());
		boolean result = newPassword.equals(confirmPassword);
		System.out.println(manager.getManagerPassword());
		System.out.println(newPassword);
		System.out.println(confirmPassword);

		if (managerDao.authenticateManager(manager) == 1) {
			if (result) {
				managerDao.updateManagerPassword(manager);
				String message = "Successfully Update password";
				reAtt.addFlashAttribute("message", message);
				reAtt.addFlashAttribute("resultFlag", 1);
				return "redirect:userprofile";
			} else {
				String message = "Doesn't match password!";
				reAtt.addFlashAttribute("message", message);
				reAtt.addFlashAttribute("resultFlag", 0);
				return "redirect:userprofile";
			}
		} else {
			String message = "Wrong old passwod";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag", 0);
			return "redirect:userprofile";
		}
	}
	
	@RequestMapping("/signOut")
	public String signOutManager(HttpSession session,Model m) {
		
		session.invalidate();
		
		m.addAttribute("manager",new Manager());
		m.addAttribute("driver",new Driver());
		return "manager/login";
	}
	
	@RequestMapping("/loginForm")
	public String showLogin(Model m) {
		
		m.addAttribute("manager",new Manager());
		m.addAttribute("driver",new Driver());
		return "manager/login";
	}
	
	
	
	@RequestMapping("/contact")
	public String contactPage() {
		return "manager/contact";
	}
	
	
	@RequestMapping("/forgotPassword")
	public String showForgotPasswordForm(Model m) {
		m.addAttribute("command",new Emp());
		return "manager/forgotPassword";
	}
	

}
