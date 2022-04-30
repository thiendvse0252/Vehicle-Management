package viewer;

import controller.I_List;
import controller.VehicleList;
import dto.Car;
import dto.Motorbike;
import dto.Vehicle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import utils.Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* This is comment, do not delete 2021.11.31
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class VehicleManagement {

    public static void main(String args[]) {
        try {

            System.out.println("\nWelcome to Vehicle Management - @ 2022 by <Student ID - Student Name >");
            I_Menu menu = new Menu();
            I_List vehicleList = new VehicleList();
            VehicleManagement manager = new VehicleManagement();
            // ađd menu here
            menu.addItem("1. Load data from file.");
            menu.addItem("2. Add new vehicle.");
            menu.addItem("3. Update vehicle by ID.");
            menu.addItem("4. Delete vehicle ID.");
            menu.addItem("5. Search vehicle.");
            menu.addItem("6. Show vehicle list.");
            menu.addItem("7. Store data to file.");
            menu.addItem("8. Quit.");
            int choice;
            boolean cont = false;
            do {
                menu.showMenu();
                choice = menu.getChoice();
                switch (choice) {
                    case 1:
                        vehicleList.loadVehicle();
                        break;
                    case 2:
                        manager.addVehicle(vehicleList);
                        break;
                    case 3:
                        manager.updateVehicle(vehicleList);
                        break;
                    case 4:
                        manager.deleteVehicle(vehicleList);
                        break;
                    case 5:
                        manager.searchVehicle(vehicleList);
                        break;
                    case 6:
                        manager.showVehicle(vehicleList);
                        break;
                    case 7:
                        vehicleList.storeVehicle();
                        break;
                    // your code here
                    case 8:
                        cont = menu.confirmYesNo("Do you want to quit?(Y/N)");
                        break;
                }
            } while (!cont);
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }

    private int choiceSubMenuAddVehicle() {
        I_Menu menu = new Menu();
        // ađd menu here
        System.out.println("Add Vehicle Menu");
        menu.addItem("1. Add Car.");
        menu.addItem("2. Add Motorbike.");
        menu.addItem("3. Return Main menu.");
        menu.showMenu();
        int choice = menu.getChoice();
        return choice;
    }

    private void addVehicle(I_List vehicleList) throws Exception {
        try {
            boolean cont = true;
            do {
                int subChoice = choiceSubMenuAddVehicle();
                switch (subChoice) {
                    case 1:
                        addCar(vehicleList);
                        break;
                    case 2:
                        addMotorbike(vehicleList);
                        break;
                    default:
                        cont = false;
                        break;
                }
            } while (cont);
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void addCar(I_List vehicleList) throws Exception {
        try {
            System.out.println("----Create a Car vehicles----");
            //ID
            String idPattern = "^VH\\d{3}$";
            String id = "";
            boolean checkId = true;
            do {
                id = Utils.getString("Enter your vehicle ID (VHxxx):", idPattern);
                if (vehicleList.checkVehicleID(id)) {
                    System.out.print(id + " is exist. Again please!");
                } else {
                    checkId = false;
                }
            } while (checkId);

            //NAME
            String name = Utils.getString("Enter your vehicle name:");

            //COLOR        
            String color = Utils.getString("Enter your vehicle color:");

            //PRICE        
            double price = Utils.getDouble("Enter your vehicle price:");

            //BRAND       
            String brand = Utils.getString("Enter your vehicle brand:");

            //TYPE        
            String type = Utils.getString("Enter your vehicle type:");

            //YEAR           
            int year = Utils.getInt("Enter your vehicle year:", 0, 2500);

            Vehicle vehicle = new Car(id, name, color, price, brand, type, year);

            if (vehicleList.addVehicle(vehicle)) {
                System.out.println("Add vehicle success");
            } else {
                System.out.println("Add vehicle fail!!!!!");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void addMotorbike(I_List vehicleList) throws Exception {
        try {
            System.out.println("----Create a Motorbike vehicles----");
            //ID
            String idPattern = "VH\\d{3}$";
            String id = "";
            boolean checkId = true;
            do {
                id = Utils.getString("Enter your vehicle ID (VHxxx):", idPattern);
                if (vehicleList.checkVehicleID(id)) {
                    System.out.print(id + " is exist. Again please!");
                } else {
                    checkId = false;
                }
            } while (checkId);

            //NAME
            String name = Utils.getString("Enter your vehicle name:");

            //COLOR        
            String color = Utils.getString("Enter your vehicle color:");

            //PRICE        
            double price = Utils.getDouble("Enter your vehicle price:");

            //BRAND       
            String brand = Utils.getString("Enter your vehicle brand:");

            //SPEED       
            double speed = Utils.getDouble("Enter your vehicle speed:");

            //YEAR           
            boolean license = Utils.confirmYesNo("Vehicle required License? (Y/N)");

            Vehicle vehicle = new Motorbike(id, name, color, price, brand, speed, license);

            if (vehicleList.addVehicle(vehicle)) {
                System.out.println("Add vehicle success");
            } else {
                System.out.println("Add vehicle fail!!!!!");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    private int choiceSubMenuUpdateVehicle() {
        I_Menu menu = new Menu();
        // ađd menu here
        System.out.println("Update Vehicle Menu");
        menu.addItem("1. Update Vehicle.");
        menu.addItem("2. Return Main menu.");
        menu.showMenu();
        int choice = menu.getChoice();
        return choice;
    }

    private void updateVehicle(I_List vehicleList) throws Exception {
        try {
            boolean cont = true;
            do {
                int subChoice = choiceSubMenuUpdateVehicle();
                switch (subChoice) {
                    case 1:
                        String idPattern = "VH\\d{3}$";
                        String id = "";
                        boolean checkId = true;
                        do {
                            id = Utils.getString("Enter your vehicle ID (VHxxx):", idPattern);
                            if (!vehicleList.checkVehicleID(id)) {
                                checkId = Utils.confirmYesNo(id + " is none exist. Do you want to continue? (Y/N)");
                            } else {
                                checkId = false;
                            }
                        } while (checkId);
                        Vehicle vehicle = vehicleList.getVehicleByID(id);
                        if (vehicle instanceof Car) {
                            updateCar((Car) vehicle);
                        } else {
                            updateMotorbike((Motorbike) vehicle);
                        }
                        break;
                    default:
                        cont = false;
                        break;
                }
            } while (cont);
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void updateCar(Car vehicle) throws Exception {
        try {
            System.out.println("----Update a Car vehicles. The field is none update, press Enter----");

            //NAME
            vehicle.setName(Utils.updateString("Update vehicle name:", vehicle.getName()));

            //COLOR        
            vehicle.setColor(Utils.updateString("Update vehicle color:", vehicle.getColor()));

            //PRICE        
            vehicle.setPrice(Utils.updateDouble("Update vehicle price:", vehicle.getPrice()));

            //BRAND       
            vehicle.setBrand(Utils.updateString("Update vehicle brand:", vehicle.getBrand()));

            //TYPE        
            vehicle.setType(Utils.updateString("Update vehicle type:", vehicle.getType()));

            //YEAR           
            vehicle.setYearOfManufacture(Utils.updateInt("Update vehicle year:", 0, 2500, vehicle.getYearOfManufacture()));

            System.out.println("Update vehicle success");

        } catch (Exception ex) {
            System.out.println("Update vehicle fail!!!!!");
        }
    }

    private void updateMotorbike(Motorbike vehicle) throws Exception {
        try {
            System.out.println("----Update a Car vehicles. The field is none update, press Enter----");

            //NAME
            vehicle.setName(Utils.updateString("Update vehicle name:", vehicle.getName()));

            //COLOR        
            vehicle.setColor(Utils.updateString("Update vehicle color:", vehicle.getColor()));

            //PRICE        
            vehicle.setPrice(Utils.updateDouble("Update vehicle price:", vehicle.getPrice()));

            //BRAND       
            vehicle.setBrand(Utils.updateString("Update vehicle brand:", vehicle.getBrand()));

            //SPEED        
            vehicle.setSpeed(Utils.updateDouble("Update vehicle type:", vehicle.getSpeed()));

            //LICENCE           
            vehicle.setRequireLicense(Utils.updateBoolean("Update vehicle License:(Y/N)", vehicle.isRequireLicense()));

            System.out.println("Update vehicle success");

        } catch (Exception ex) {
            System.out.println("Update vehicle fail!!!!!");
        }
    }

    private int choiceSubMenuDeleteVehicle() {
        I_Menu menu = new Menu();
        // ađd menu here
        System.out.println("Show Delete Vehicle Menu");
        menu.addItem("1. Delete Vehicle.");
        menu.addItem("2. Return Main menu.");
        menu.showMenu();
        int choice = menu.getChoice();
        return choice;
    }

    private void deleteVehicle(I_List vehicleList) throws Exception {
        try {
            boolean cont = true;
            do {
                int subChoice = choiceSubMenuDeleteVehicle();
                switch (subChoice) {
                    case 1:
                        String idPattern = "VH\\d{3}$";
                        String id = "";
                        boolean checkId = true;
                        do {
                            id = Utils.getString("Enter your vehicle ID (VHxxx):", idPattern);
                            if (!vehicleList.checkVehicleID(id)) {
                                checkId = Utils.confirmYesNo(id + " is none exist. Do you want to continue? (Y/N)");
                            } else {
                                checkId = false;
                            }
                        } while (checkId);
                        Vehicle vehicle = vehicleList.getVehicleByID(id);
                        if (Utils.confirmYesNo("Are you sure to deltete vehicle? (Y/N) ")) {
                            if (vehicleList.deleteVehicle(vehicle)) {
                                System.out.println("Delete vehicle success");
                            } else {
                                System.out.println("Delete vehicle fail!!!!!");
                            }
                        }
                        break;
                    default:
                        cont = false;
                        break;
                }
            } while (cont);
        } catch (Exception ex) {
            throw ex;
        }
    }

    private int choiceSubMenuShowVehicle() {
        I_Menu menu = new Menu();
        // ađd menu here
        System.out.println("Show Vehicle Infomation Menu");
        menu.addItem("1. Show all.");
        menu.addItem("2. Show all (descending by price).");
        menu.addItem("3. Return Main menu.");
        menu.showMenu();
        int choice = menu.getChoice();
        return choice;
    }

    private void showVehicle(I_List vehicleList) throws Exception {
        try {
            boolean cont = false;
            do {
                int subChoice = choiceSubMenuShowVehicle();
                switch (subChoice) {
                    case 1:
                        showVehicleInfomation(vehicleList.getListVehicle(), 1);
                        break;
                    case 2:
                        ArrayList<Vehicle> arr = (ArrayList) vehicleList.getListVehicle().clone();
                        Comparator com = new Comparator<Vehicle>() {
                            @Override
                            public int compare(Vehicle o1, Vehicle o2) {
                                return (int) (o2.getPrice() - o1.getPrice());
                            }
                        };
                        Collections.sort(arr, com);
                        showVehicleInfomation(arr, 2);
                        break;
                    default:
                        cont = true;
                        break;
                }
            } while (cont);
        } catch (Exception ex) {
            throw ex;
        }
    }

    private int choiceSubMenuSearchVehicle() {
        I_Menu menu = new Menu();
        // ađd menu here
        System.out.println("Search Vehicle Infomation Menu");
        menu.addItem("1. Search by name(descending)");
        menu.addItem("2. Search by id.");
        menu.addItem("3. Return Main menu.");
        menu.showMenu();
        int choice = menu.getChoice();
        return choice;
    }

    private void searchVehicle(I_List vehicleList) throws Exception {
        try {
            boolean cont = false;
            do {
                int subChoice = choiceSubMenuSearchVehicle();
                String key;
                switch (subChoice) {
                    case 1:
                        key = Utils.getString("Enter name : ");
                        ArrayList<Vehicle> arr = vehicleList.searchVehicle("name", key);
                        if (arr != null) {
                            Comparator com = new Comparator<Vehicle>() {
                                @Override
                                public int compare(Vehicle o1, Vehicle o2) {
                                    return o2.getName().compareTo(o1.getName());
                                }
                            };
                            Collections.sort(arr, com);
                            showVehicleInfomation(arr, 1);
                        } else {
                            System.out.println("None Vehicle' name contains " + key);
                        }
                        break;
                    case 2:
                        key = Utils.getString("Enter name : ");
                        arr = vehicleList.searchVehicle("id", key);
                        if (arr == null) {
                            System.out.println("None Vehicle has id = " + key);
                        } else {
                            showVehicleInfomation(arr, 1);
                        }
                        break;
                    default:
                        cont = true;
                        break;
                }
            } while (cont);
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void showVehicleInfomation(ArrayList<Vehicle> arr, int type) {
        if (arr == null || arr.isEmpty()) {
            System.out.println("The VehicleList is empty.");
        } else {
            int size = arr.size();
            VehicleView view = new VehicleView();
            if (type == 1) {
                System.out.printf("%10s|%10s|%10s|%10s|%10s|%10s|%10s|\n", "ID", "NAME", "COLOR", "PRICE", "BRANCH", "TYPE/SPEED", "YEAR/LIC");
            } else {
                System.out.printf("%10s|%10s|%10s|%10s|%10s|%10s|%10s|%15s|\n", "ID", "NAME", "COLOR", "PRICE", "BRANCH", "TYPE/SPEED", "YEAR/LIC", "SOUND");
            }
            for (int i = 0; i < size; i++) {
                view.ShowInfomation(arr.get(i), type);
            }
        }
    }
}
