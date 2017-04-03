package org.ril.raspBo.model;

import javax.persistence.*;

/**
 * Created by Gamer on 03/04/2017.
 */
@Entity
@Table(name= "user_has_groupe")
public class UserHasGroupe {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name= "user_id")
    private String user_id;

    @Column(name= "groupe_id")
    private String groupe_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getGroupe_id() {
        return groupe_id;
    }

    public void setGroupe_id(String groupe_id) {
        this.groupe_id = groupe_id;
    }
}
