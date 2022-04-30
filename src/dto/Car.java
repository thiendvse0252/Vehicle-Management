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
public class Car extends Vehicle {

    protected String type;// (sport, travel, etc.)
    protected int yearOfManufacture;

    //Contructors
    public Car() {
    }

    public Car(String id, String name, String color, double price, String brand, String type, int yearOfManufacture) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    //Getter
    public String getType() {
        return type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    //Setter
    public void setType(String type) {
        this.type = type;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    

    @Override
    public String toString() {
        return super.toString() + "," + type + "," + yearOfManufacture;
    }
}
