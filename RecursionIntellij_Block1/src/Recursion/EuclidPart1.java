package Recursion;

import java.util.Scanner;

public class EuclidPart1 {
    public static int recursiveRuns1 = 0;
    public static Scanner numscan = new Scanner(System.in);

    public static void main(String[] args) {
        int f = -1;
        while(f < 0) {
            System.out.println("Enter First #");
            f = numscan.nextInt();
        }
        int s = -1;
        while(s < 0) {
            System.out.println("Enter Second #");
            s = numscan.nextInt();
        }
        System.out.println("The greatest common denominator of "+ f + " and "+ s + " is " + method1(f,s));
        System.out.println("Program complete.  The recursive function method1() ran " + recursiveRuns1 +" times");
        System.out.println("(MOD) The greatest common denominator of "+ f + " and "+ s + " is " + b(f,s));
    }//end main
    public static int method1(int f, int s){
        recursiveRuns1++;
        if(f == s){
            return s;
        } else if (f > s){
            return method1(s, f-s);
        } else {
            return method1(s,f);
        }
    }
    //shortest method used in compsci
    public static int b(int f,int s){if(f==0)return s;return b(s%f,f);}
}//end class
