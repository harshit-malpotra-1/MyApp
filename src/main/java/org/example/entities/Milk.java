package org.example.entities;

import javax.persistence.*;
import org.example.entities.Bill;
@Entity
public class Milk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToMany(mappedBy="Bill")
    private int id;

    private int rate;
    private String name;

    public Milk() {
    }

    public Milk(int rate, String name) {
        this.rate = rate;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "{ "+this.id+" : "+this.name+" : "+this.rate+" }";
    }
}
