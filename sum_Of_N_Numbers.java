package com.java.problems;

import java.util.Scanner;

public class sum_Of_N_Numbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter N value : ");
        int N= sc.nextInt();
        int sum=0;
        int i=1;
        while (i<=N){
            sum+=i;
            i+=1;
        }
        System.out.println("Sum Of "+N+" Numbers Is : "+sum);
    }
}
