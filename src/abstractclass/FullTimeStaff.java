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
public class FullTimeStaff extends Employee {
    public static final int yearlySickDay = 20;
    private double yearlySalary;
    private float sickDaysLeft;
    private String title;
    
    public FullTimeStaff(String emNum, String first, String last, double salary, float sickLeft, String title) {
        super(emNum, first, last);
        this.yearlySalary = salary;
        this.sickDaysLeft = sickLeft;
        this.title = title;
    }
    

    // Return monthly salary
    public double pay() {
        return this.yearlySalary / 12;
    }

    // Deduct sick days from total if there's still sick days left
    // Print a warning message otherwise
    public void deductSickDay(float sickDaysTaken) {
        if (this.sickDaysLeft - sickDaysTaken < 0) {
            System.out.println("Not enough sick days left! Only " + this.sickDaysLeft + " days remaining!");
        } else {
            this.sickDaysLeft -= sickDaysTaken;
        }
    }

    // Reset sick days left to total
    public void resetSickDay() {
        this.sickDaysLeft = this.yearlySickDay;
    }

    // Print amount earned and sick days left for the month
    public void printPayStub() {
        System.out.println("Amount earned this month: $" + this.pay());
        System.out.println("Sick days left: " + this.sickDaysLeft);
    }
    
    // Return FullTimeStaff object with greater sickDaysLeft
    public FullTimeStaff compareToSickDay(FullTimeStaff other) {
        return this.sickDaysLeft > other.sickDaysLeft ? this : other;
    }
    
    public String toString() {
        return super.toString() + "\nTitle: " + this.title;
    }
}
