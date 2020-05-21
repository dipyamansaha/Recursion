// FACTORIAL OF A NUMBER

import java.util.Scanner;

public class Factorial
{
    static int RecursiveFactorialFinder(int num)
    {
        if((num == 0) || (num == 1))
            return 1;

        return (num * RecursiveFactorialFinder(num - 1));
    }

    static int FactorialFinder(int num)
    {
        int fact = 1;
        for(int i = 2; i <= num; i++)
            fact *= i;

        return fact;
    }

    public static void main(String[] args)
    {
        System.out.println("FACTORIAL OF A NUMBER...\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("\nThe Factorial of " + num + " is: " + num + "! = " + FactorialFinder(num));
        System.out.println("Recursively - The Factorial of " + num + " is: " + num + "! = " + RecursiveFactorialFinder(num));
    }
}