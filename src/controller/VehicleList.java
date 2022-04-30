package controller;

import dbo.I_FileManager;
import dbo.VehicleFileManager;
import dto.Vehicle;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * This is comment, do not delete 2021.11.30
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class VehicleList extends ArrayList<Vehicle> implements I_List {

    public VehicleList() {
        super();
    }

    @Override
    public ArrayList<Vehicle> getListVehicle() {
        return (ArrayList<Vehicle>) this.clone();
    }

    @Override
    public void loadVehicle() throws Exception {
        I_FileManager file = new VehicleFileManager();
        try {
            if (file.checkFile()) {
                this.clear();
                ArrayList arr = file.readFile();
                this.addAll(arr);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void storeVehicle() throws Exception {
        I_FileManager file = new VehicleFileManager();
        try {
            file.writeFile(this);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) throws Exception {
        try {
            this.add(vehicle);
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public boolean deleteVehicle(Vehicle vehicle) throws Exception {
        try {
            this.remove(vehicle);
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public boolean checkVehicleID(String vehicleId) throws Exception {
        int size = this.size();
        for (int i = 0; i < size; i++) {
            if (this.get(i).getId().equalsIgnoreCase(vehicleId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Vehicle getVehicleByID(String vehicleId) throws Exception {
        int size = this.size();
        for (int i = 0; i < size; i++) {
            if (this.get(i).getId().equalsIgnoreCase(vehicleId)) {
                return this.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Vehicle> searchVehicle(String type, String searchKey) throws Exception {
        try {
            ArrayList<Vehicle> result;
            if (type.equalsIgnoreCase("id")) {
                Vehicle vehicle = searchVehicleByID(searchKey);
                if (vehicle == null) {
                    result = null;
                } else {
                    result = new ArrayList<>();
                    result.add(vehicle);
                }
            } else {
                result = searchVehicleByName(searchKey);
            }
            return result;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private Vehicle searchVehicleByID(String id) {
        int size = this.size();
        if (size == 0) {
            return null;
        } else {
            for (int i = 0; i < size; i++) {
                if (this.get(i).getId().equalsIgnoreCase(id)) {
                    return this.get(i);
                }
            }
            return null;
        }
    }

    private ArrayList<Vehicle> searchVehicleByName(String name) {
        ArrayList<Vehicle> arr = null;
        int size = this.size();
        if (size == 0) {
            return arr;
        } else {

            for (int i = 0; i < size; i++) {
                if (this.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                    if (arr == null) {
                        arr = new ArrayList<>();
                    }
                    arr.add(this.get(i));
                }
            }
        }
        return arr;
    }
}
