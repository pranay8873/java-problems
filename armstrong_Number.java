package com.java.problems;

import java.util.Scanner;

public class armstrong_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number : ");
        int n= sc.nextInt();
        int digit=0;
        int sum=0;
        int original=n;
        int count =0;
        int temp =n;
        while (n>0){
            n=n/10;
            count +=1;
        }
        while (temp>0){
            digit =temp%10;
            sum+=Math.pow(digit,count);
            temp=temp/10;
        }
        if (sum==original){
            System.out.println(original+" Is an Armstrong Number ");
        }else {
            System.out.println(original+" Is Not An Armstrong Number ");
        }

    }
}
