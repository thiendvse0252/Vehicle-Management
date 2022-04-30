package controller;

import dto.Vehicle;
import java.util.ArrayList;

/* Interface for a group of objects
 */
/**
 *
 * @author Hoa Doan
 */
public interface I_List {
    // your code here

    public void loadVehicle() throws Exception;

    public void storeVehicle() throws Exception;

    public boolean addVehicle(Vehicle vehicle) throws Exception;

    public boolean deleteVehicle(Vehicle vehicle) throws Exception;
    
    public boolean checkVehicleID(String vehicleId) throws Exception;
    
    public Vehicle getVehicleByID(String vehicleId) throws Exception;

    public ArrayList<Vehicle> searchVehicle(String type, String searchKey) throws Exception;

    public ArrayList<Vehicle> getListVehicle();
}
