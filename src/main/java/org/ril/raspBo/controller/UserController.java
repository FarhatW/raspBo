package org.ril.raspBo.controller;

import org.ril.raspBo.model.ClassRoom;
import org.ril.raspBo.model.Company;
import org.ril.raspBo.model.Groupe;
import org.ril.raspBo.model.User;
import org.ril.raspBo.service.ServicesClassRoom;
import org.ril.raspBo.service.ServicesCompany;
import org.ril.raspBo.service.ServicesGroupe;
import org.ril.raspBo.service.ServicesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserController {

	@Autowired
	private ServicesUser serviceUser;
	@Autowired
	private ServicesGroupe servicesGroupe;
	@Autowired
	private ServicesCompany servicesCompany;
	@Autowired
	private ServicesClassRoom servicesClassRoom;

	@RequestMapping(value =  { "/", "/welcome**" }, method = RequestMethod.GET, headers = "Accept=application/json")
	public String defaultPage(Model model) {

		List<User> listOfUsers = serviceUser.getAll();
		model.addAttribute("user", new User());
		model.addAttribute("listOfUsers", listOfUsers);

		List<Groupe> listOfGroupes = servicesGroupe.getAll();
		model.addAttribute("listOfGroupes", listOfGroupes);

		List<Company> listOfCompany = servicesCompany.getAll();
		model.addAttribute("listOfCompany", listOfCompany);

		List<ClassRoom> listOfClassRoom = servicesClassRoom.getAll();
		model.addAttribute("listOfClassRoom", listOfClassRoom);


		return "users";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable int id) {
		return serviceUser.getById(id);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUser(@ModelAttribute("user") User user) {
		if(user.getId()==0)
		{
			serviceUser.add(user);

		}
		else
		{
			serviceUser.update(user);
		}

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateUser(@PathVariable("id") int id,Model model) {
		model.addAttribute("user", this.serviceUser.getById(id));

		List<Groupe> listOfGroupes = servicesGroupe.getAll();
		model.addAttribute("listOfGroupes", listOfGroupes);

		List<Company> listOfCompany = servicesCompany.getAll();
		model.addAttribute("listOfCompany", listOfCompany);

		model.addAttribute("listOfUsers", this.serviceUser.getAll());
		return "users";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCountry(@PathVariable("id") int id) {
		serviceUser.delete(id);
		return "redirect:/welcome";

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
