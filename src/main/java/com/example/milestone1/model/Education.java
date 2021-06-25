package com.example.milestone1.model;

import javax.persistence.*;

@Entity
@Table(name = "education")
public class Education {

    public Education() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String degree;
    private String name;

    public Education(Long ID, String degree, String name) {
        this.ID = ID;
        this.degree = degree;
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public String getDegree() {
        return degree;
    }

    public String getName() {
        return name;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setName(String name) {
        this.name = name;
    }
}
