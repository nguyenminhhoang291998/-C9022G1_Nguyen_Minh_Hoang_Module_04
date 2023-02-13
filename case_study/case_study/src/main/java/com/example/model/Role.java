package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role {
    @Id
    private int id;

    @Column(columnDefinition = "varchar(45)")
    private String name;

    @ManyToMany(mappedBy = "roleSet")
    private Set<User> userSet;

    public Role() {
    }

    public Role(int id, String name, Set<User> userSet) {
        this.id = id;
        this.name = name;
        this.userSet = userSet;
    }

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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
