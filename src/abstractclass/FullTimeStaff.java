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
    
    public FullTimeStaff(String emNum, String first, String last, double salary, float sickLeft) {
        super(emNum, first, last);
        this.yearlySalary = salary;
        this.sickDaysLeft = sickLeft;
    }
    

    public double pay() {
        return this.yearlySalary / 12;
    }

    public void deductSickDay(float sickDaysTaken) {
        if (this.sickDaysLeft - sickDaysTaken < 0) {
            System.out.println("Not enough sick days left! Only " + this.sickDaysLeft + " days remaining!");
        } else {
            this.sickDaysLeft -= sickDaysTaken;
        }
    }

    public void resetSickDay() {
        this.sickDaysLeft = this.yearlySickDay;
    }

    public void printPayStub() {
        System.out.println(this.pay());
    }
    
    public FullTimeStaff compareToSickDay(FullTimeStaff other) {
        return this.sickDaysLeft > other.sickDaysLeft ? this : other;
    }
    
    public String toString() {
        return super.toString() + "\nTitle: " + this.title;
    }
}
