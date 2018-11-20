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
public class AbstractClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FullTimeStaff a = new FullTimeStaff("482927908", "Hello", "World", 81456, 20.0f, "Manager");
        PartTimeStaff b = new PartTimeStaff("134689519", "John", "Doe", 70.0f, 20.0, "Cashier");
        Payroll pr = new Payroll(a, b);
        pr.enterSickDay("134689519", 2);
        pr.printAllPayStubs();
    }
    
}
