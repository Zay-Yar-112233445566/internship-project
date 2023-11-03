package com.java.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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

import com.java.beans.Driver;
import com.java.beans.Manager;
import com.java.dao.DriverDao;

@Controller
public class DriverController {

	@Autowired
	DriverDao driverDao;

	LocalDateTime localDateTime = LocalDate.now().atStartOfDay();
	LocalDate localDate = localDateTime.toLocalDate();
	String currentDate = String.valueOf(localDate);

	@RequestMapping(value = "/validateDriver", method = RequestMethod.POST)
	public String validateDriver(@ModelAttribute("driver") Driver driver, HttpSession session, Model m,
			RedirectAttributes reAtt) throws NoSuchAlgorithmException, IOException {

		if (driverDao.authenticateDriver(driver) == 1) {
			m.addAttribute("driver", new Driver());

			Driver getDriver = driverDao.getDriver(driver);
			session.setAttribute("driverSession", getDriver);
			session.setMaxInactiveInterval(600000000);

			Driver driverInfo = driverDao.getDriver(driver);
			m.addAttribute("driverInfo", driverInfo);

			List<Driver> allDriverTripList = driverDao.getAllDriverTrip(getDriver.getDriverId());
			m.addAttribute("driverTripList", allDriverTripList);

			m.addAttribute("currentDate", currentDate);

			String message = "Warmly Welcome "+driverInfo.getDriverName();
			m.addAttribute("resultFlag", 1);
			m.addAttribute("message", message);
			m.addAttribute("flag", 0);
			return "driver/driverPage";

		} else {
			String message = "Wrong email or  password for driver login.";
			reAtt.addFlashAttribute("resultFlag", 0);
			reAtt.addFlashAttribute("message", message);
			return "redirect:/loginForm";
		}
	}
 
	@RequestMapping("/driverHome")
	public String driverHome( HttpSession session, Model m, RedirectAttributes reAtt) throws NoSuchAlgorithmException, IOException {
	     
		
		    m.addAttribute("driver", new Driver());
			Driver driver=(Driver)session.getAttribute("driverSession");               
			Driver driverInfo = driverDao.getDriverForInfo(driver.getDriverId());
			m.addAttribute("driverInfo", driverInfo);

			List<Driver> allDriverTripList = driverDao.getAllDriverTrip(driverInfo.getDriverId());
			m.addAttribute("driverTripList", allDriverTripList);

			m.addAttribute("currentDate", currentDate);

			String message = "Warmly Welcome From Home "+driverInfo.getDriverName();
			m.addAttribute("resultFlag", 1);
			m.addAttribute("message", message);
			m.addAttribute("flag", 0);
			return "driver/driverPage";

	}

	@RequestMapping(value = "/availableAssignedListForm", method = RequestMethod.POST)
	public String availableAssignedListForm(@ModelAttribute("driver") Driver driver, Model m, HttpSession session) throws NoSuchAlgorithmException, IOException {
	
		Driver driverInfo = (Driver) session.getAttribute("driverSession");
		m.addAttribute("driverInfo", driverDao.getDriverById(driverInfo.getDriverId()));
		

		List<Driver> driverTripList = driverDao.getDesiredDriverTrip(driver);
		m.addAttribute("driver", new Driver());
		m.addAttribute("flag", 1);
		m.addAttribute("driverTripList", driverTripList);
		m.addAttribute("desiredDate", driver.getDesiredDate());
		return "driver/driverPage";

	}

	@RequestMapping("/allAssignedListForm")
	public String allAssignedListForm(Model m, HttpSession session) throws NoSuchAlgorithmException, IOException {

		Driver driver = (Driver) session.getAttribute("driverSession");
		List<Driver> driverTripList = driverDao.getAllDriverTrip(driver.getDriverId());

		m.addAttribute("driver", new Driver());
		m.addAttribute("driverTripList", driverTripList);
		m.addAttribute("driverInfo", driverDao.getDriverById(driver.getDriverId()));
		m.addAttribute("flag", 0);
		m.addAttribute("currentDate", currentDate);

		return "driver/driverPage";

	}

	@RequestMapping("/driverListForm")
	public String showDriverListForm(Model m) {
		m.addAttribute("driver", new Driver());
		m.addAttribute("flag", 0);

		List<Driver> list = driverDao.getDrivers();

		m.addAttribute("driverList", list);
		m.addAttribute("currentDate", currentDate);
		return "manager/driver/driverList";
	}

	@RequestMapping("/allDriverListForm")
	public String showAllDriverListForm(Model m, HttpSession httpSession) {
		m.addAttribute("driver", new Driver());
		m.addAttribute("flag", 0);

		List<Driver> list = driverDao.getDrivers();

		m.addAttribute("driverList", list);
		m.addAttribute("currentDate", currentDate);
		return "manager/driver/driverList";
	}

