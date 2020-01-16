package it.uniba.di.easyhome;

import java.util.ArrayList;
import java.util.HashMap;

public class House {
    private String name;
    private String owner;
    private HashMap<String,String> inquilini= new HashMap<>();
   private HashMap<String,String> bills=new HashMap<>();

    public House(){}

   /* public void addBill(String type, double tot, String descr,String expiration,boolean pay){
        bollette.add(new Bill(type,tot,descr,expiration,pay));
    }*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public House(String nome, String u){
        this.name=nome;
        this.owner=u;
    }

}
