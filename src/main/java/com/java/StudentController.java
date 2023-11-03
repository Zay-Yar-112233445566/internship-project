package com.java;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	@RequestMapping("/valid")
	public String display(Model m) {
		m.addAttribute("student", new Student());
		return "viewpage";
	}

	@RequestMapping("/submit")
	public String submitForm(@Valid @ModelAttribute("student") Student st, BindingResult br) {
		if (br.hasErrors()) {
			return "viewpage";
		} else {
			return "final";
		}
	}
}