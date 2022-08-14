package org.example.controller;

import org.example.entities.Bill;
import org.example.entities.Milk;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //long currentTime= System.currentTimeMillis();



        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = null;
        Session session = null;
        try{
            factory = cfg.buildSessionFactory();

        }
        catch (Exception e){
            System.out.println("Session Factory cannot be initialized, excpetion raised\n"+e);
        }
        if (factory!=null){
            try {
                session = factory.openSession();
            }
            catch (Exception e) {
                System.out.println("Failed to open session, Exception raised:\n"+e);
            }
            if (session!=null){
                try {
                    session.beginTransaction();
                }
                catch (Exception e){
                    System.out.println("FAiled to begin Transaction,Exception Raised\n"+e);
                }
                try {
                    //PopulateMilk populateMilk = new PopulateMilk(session);
                    //Bill today = new Bill("2022-08-14",1,populateMilk.getIdByName("Gir"));
                    //System.out.println(today.getDate());
                    //session.save(today);
                    Query q = session.createQuery("FROM Bill WHERE Bill.dat");
                    List<Bill> list = q.getResultList();
                    for (Bill b:list){
                        System.out.println(b);
                    }

                    session.getTransaction().commit();
                }
                catch (Exception e){
                    System.out.println("Failed to persist, Exception\n"+e);
                }
                session.close();
            }
            factory.close();
        }
    }
}