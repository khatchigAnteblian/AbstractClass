/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author 345983704
 */
public class Payroll {
    private ArrayList<Employee> staffList = new ArrayList<>();
    
    public Payroll(Employee a, Employee b) {
        staffList.add(a);
        staffList.add(b);
    }
    
    // Loop through staffList and print employee information
    public void listAllEmployee() {
        for (Employee e : staffList) {
            System.out.println(e.toString());
        }
    }
    
    // Loop through staffList and update sick day for employee with given employee number
    public void enterSickDay(String emNum, float sickDay) {
        for(Employee e : staffList) {
            if (e.getEmployeeNumber().equals(emNum)) {
                e.deductSickDay(sickDay);
            }
        }
    }
    
    // Loop through staffList and print employee paystubs
    public void printAllPayStubs() {
        for (Employee e : staffList) {
            e.printPayStub();
        }
    }
    
    // Write employee information to file
    public void saveStaffList(String fileName) {
        for(Employee e : staffList) {
            try(BufferedWriter br = new BufferedWriter(new FileWriter(fileName))) {
                br.write(e.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
