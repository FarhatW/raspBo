package org.ril.raspBo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gamer on 28/03/2017.
 */
@Entity
@Table(name= "classroom")
public class ClassRoom {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String name;

    @Column(name="addMac")
    private String addMac;

    @Column(name="site_id")
    private String site_id;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddMac() {
        return addMac;
    }

    public void setAddMac(String addMac) {
        this.addMac = addMac;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

//    public Site getSite() {
//        return site;
//    }
//
//    public void setSite(Site site) {
//        this.site = site;
//    }
}
