package org.ril.raspBo.model;

import javax.persistence.*;

/**
 * Created by Gamer on 28/03/2017.
 */
@Entity
@Table(name="groupe")
public class Groupe {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String first_name;

    @Column(name= "started_at")
    private String started_at;

    @Column(name= "end_at")
    private String end_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }
}
