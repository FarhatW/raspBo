package org.ril.raspBo.controller;

import org.ril.raspBo.model.ClassRoom;
import org.ril.raspBo.model.Site;
import org.ril.raspBo.service.ServicesClassRoom;
import org.ril.raspBo.service.ServicesSite;
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
public class ClassroomController {

    @Autowired
    private ServicesClassRoom servicesClassRoom;

    @Autowired
    private ServicesSite servicesSite;


    @RequestMapping(value = "/classRoom", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getClassRoom(Model model) {

        List<ClassRoom> listOfClassRoom = servicesClassRoom.getAll();
        List<Site> listOfSites = servicesSite.getAll();
        model.addAttribute("clasRoom", new ClassRoom());
        model.addAttribute("listOfClassRoom", listOfClassRoom);
        model.addAttribute("listOfSites", listOfSites);
        return "classRoom";
    }
    @RequestMapping(value = "/class/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ClassRoom getClassById(@PathVariable int id) {
        return servicesClassRoom.getById(id);
    }

    @RequestMapping(value = "/addClass", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addClass(@ModelAttribute("clasRoom") ClassRoom room) {
        if(room.getId()==0)
        {
            servicesClassRoom.add(room);

        }
        else
        {
            servicesClassRoom.update(room);
        }

        return "redirect:/classRoom";
    }

    @RequestMapping(value = "/updateClass/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateClass(@PathVariable("id") int id,Model model) {
        model.addAttribute("clasRoom", this.servicesClassRoom.getById(id));
        model.addAttribute("listOfSites", this.servicesSite.getAll());
        model.addAttribute("listOfClassRoom", this.servicesClassRoom.getAll());
        return "classRoom";
    }

    @RequestMapping(value = "/deleteClass/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteClass(@PathVariable("id") int id) {
        servicesClassRoom.delete(id);
        return "redirect:/classRoom";

    }

}
