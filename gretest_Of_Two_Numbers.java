package com.java.problems;

import java.util.Scanner;

public class gretest_Of_Two_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers : ");
        int a= sc.nextInt();
        int b=sc.nextInt();
        if(a>b){
            System.out.println(a+" is larger number.");
        }else{
            System.out.println(b+" is larger number.");
        }
    }
}
