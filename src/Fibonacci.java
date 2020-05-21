// FIBONACCI SERIES

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci
{
    static int[] FibMemoArray = new int[51];

    static int[] RWMFibonacciSeriesFinder(int num)
    {
        int[] fibArr = new int[num];

        for(int i = 1; i <= num; i++)
            fibArr[i - 1] = RWMFibonacciTermFinder(i);

        return fibArr;
    }

    static int[] RecursiveFibonacciSeriesFinder(int num)
    {
        int[] fibArr = new int[num];

        for(int i = 1; i <= num; i++)
            fibArr[i - 1] = RecursiveFibonacciTermFinder(i);

        return fibArr;
    }

    static int[] FibonacciSeriesFinder(int num)
    {
        int[] fibArr = new int[num];

        if(num == 1)
            return fibArr;

        fibArr[1] = 1;

        for(int i = 2; i < num; i++)
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];

        return fibArr;
    }

    static int RWMFibonacciTermFinder(int num)
    {
        if(FibMemoArray[num - 1] != -1)
            return FibMemoArray[num - 1];

        FibMemoArray[num - 1] = RWMFibonacciTermFinder(num - 1) + RWMFibonacciTermFinder(num - 2);
        return FibMemoArray[num - 1];
    }

    static int RecursiveFibonacciTermFinder(int num)
    {
        if(((num - 1) == 0) || ((num - 1) == 1))
            return (num - 1);

        return (RecursiveFibonacciTermFinder(num - 1) + RecursiveFibonacciTermFinder(num - 2));
    }

    static int FibonacciTermFinder(int num)
    {
        if(((num - 1) == 0) || ((num - 1) == 1))
            return (num - 1);

        int fib1 = 0, fib2 = 1;

        int fib = -1;
        for(int i = 3; i <= num; i++)
        {
            fib = (fib1 + fib2);
            fib1 = fib2;
            fib2 = fib;
        }

        return fib;
    }

    public static void main(String[] args)
    {
        System.out.println("FIBONACCI SERIES...\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the term number: ");
        int num1 = sc.nextInt();

        System.out.println("\nThe " + num1 + "(st/nd/rd/th) term in the Fibonacci series is: " + FibonacciTermFinder(num1));
        System.out.println("Recursively - The " + num1 + "(st/nd/rd/th) term in the Fibonacci series is: " + RecursiveFibonacciTermFinder(num1));

        FibMemoArray[0] = 0;
        FibMemoArray[1] = 1;
        for(int i = 2; i < 51; i++)
            FibMemoArray[i] = -1;

        System.out.println("Recursively, with memorisation - The " + num1 + "(st/nd/rd/th) term in the Fibonacci series is: " + RWMFibonacciTermFinder(num1));

        System.out.print("\nEnter the number of terms: ");
        int num2 = sc.nextInt();

        System.out.println("\nThe Fibonacci series of " + num2 + " term(s) is: " + Arrays.toString(FibonacciSeriesFinder(num2)));
        System.out.println("Recursively - The Fibonacci series of " + num2 + " term(s) is: " + Arrays.toString(RecursiveFibonacciSeriesFinder(num2)));
        System.out.println("Recursively, with memorisation - The Fibonacci series of " + num2 + " term(s) is: " + Arrays.toString(RWMFibonacciSeriesFinder(num2)));
    }
}