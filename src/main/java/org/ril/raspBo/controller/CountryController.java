package org.ril.raspBo.controller;

import java.security.Principal;
import java.util.List;

import org.ril.raspBo.model.Country;
import org.ril.raspBo.service.ServicesCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CountryController {

	@Autowired
	ServicesCountry servicesCountry;

	@RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCountries(Model model) {
		
		List<Country> listOfCountries = servicesCountry.getAll();
		model.addAttribute("country", new Country());
		model.addAttribute("listOfCountries", listOfCountries);
		return "country";
	}

	@RequestMapping(value = "/Country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		return servicesCountry.getById(id);
	}

	@RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCountry(@ModelAttribute("country") Country country) {
		if(country.getId()==0)
		{
			servicesCountry.add(country);
		}
		else
		{
			servicesCountry.update(country);
		}

		return "redirect:/countries";
	}

	@RequestMapping(value = "/updateCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCountry(@PathVariable("id") int id,Model model) {
		 model.addAttribute("country", this.servicesCountry.getById(id));
	        model.addAttribute("listOfCountries", this.servicesCountry.getAll());
	        return "country";
	}

	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCountry(@PathVariable("id") int id) {
		servicesCountry.delete(id);
		 return "redirect:/countries";

	}
}
