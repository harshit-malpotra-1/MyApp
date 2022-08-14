package org.example.controller;
import org.example.entities.Milk;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import javax.persistence.Query;

public class PopulateMilk {

    List<Milk> milkList = null;
    PopulateMilk(Session session){
        Query q = session.createQuery("FROM Milk");
        milkList = q.getResultList();

        /*for (Milk item:milkList) {
            System.out.println(item);
        }*/
    }
    public Milk getIdByName(String name){
        int size = milkList.size();
        Milk milk= null;
        for (int i = 0;i<size;i++){
            if(milkList.get(i).getName().equals(name)){
                System.out.println(milkList.get(i).getId());
                milk = milkList.get(i);
                break;
            }
        }
        return milk;
    }

}
