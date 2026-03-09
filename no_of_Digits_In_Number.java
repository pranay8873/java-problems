package com.java.problems;

import java.util.Scanner;

public class no_of_Digits_In_Number {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Number : ");
        int N= sc.nextInt();
        int n=N;
        int count=0;
        while(N>0){
            N=N/10;
            count+=1;
        }
        System.out.println("No.of Digits In "+n+" Are : "+count);
    }
}
