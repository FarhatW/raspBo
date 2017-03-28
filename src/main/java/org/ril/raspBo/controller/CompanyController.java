package org.ril.raspBo.controller;

import org.ril.raspBo.service.ServicesCompany;
import org.ril.raspBo.service.ServicesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Gamer on 28/03/2017.
 */
@Controller
public class CompanyController {

    @Autowired
    private ServicesCompany servicesCompany;

}
