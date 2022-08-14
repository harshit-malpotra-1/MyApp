package org.example.entities;

import javax.persistence.*;

import net.bytebuddy.asm.Advice;
import org.example.entities.Milk;

import java.sql.Date;


@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Bill() {
    }
    //@Temporal(TemporalType.DATE)
    private Date date;
    private int qty;

    @ManyToOne
    @JoinColumn(name = "type_id",referencedColumnName = "id")
    private Milk type;

    public Bill(String date,int qty, Milk type) {
        //this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.date= Date.valueOf(date);
        this.qty = qty;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(String date) {
        //this.date = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.date = Date.valueOf(date);
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Milk getType() {
        return type;
    }

    public void setType(Milk type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return this.id+" : "+this.date+" : "+this.type+" : "+this.qty;
    }
}
