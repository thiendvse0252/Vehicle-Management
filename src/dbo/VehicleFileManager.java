/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

import dto.Car;
import dto.Motorbike;
import dto.Vehicle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class VehicleFileManager implements I_FileManager {

    private final String fileName = "src/dbo/Vehicle.txt";

    @Override
    public ArrayList readFile() throws Exception {
        ArrayList result = null;
        try {
            String thisLine; // content to read each line.
            BufferedReader myInput;// create Buffer

            File f = new File(fileName);//open file
            //System.out.println(fileName);

            String fullPath = f.getAbsolutePath(); //get Fullpath of file
            //System.out.println("Fullpath: " + fullPath);

            FileInputStream file = new FileInputStream(fullPath);
            myInput = new BufferedReader(new InputStreamReader(file));
            // read line until the end of the file            
            while ((thisLine = myInput.readLine()) != null) {
                if (!thisLine.trim().isEmpty()) {
                    String[] split = thisLine.split(",");
                    // No, id , name ,color ,price ,brand
                    // type ,yearOfManufacture (Car) or speed , requireLicense (Motorbike)
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    Vehicle vehicle = null;
                    String id = split[1];
                    String name = split[2];
                    String color = split[3];
                    double price = Double.parseDouble(split[4]);
                    String brand = split[5];
                    if (split[7].equalsIgnoreCase("true") || split[7].equalsIgnoreCase("false")) {//Motorbike
                        double speed = Double.parseDouble(split[6]);
                        boolean licence = Boolean.parseBoolean(split[7]);
                        vehicle = new Motorbike(id, name, color, price, brand, speed, licence);
                    } else {//Car
                        String type = split[6];
                        int year = Integer.parseInt(split[7]);
                        vehicle = new Car(id, name, color, price, brand, type, year);
                    }
                    result.add(vehicle);
                }
            }
            myInput.close();

        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    @Override
    public void writeFile(ArrayList arr) throws Exception {
        File f;
        FileOutputStream file;
        BufferedWriter myOutput;// create Buffer    
        try {
            f = new File(fileName);//open file

            String fullPath = f.getAbsolutePath(); //get Fullpath of file
            file = new FileOutputStream(fullPath);
            myOutput = new BufferedWriter(new OutputStreamWriter(file));
            // write line until the end of the file
            for (int i = 0; i < arr.size(); i++) {
                if (i > 0) {
                    myOutput.newLine();
                }
                myOutput.write((i + 1) + "," + arr.get(i).toString());
            }
            myOutput.close();
        } catch (IOException ex) {
            throw ex;
        }
    }

    @Override
    public boolean checkFile() {
        boolean result;
        File f;
        try {
            f = new File(fileName);//open file
            result = f.exists();
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

}