	@RequestMapping(value = "/availableDriverForm", method = RequestMethod.POST)
	public String showDesiredDriverListForm(@ModelAttribute("driver") Driver driver, Model m) {
		m.addAttribute("driver", new Driver());
		m.addAttribute("desiredDate", driver.getDesiredDate());
		m.addAttribute("flag", 1);

		List<Driver> list = driverDao.getDesiredDrivers(driver.getDesiredDate());
		m.addAttribute("driverList", list);
		return "manager/driver/driverList";
	}

	@RequestMapping("/driverForm")
	public String showDriverAddForm(Model m) {
		m.addAttribute("driver", new Driver());
		return "manager/driver/driverAddForm";
	}

	@RequestMapping(value = "/saveDriver", method = RequestMethod.POST)
	public String saveDriver(@ModelAttribute("driver") Driver driver, RedirectAttributes reAtt)
			throws NoSuchAlgorithmException, IOException {

		int i = driverDao.checkDriverDuplicate(driver);

		if (i > 0) {
			String message = "Already exist email for driver registeration!";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag", 0);
			return "redirect:/driverListForm";
		} else {
			driverDao.saveDriver(driver);
			String message = "Successfully create new Driver";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag", 1);
			return "redirect:/driverListForm";
		}
	}

	@RequestMapping(value = "/viewDriver/{id}", method = RequestMethod.GET)
	public String viewDriver(@PathVariable int driverId, Model m) {
		Driver driver = driverDao.getDriverById(driverId);
		m.addAttribute("driver", driver);
		return "manager/driver/driverViewForm";
	}

	@RequestMapping(value = "/deleteDriver/{driverId}", method = RequestMethod.GET)
	public String deleteDriver(@PathVariable int driverId, RedirectAttributes reAtt) {

		int i = driverDao.confirmDriverForDelete(driverId);

		if (i > 0) {
			String message = "Can't delete this driver,Already used in Inuse!";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag", 0);
			return "redirect:/driverListForm";
		} else {
			driverDao.deleteDriver(driverId);
			String message = "Successfully delete driver.";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag", 1);
			return "redirect:/driverListForm";
		}
	}

	@RequestMapping("/driverProfile")
	public String showDriverProfileForm(Model m, HttpSession httpSession) throws NoSuchAlgorithmException, IOException {
		Driver driver = (Driver) httpSession.getAttribute("driverSession");
		Driver driverInfo = driverDao.getDriverById(driver.getDriverId());

		m.addAttribute("driver", driverInfo);
		m.addAttribute("driverUpdate", new Driver());
		return "driver/driverProfile";
	}

	@RequestMapping(value = "/driverProfileUpdate", method = RequestMethod.POST)
	public String driverProfileUpdate(@ModelAttribute("driver") Driver driver, Model m, RedirectAttributes reAtt)
			throws NoSuchAlgorithmException, IOException {
		if (driverDao.updateDriverInfo(driver) == 1) {
			String message = "Successfully Update profile";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag", 1);
			return "redirect:driverProfile";
		} else {
			String message = "Can't update";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag", 0);
			return "redirect:driverProfile";
		}

	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("driverUpdate") Driver driver, Model m, RedirectAttributes reAtt)
			throws NoSuchAlgorithmException, IOException {

		String newPassword = driver.getNewPassword();
		String confirmPassword = driver.getConfirmPassword();

		System.out.println(driver.getDriverId());
		boolean result = newPassword.equals(confirmPassword);
		System.out.println(driver.getDriverPassword());
		System.out.println(newPassword);
		System.out.println(confirmPassword);

		if (driverDao.authenticateDriver(driver) == 1) {
			if (result) {
				driverDao.updateDriverPassword(driver);
				String message = "Successfully Update password";
				reAtt.addFlashAttribute("message", message);
				reAtt.addFlashAttribute("resultFlag", 1);
				return "redirect:driverProfile";
			} else {
				String message = "Doesn't match password!";
				reAtt.addFlashAttribute("message", message);
				reAtt.addFlashAttribute("resultFlag", 0);
				return "redirect:driverProfile";
			}
		} else {
			String message = "Wrong old passwod";
			reAtt.addFlashAttribute("message", message);
			reAtt.addFlashAttribute("resultFlag", 0);
			return "redirect:driverProfile";
		}
	}

	@RequestMapping("/driverSignOut")
	public String driverSignOut(HttpSession session, Model m) {

		session.invalidate();
		session.setMaxInactiveInterval(1);

		m.addAttribute("manager", new Manager());
		m.addAttribute("driver", new Driver());
		return "manager/login";
	}
}
