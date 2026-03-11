package com.java.problems;

import java.util.Scanner;

public class small_Problems {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter N value : ");
        byte n = sc.nextByte();
        // printing 1 to N
        System.out.println("from 1 to "+n+"  : ");
        for (byte i=1;i<=n;i++){
            System.out.print(i+" ");
        }

        System.out.println("From "+n+" to 1 : ");
        // printing N to 1
        for (byte i=n;i>=1;i--){
            System.out.print(i+" ");
        }
        System.out.println("\n");
        // Printing Even Numbers
        System.out.println("Even numbers from 1 To "+n+" : ");
        for (byte i=1;i<=n;i++){
            if (i%2==0){             // for odd numbers in if condition  replace == with !=
                System.out.print(i+" ");
            }
        }
        System.out.println("\n"+n+" table : ");
        // printing table of a given number
        for (byte i=1;i<=n;i++){
            System.out.println(n+"*"+i+"="+(n*i));
        }
//       Sum Of N Natural Numbers
        byte sum=0;
        for (byte i=1;i<=n;i++){
            sum+=i;
        }
        System.out.println("\n Sum of First "+n+" Natural Numbers : "+sum);
//        System.out.print(sum);
        //sum of n even numbers
        sum=0;
        for (byte i=1;i<=n;i++){
            if(i%2==0){                //for odd numbers replace == with !=
                sum+=i;
            }
        }
        System.out.println("sum of even numbers from 1 to "+n+" is : "+sum);

    }
}
