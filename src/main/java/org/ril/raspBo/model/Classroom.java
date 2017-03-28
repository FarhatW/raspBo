package org.ril.raspBo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gamer on 28/03/2017.
 */
@Entity
@Table(name= "classroom")
public class Classroom {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String name;

    @Column(name="addMac")
    private String addMac;

    @ManyToOne
    @JoinColumn(name = "Site_id")
    private Site site;


    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name= "classroom_has_user", joinColumns=@JoinColumn(name= "user_id", referencedColumnName="id"))
    private List<User> userArrayList =  new ArrayList<>();


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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
