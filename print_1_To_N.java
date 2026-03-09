package com.java.problems;

import java.util.Scanner;

public class print_1_To_N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N Value : ");
        int n=sc.nextInt();
        int i=1;
        while (i<=n){
            System.out.println(i);
            i+=1;
        }
    }
}
