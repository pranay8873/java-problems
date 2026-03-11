package com.java.problems;

import java.util.Scanner;

public class right_angle_triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No.of Lines in Triangle : ");
        byte lines= sc.nextByte();
        for (byte row=1;row<=lines;row++){
            for (byte column=1;column<=row;column++){
               // System.out.print("* ");
                System.out.print(column+" ");  // for printing number triangle
            }
            System.out.println("\n");
        }
    }
}
