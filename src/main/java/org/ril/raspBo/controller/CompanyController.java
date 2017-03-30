package org.ril.raspBo.controller;

import org.ril.raspBo.model.Company;
import org.ril.raspBo.service.ServicesCompany;
import org.ril.raspBo.service.ServicesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Gamer on 28/03/2017.
 */
@Controller
public class CompanyController {

    @Autowired
    private ServicesCompany servicesCompany;

    @RequestMapping(value = "/company", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getCompany(Model model) {

        List<Company> listOfCompany = servicesCompany.getAll();
        model.addAttribute("company", new Company());
        model.addAttribute("listOfCompany", listOfCompany);
        return "company";
    }

    @RequestMapping(value = "/Company/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Company getCompanyById(@PathVariable int id) {
        return servicesCompany.getById(id);
    }

    @RequestMapping(value = "/addCompany", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addCompany(@ModelAttribute("company") Company company) {
        if(company.getId()==0)
        {
            servicesCompany.add(company);
        }
        else
        {
            servicesCompany.update(company);
        }

        return "redirect:/company";
    }

    @RequestMapping(value = "/updateCompany/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateCompany(@PathVariable("id") int id,Model model) {
        model.addAttribute("company", this.servicesCompany.getById(id));
        model.addAttribute("listOfCompany", this.servicesCompany.getAll());
        return "company";
    }

    @RequestMapping(value = "/deleteCompany/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteCompany(@PathVariable("id") int id) {
        servicesCompany.delete(id);
        return "redirect:/company";

    }
}
