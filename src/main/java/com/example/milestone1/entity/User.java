package com.example.milestone1.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class User implements Serializable {
    @Id
    @GeneratedValue

    @Column(name = "id")
    private Long ID;

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getID() {
        return ID;
    }

    /*
    * Method to validate user
    */
    public void validate() {}
}
