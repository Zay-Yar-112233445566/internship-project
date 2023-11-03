package com.java;
import java.util.Scanner;

public class CountingPassStudentDoWhileFun {

    private static int p = 0;
    private static int d = 0;
    private static int c = 0;
    private static int f = 0;
    
    static Scanner scanner = new Scanner(System.in);
    static int i = 0;

    public static void input() {
        i++;
        System.out.println("Enter first subject marks for student " + i);
        int s1 = scanner.nextInt();

        System.out.println("Enter second subject marks for student " + i);
        int s2 = scanner.nextInt();
        
        result(s1, s2); // Call result() here
    }

    public static void result(int s1, int s2) {
        if ((s1 >= 40) && (s2 >= 40)) {
            if ((s1 >= 80) || (s2 >= 80)) {
                p++;
                d++;
            } else if ((s1 >= 65) && (s2 >= 65)) {
                p++;
                c++;
            } else
                p++;
        } else
            f++;
    }

    public static void display() {
        System.out.println("Total Students=" + i);
        System.out.println("Distinction Student(s) =" + d);
        System.out.println("Credit Student(s) =" + c);
        System.out.println("Total pass Student(s) =" + p);
        System.out.println("Total fail Student(s) =" + f);
    }

    public static void main(String[] args) {
        char ch = 'y';
        
        do {
            input();
            System.out.println("Another Students(y/n)?");
            ch = scanner.next().charAt(0);
        } while (ch == 'y');
        display();
    }
}
