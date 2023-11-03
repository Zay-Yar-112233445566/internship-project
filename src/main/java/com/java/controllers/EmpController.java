package com.java.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.java.beans.Emp;
import com.java.dao.EmpDao;

@Controller
public class EmpController {

	@Autowired
	EmpDao empDao;//will inject dao from XML file
	
	/*It displays a form to input data, here "command" is a reserved request attribute 
	 *which is used to display object data into form 
	 */ 

	@RequestMapping("/empform")
	public String showform(Model m) {
		m.addAttribute("command",new Emp());
		return "empform";
	}
	
	 /*It saves object into database. The @ModelAttribute puts request data 
	 * into model object. You need to mention RequestMethod.POST method 
	 * because default request is GET*/ 

	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("emp")Emp emp) {
		empDao.save(emp);
		return"redirect:/viewemp";//will redirect to viewemp request mapping 
	}
	
	@RequestMapping("/viewemp")
	public String viewemp(Model m) {
		List<Emp> list=empDao.getEmployees();
		m.addAttribute("list",list);
		return "viewemp";
	}
	
	@RequestMapping(value="/editemp/{id}")
	public String edit(@PathVariable int id,Model m) {
		Emp emp=empDao.getEmpById(id);
		m.addAttribute("command", emp);
		return "empeditform";
		}
	
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public String eidtsave(@ModelAttribute("emp") Emp emp) {
		empDao.update(emp);
		return "redirect:/viewemp";
	}
	
	@RequestMapping(value="/deleteemp/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		empDao.delete(id);
		return "redirect:/viewemp";
	}
	
	@RequestMapping(value="/viewempbyId/{pageid}") 
	 public String editByPageId(@PathVariable int pageid,Model m){ 
	 int total=5; 
	 if(pageid==1){} 
	 else{ 
	 pageid=(pageid-1)*total+1; 
	 } 
	 System.out.println(pageid); 
	 List<Emp> list=empDao.getEmployeesByPage(pageid,total); 
	 m.addAttribute("list", list); 
	 return "viewempnew"; 
	 } 

}
