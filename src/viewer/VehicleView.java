/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

import dto.Car;
import dto.Motorbike;
import dto.Vehicle;

/**
 *
 * @author nguye
 */
public class VehicleView implements I_ShowInfomation<Vehicle> {

    @Override
    public void ShowInfomation(Vehicle obj, int type) {
        if (obj instanceof Car) {
            switch (type) {
                case 1:
                    System.out.printf("%10s|%10s|%10s|%10.2f|%10s|%10s|%10d|\n",
                            obj.getId(), obj.getName(), obj.getColor(),
                            obj.getPrice(), obj.getBrand(), ((Car) obj).getType(),
                            ((Car) obj).getYearOfManufacture());
                    break;
                case 2:
                    System.out.printf("%10s|%10s|%10s|%10.2f|%10s|%10s|%10d|%15s|\n",
                            obj.getId(), obj.getName(), obj.getColor(),
                            obj.getPrice(), obj.getBrand(), ((Car) obj).getType(),
                            ((Car) obj).getYearOfManufacture(), "");
                    break;
                default:
                    break;

            }
        } else if (obj instanceof Motorbike) {
            switch (type) {
                case 1:
                    System.out.printf("%10s|%10s|%10s|%10.2f|%10s|%10.2f|%10b|\n",
                            obj.getId(), obj.getName(), obj.getColor(),
                            obj.getPrice(), obj.getBrand(), ((Motorbike) obj).getSpeed(),
                            ((Motorbike) obj).isRequireLicense());
                    break;
                case 2:
                    System.out.printf("%10s|%10s|%10s|%10.2f|%10s|%10.2f|%10b|%15s|\n",
                            obj.getId(), obj.getName(), obj.getColor(),
                            obj.getPrice(), obj.getBrand(), ((Motorbike) obj).getSpeed(),
                            ((Motorbike) obj).isRequireLicense(), ((Motorbike) obj).sound());
                    break;
                default:
                    break;
            }
        }
    }
}
