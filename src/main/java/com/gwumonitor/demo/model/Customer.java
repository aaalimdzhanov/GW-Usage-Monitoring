package com.gwumonitor.demo.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<Usage> usages;

    //===============================================================================//


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
