package org.ril.raspBo.controller;

import org.ril.raspBo.model.Groupe;
import org.ril.raspBo.service.ServicesGroupe;
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
public class GroupeController {

    @Autowired
    private ServicesGroupe servicesGroupe;

    @RequestMapping(value = "/groupes", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getGroupes(Model model) {

        List<Groupe> listOfGroupes = servicesGroupe.getAll();
        model.addAttribute("groupes", new Groupe());
        model.addAttribute("listOfGroupes", listOfGroupes);
        return "groupes";
    }

    @RequestMapping(value = "/groupes/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Groupe getGroupesById(@PathVariable int id) {
        return servicesGroupe.getById(id);
    }

    @RequestMapping(value = "/addGroupes", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addCountry(@ModelAttribute("groupes") Groupe groupe) {
        if(groupe.getId()==0)
        {
            servicesGroupe.add(groupe);
        }
        else
        {
            servicesGroupe.update(groupe);
        }

        return "redirect:/groupes";
    }

    @RequestMapping(value = "/updateGroupes/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateCountry(@PathVariable("id") int id,Model model) {
        model.addAttribute("groupes", this.servicesGroupe.getById(id));
        model.addAttribute("listOfGroupes", this.servicesGroupe.getAll());
        return "groupes";
    }

    @RequestMapping(value = "/deleteGroupes/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteCountry(@PathVariable("id") int id) {
        servicesGroupe.delete(id);
        return "redirect:/groupes";

    }

}
