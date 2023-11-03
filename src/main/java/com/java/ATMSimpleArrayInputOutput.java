package com.java;

import java.util.Scanner;

class ATM {
    private int pp, accno; // an for account no
    private long bal, wamt;

    public void set_data(int p, int ac) {
        pp = p;
        accno = ac;
    }

    public void get_data() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Account Number: ");
        accno = scanner.nextInt();
        System.out.print("Enter your Password: ");
        pp = scanner.nextInt();
    }

    public void showdata() {
        System.out.println("Your acc no: " + accno);
        System.out.println("Your password: " + pp);
    }
}

public class ATMSimpleArrayInputOutput {
    public static void main(String[] args) {
        ATM a1 = new ATM();
        a1.set_data(1234567, 7777);
        ATM[] atm = new ATM[35];
        int n = 0;
        char ans;
        System.out.println();
        do {
            System.out.println("User Account Detail for user " + (n + 1) + ":\n");
            atm[n] = new ATM();
            atm[n].get_data();
            n++;
            System.out.print("Enter another y or n?: ");
            Scanner scanner = new Scanner(System.in);
            ans = scanner.next().charAt(0);
            System.out.println();
        } while (ans != 'n');
        for (int j = 0; j < n; j++) {
            System.out.println("Your detail:");
            atm[j].showdata();
        }
        System.out.println();
    }
}

