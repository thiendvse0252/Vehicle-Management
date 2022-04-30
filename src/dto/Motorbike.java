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
public class Motorbike extends Vehicle {

    protected double speed;
    protected boolean requireLicense;

    public Motorbike() {
    }

    public Motorbike(String id, String name, String color, double price, String brand, double speed, boolean requireLicense) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.requireLicense = requireLicense;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean isRequireLicense() {
        return requireLicense;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setRequireLicense(boolean requireLicense) {
        this.requireLicense = requireLicense;
    }

    public String sound() {
        return "Tin tin tin";
    }

    public void makeSound() {
        System.out.printf("%10s", sound());
    }    

    @Override
    public String toString() {
        return super.toString() + "," + speed + "," + requireLicense;
    }
}
