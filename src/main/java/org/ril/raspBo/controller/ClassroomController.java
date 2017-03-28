package org.ril.raspBo.controller;

import org.ril.raspBo.service.ServicesClassroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Gamer on 28/03/2017.
 */
@Controller
public class ClassroomController {

    @Autowired
    private ServicesClassroom servicesClassroom;

}
