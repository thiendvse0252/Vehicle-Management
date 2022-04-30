/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author nguye
 */
public class Vehicle {

    protected String id;
    protected String name;
    protected String color;
    protected double price;
    protected String brand;

    //Contructors
    public Vehicle() {
    }

    public Vehicle(String id, String name, String color, double price, String brand) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    //Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    //Setter    
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + color + "," + price + "," + brand;
    }

}
