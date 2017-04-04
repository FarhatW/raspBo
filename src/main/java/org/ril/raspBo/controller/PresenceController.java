package org.ril.raspBo.controller;

import org.ril.raspBo.model.Groupe;
import org.ril.raspBo.model.Presence;
import org.ril.raspBo.model.User;
import org.ril.raspBo.model.UserHasGroupe;
import org.ril.raspBo.service.ServicesGroupe;
import org.ril.raspBo.service.ServicesPresence;
import org.ril.raspBo.service.ServicesUser;
import org.ril.raspBo.service.ServicesUserhasGroupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gamer on 28/03/2017.
 */
@Controller
public class PresenceController {


    @Autowired
    private ServicesPresence servicesPresence;
    @Autowired
    private ServicesGroupe servicesGroupe;
    @Autowired
    private ServicesUser serviceUser;

    @Autowired
    private ServicesUserhasGroupe servicesUserhasGroupe;


    @RequestMapping(value =  { "/", "/presence**" }, method = RequestMethod.GET, headers = "Accept=application/json")
    public String defaultPage(Model model) {

        model.addAttribute("listOfGroupes", this.servicesGroupe.getAll());
        model.addAttribute("presence", new Presence());
        return "presence";
    }

    @RequestMapping(value = "/getPresence", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getUserByGroup(@RequestParam("groupe_id") int id, Model model) {
        model.addAttribute("listOfGroupes", this.servicesGroupe.getAll());
       model.addAttribute("listOfUser", getByGroup(String.valueOf(id)));
        return "presence";
    }

    private List<Presence> getByGroup(String group_id) {
        List<UserHasGroupe> userHasGroupes  =  servicesUserhasGroupe.getAll();
        List<Presence> userList = servicesPresence.getAll();

        List<UserHasGroupe> groupes = new ArrayList<>();
        for (UserHasGroupe item:userHasGroupes) {
            if (item.getGroupe_id().equals(group_id))
                groupes.add(item);
        }

        List<Presence> users =  new ArrayList<>();
        for (UserHasGroupe _item:groupes) {
            for (Presence _user :userList) {
                if (_item.getUser_id() == _user.getUser().getId())
                    users.add(_user);
            }
        }
        return users;
    }
}
