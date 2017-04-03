package org.ril.raspBo.controller;

import org.ril.raspBo.service.ServicesPresence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Gamer on 28/03/2017.
 */
@Controller
public class PresenceController {


    @Autowired
    private ServicesPresence servicesPresence;


    @RequestMapping(value =  { "/", "/presence**" }, method = RequestMethod.GET, headers = "Accept=application/json")
    public String defaultPage(Model model) {
        return "presence";
    }
}
