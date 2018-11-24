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
        while (true) {
            System.out.println("Enter 0-10 to run command.\nType \"help\" to see commands.\nType \"quit\" to exit.");
        }
    }

    public static void help() {
        System.out.println()
    }
    
}
