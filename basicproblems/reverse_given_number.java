package com.java.problems.basicproblems;

import java.util.Scanner;

public class reverse_given_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Number : ");
        int n= sc.nextInt();
        int num=n;
        int reverse=0;
        while (n>0){
            int digit = n%10;
            reverse=reverse*10+digit;
            n=n/10;
        }
        System.out.println("Reversed Number Is : "+reverse);
        if(reverse == num ){
            System.out.println(num+" Is A Palindrome Number.");
        }else{
            System.out.println(num+" Is Not A Palindrome Number.");
        }
    }
}
