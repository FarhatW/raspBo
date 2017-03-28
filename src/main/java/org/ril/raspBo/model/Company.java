package org.ril.raspBo.model;

import javax.persistence.*;

/**
 * Created by Gamer on 28/03/2017.
 */
@Entity
@Table(name= "company")
public class Company {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String name;

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
}
