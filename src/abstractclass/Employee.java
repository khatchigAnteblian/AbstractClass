/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass;

/**
 *
 * @author 345983704
 */
public abstract class Employee {
    private String employeeNumber;
    private String firstName;
    private String lastName;
    
    public Employee(String eNum, String first, String last) {
        this.employeeNumber = eNum;
        this.firstName = first;
        this.lastName = last;
    }
    
    public String toString() {
        return "EmployeeNum: " + this.employeeNumber + "\nName: " + this.firstName + " " + this.lastName;
    }
    
    public abstract double pay();
    public abstract void deductSickDay(float sickDaysTaken);
    public abstract void resetSickDay();
    public abstract void printPayStub();
}
