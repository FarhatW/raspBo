package org.ril.raspBo.controller;

import org.ril.raspBo.model.Classroom;
import org.ril.raspBo.model.Site;
import org.ril.raspBo.service.ServicesClassroom;
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
    private ServicesClassroom servicesClassroom;

    @Autowired
    private ServicesSite servicesSite;


    @RequestMapping(value = "/classRoom", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getClassRoom(Model model) {

        List<Classroom> listOfClassRoom = servicesClassroom.getAll();
        List<Site> listOfSites = servicesSite.getAll();
        model.addAttribute("classRoom", new Classroom());
        model.addAttribute("listOfClassRoom", listOfClassRoom);
        model.addAttribute("listOfSites", listOfSites);
        return "classRoom";
    }

    @RequestMapping(value = "/classRoom/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Classroom getClassRoomById(@PathVariable int id) {
        return servicesClassroom.getById(id);
    }

    @RequestMapping(value = "/addClassRoom", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addClassRoom(@ModelAttribute("classRoom") Classroom classroom) {
        if(classroom.getId()==0)
        {
            servicesClassroom.add(classroom);
        }
        else
        {
            servicesClassroom.update(classroom);
        }

        return "redirect:/classRoom";
    }

    @RequestMapping(value = "/updateClassRoom/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateClassRoom(@PathVariable("id") int id,Model model) {
        model.addAttribute("classRoom", this.servicesClassroom.getById(id));
        model.addAttribute("listOfClassRoom", this.servicesClassroom.getAll());
        return "classRoom";
    }

    @RequestMapping(value = "/deleteClassRoom/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteClassRoom(@PathVariable("id") int id) {
        servicesClassroom.delete(id);
        return "redirect:/classRoom";

    }
}
