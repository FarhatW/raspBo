package org.ril.raspBo.controller;

import org.ril.raspBo.model.User;
import org.ril.raspBo.service.ServicesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

	@Autowired
	private ServicesUser serviceUser;

	@RequestMapping(value =  { "/", "/welcome**" }, method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView defaultPage() {
//		List<User> listOfUsers = serviceUser.getAll();
//		model.addAttribute("country", new User());
//		model.addAttribute("listOfUsers", listOfUsers);
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.setViewName("users");
		return model;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getCountryById(@PathVariable int id) {
		return serviceUser.getById(id);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCountry(@ModelAttribute("country") User country) {
		if(country.getId()==0)
		{
			serviceUser.add(country);
		}
		else
		{
			serviceUser.update(country);
		}

		return "redirect:/users";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCountry(@PathVariable("id") int id,Model model) {
		model.addAttribute("country", this.serviceUser.getById(id));
		model.addAttribute("listOfCountries", this.serviceUser.getAll());
		return "country";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCountry(@PathVariable("id") int id) {
		serviceUser.delete(id);
		return "redirect:/User";

	}




	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
							  @RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}
}
