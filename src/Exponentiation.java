// EXPONENTIATION

import java.util.Scanner;

public class Exponentiation
{
    static int RecursivePowerBest(int base, int exponent)
    {
        if(exponent == 0)
            return 1;

        if(exponent == 1)
            return base;

        if((exponent % 2) == 0)
        {
            int resultMid = RecursivePowerBest(base, (exponent / 2));
            return (resultMid * resultMid);
        }

        return (base * RecursivePowerBest(base, (exponent - 1)));
    }

    static int RecursivePower(int base, int exponent)
    {
        if(exponent == 0)
            return 1;

        if(exponent == 1)
            return base;

        return (base * RecursivePower(base, (exponent - 1)));
    }

    static int Power(int base, int exponent)
    {
        int result = 1;

        for(int i = 0; i < exponent; i++)
            result *= base;

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("EXPONENTIATION...\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base: ");
        int base = sc.nextInt();
        System.out.print("Enter the exponent: ");
        int exponent = sc.nextInt();

        System.out.println("\nThe value of " + base + "^" + exponent + " is: " + Power(base, exponent));
        System.out.println("Recursively - The value of " + base + "^" + exponent + " is: "  + RecursivePower(base, exponent));
        System.out.println("Recursively (best approach) - The value of " + base + "^" + exponent + " is: "  + RecursivePowerBest(base, exponent));
    }
}