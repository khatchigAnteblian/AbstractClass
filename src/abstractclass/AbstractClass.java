/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package abstractclass;

/**
 *
 * @author 345983704
 */

import java.util.ArrayList;
import java.util.Scanner;

public class AbstractClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Payroll pr = new Payroll();
        Scanner sc = new Scanner(System.in);
        while (true) {
            // Ask user for a command and run selected command.
            System.out.println("Enter 0-10 to run command.\nType \"help\" to see commands.\nType \"quit\" to exit.");
            System.out.print(":> ");
            String choice = sc.nextLine();
            // Exit when user types quit
            if (choice.equals("quit")) {
                break;
            }
            switch (choice) {
                case "help": help();
                             break;
                case "0":
                             System.out.print("Enter Filename: ");
                             pr.loadStaffList(sc.nextLine());
                             break;
                case "1":
                             System.out.print("Enter Filename: ");
                             pr.saveStaffList(sc.nextLine());
                             break;
                case "2":
                             pr.listAllEmployee();
                             break;
                case "3":
                             System.out.print("Enter Employee Number: ");
                             String num = sc.nextLine();
                             System.out.print("Enter Sick Days Taken: ");
                             float sick = sc.nextFloat();
                             sc.nextLine();
                             pr.enterSickDay(num, sick);
                             break;
                case "4":
                             pr.printAllPayStubs();
                             break;
                case "5":
                             pr.averageSalary();
                             break;
                case "6":
                             pr.averageHourlyRate();
                             break;
                case "7":
                             pr.mostAbsentFullTime();
                             break;
                case "8":
                             pr.mostAbsentPartTime();
                             break;
                case "9":
                             pr.yearlySickDayReset();
                             break;
                case "10":
                             pr.monthlySickDayReset();
                             break;
            }
        }
        System.out.println("\nGoodbye!\n");
    }

    public static void help() {
        // Help message to print to user
        System.out.println("\nCommands:");
        System.out.println("0 - Load Stafflist from file");
        System.out.println("1 - Save Stafflist to file");
        System.out.println("2 - List all employees");
        System.out.println("3 - Update sick day information by employee number");
        System.out.println("4 - Print all paystubs");
        System.out.println("5 - Print average salary of Full-Time employees");
        System.out.println("6 - Print average hourly rate of Part-Time employees");
        System.out.println("7 - Print Full-Time employee with least sick days left");
        System.out.println("8 - Print Part-Time employee with most sick days taken");
        System.out.println("9 - Reset sick days for Full-Time employees");
        System.out.println("10 - Reset sick days for Part-Time employees");
        System.out.println();
    }
    
}
