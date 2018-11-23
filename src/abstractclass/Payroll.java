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
import java.io.FileReader;
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
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            // Loop through employees and write each parameter to file
            for(Employee e : staffList) {
                // Check object type of employee and write appropriate data
                if (e instanceof FullTimeStaff) {
                    bw.write("Employee Type: Full-Time Staff");
                    bw.newLine();
                    bw.write("Yearly Salary: " + ((FullTimeStaff)e).getYearlySalary());
                    bw.newLine();
                    bw.write("Employee Title: " + ((FullTimeStaff)e).title);
                    bw.newLine();
                } else {
                    bw.write("Employee Type: Part-Time Staff"); 
                    bw.newLine();
                    bw.write("Hours Assigned: " + ((PartTimeStaff)e).getNumHoursAssigned());
                    bw.newLine();
                    bw.write("Hourly Rate: " + ((PartTimeStaff)e).getHourlyRate());
                    bw.newLine();
                    bw.write("Employee Title: " + ((PartTimeStaff)e).title);
                    bw.newLine();
                }

                bw.write("Employee Number: " + e.getEmployeeNumber());
                bw.newLine();
                bw.write("Employee Name: " + e.getFirstName() + " " + e.getLastName());
                bw.newLine();
                bw.newLine();
            } 
        } catch (IOException ex) {
                ex.printStackTrace();
        }
    }

    // Read employee information from file
    public ArrayList<Employee> loadStaffList(String fileName) {
        ArrayList<Employee> employees = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                // Set up variables to read later according to object type
                String emNum;
                String name;
                String title;
                double salary;
                float hours;
                double hRate;
                String type = br.readLine().split(": ")[1];
                // Check object type and read appropriate data
                if (type.equals("Full-Time Staff")) {
                    salary = Double.parseDouble(br.readLine().split(": ")[1]);
                    title = br.readLine().split(": ")[1];
                    emNum = br.readLine().split(": ")[1];
                    name = br.readLine().split(": ")[1];
                    employees.add(new FullTimeStaff(emNum, name.split(" ")[0], name.split(" ")[1], salary, 20f, title));
                } else {
                    hours = Float.parseFloat(br.readLine().split(": ")[1]);
                    hRate = Double.parseDouble(br.readLine().split(": ")[1]);
                    title = br.readLine().split(": ")[1];
                    emNum = br.readLine().split(": ")[1];
                    name = br.readLine().split(": ")[1]; 
                    employees.add(new PartTimeStaff(emNum, name.split(" ")[0], name.split(" ")[1], 25f, 18.0, title));
                }
                // Empty readline to account for empty space between each employee data
                br.readLine();
            }
        } catch(Exception e) {
            return employees;
        }
    }
}
