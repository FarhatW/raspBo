package org.ril.raspBo.model;

import javax.persistence.*;

/**
 * Created by Gamer on 28/03/2017.
 */
@Entity
@Table(name="presence")
public class Presence {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name= "pointing_at")
    private String pointing_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPointing_at() {
        return pointing_at;
    }

    public void setPointing_at(String pointing_at) {
        this.pointing_at = pointing_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
