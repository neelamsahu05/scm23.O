package com.TemplateUsingThymbleaf.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TemplateUsingThymbleaf.Entity.Employee;
import com.TemplateUsingThymbleaf.Service.EmpService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empservice;

	@GetMapping("/")
	public String home(Model model) {
		List<Employee> emp =  empservice.getAllEmp();
		
		model.addAttribute("emp",emp);
		
		return "index";
	}
	
	@GetMapping("/home")
	 public String homeAdd() {
		
		 return "redirect:/";
	 }
	
	@GetMapping("/addEmp")
	public String AddEmp() {
		return "add_emp";
	}
	
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute("employee") Employee employee,HttpSession session) {
		 System.out.println(employee);
		 empservice.addEmp(employee);
		 session.setAttribute("msg", "added successfully..");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public  String Editpage(@PathVariable int id, Model model) {
		
	Employee emp=	empservice.EdidEmp(id);
		model.addAttribute("emp",emp);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute("employee") Employee employee,HttpSession session) {
		
		 empservice.addEmp(employee);
		 session.setAttribute("msg", " emp updated successfully..");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String  Deletemp(@PathVariable int id, HttpSession session) {
		
		empservice.Deletemp(id);
		session.setAttribute("msg", " Emp Delete successfully..");
		return "redirect:/";
	}
	
}
