package org.ril.raspBo.model;

import javax.persistence.*;

/**
 * Created by Gamer on 28/03/2017.
 */
@Entity
@Table(name= "classroom_has_user")
public class ClassroomHasUser {

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="date")
    private String date;


    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
