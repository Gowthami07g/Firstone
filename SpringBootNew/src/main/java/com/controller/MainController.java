package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@Autowired
	EmployeeServiceIntf ser;

	@RequestMapping("/one")
	public String sayHello() {
		return "HELLO";
	}
	/*
	 * @RequestMapping("/two") public ModelAndView say(){ return new
	 * ModelAndView("welcome"); }
	 */

	@RequestMapping("/index")
	public ModelAndView employeereg(@ModelAttribute("emp") Employee emp) {
		/* ser.saveDetails(emp); */
		return new ModelAndView("employeereg");
	}

	@RequestMapping("/three")
	public ModelAndView save(@ModelAttribute("emp") Employee emp) {
		ser.saveDetails(emp);
		return new ModelAndView("redirect:/show");
	}

	@RequestMapping("/show")
	public ModelAndView showlist(@ModelAttribute("emp") Employee emp) {
		List<Employee> ls = ser.showlist();
		return new ModelAndView("listemployee", "list", ls);
	}

	@RequestMapping(value = "/Delete")
	public ModelAndView deleteById(HttpServletRequest request, @ModelAttribute("emp")Employee emp) {
		int id = Integer.parseInt(request.getParameter("empNo"));
		ser.deleteById(id);
		return new ModelAndView("redirect:/show");
	}
	
	@RequestMapping(value = "/Edit")
	public ModelAndView editById(HttpServletRequest request, @ModelAttribute("emp")Employee emp) {
		List<Employee> ls = ser.showlist();
		int id = Integer.parseInt(request.getParameter("empNo"));
			int id1=ser.editById(id);
			ModelAndView model=new ModelAndView("listemployee","list",ls);
			model.addObject("editCustlist",id1);
			return model;
			//return new ModelAndView("redirect:/show");
	}
	
	@RequestMapping("/update")
    public ModelAndView update(@ModelAttribute("emp")Employee emp,HttpServletRequest request)
    {
		 System.out.println(emp.getEmpName());    
         ser.update(emp);
         return new ModelAndView("redirect:/show");
    }


	
	
}
