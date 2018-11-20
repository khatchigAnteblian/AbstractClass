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
public class PartTimeStaff extends Employee {
    private float numHoursAssigned;
    private double hourlyRate;
    private float sickDaysTaken = 0;
    private String title;
    
    public PartTimeStaff(String eNum, String first, String last, float numHours, double hRate, String title) {
        super(eNum, first, last);
        this.numHoursAssigned = numHours;
        this.hourlyRate = hRate;
        this.title = title;
    }
    
    // Return hourly pay based on hours worked
    public double pay() {
        double hoursWorked = this.numHoursAssigned - (this.sickDaysTaken * 8);
        return this.hourlyRate * hoursWorked;
    }
    
    // Add to sickDaysTaken
    public void deductSickDay(float amount) {
        this.sickDaysTaken += amount;
    }
    
    // Reset sick days back to zero
    public void resetSickDay() {
        this.sickDaysTaken = 0;
    }
    
    // Print hours worked and amount earned in those hours
    public void printPayStub() {
        System.out.println("Hours worked: " + (this.numHoursAssigned - (this.sickDaysTaken * 8)));
        System.out.println("Amount earned this month: $" + this.pay());
    }
    
    // Return PartTimeStaff object with greater sickDaysTaken
    public PartTimeStaff compareToSickDay(PartTimeStaff other) {
        return this.sickDaysTaken > other.sickDaysTaken ? this : other;
    }
    
    public String toString() {
        return super.toString() + "\nTitle: " + this.title;
    }
}
