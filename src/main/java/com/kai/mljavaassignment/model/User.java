package com.kai.mljavaassignment.model;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {
    @Id
    @Column
    private int id;

    @Column
    private String email;

    @ManyToMany
    @JoinTable(
        name = "user_features",
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    Set<Feature> features;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }

    public boolean hasFeatureAccess(String feature) {
        Iterator<Feature> itr = this.features.iterator();
        boolean hasAccess = false;
        while (itr.hasNext()) {
            if (itr.next().getName().equals(feature)) hasAccess = true;
        }
        return hasAccess;
    }
}
