// MODULAR EXPONENTIATION

import java.util.Scanner;

public class ModularExponentiation
{
    static int RecursiveModExpoBest(int base, int exponent, int modulus)
    {
        if(exponent == 0)
            return 1;

        if(exponent == 1)
            return (base % modulus);

        if((exponent % 2) == 0)
        {
            int resultMid = RecursiveModExpoBest(base, (exponent / 2), modulus);
            return ((resultMid * resultMid) % modulus);
        }

        return ((base * RecursiveModExpo(base, (exponent - 1), modulus)) % modulus);
    }

    static int RecursiveModExpo(int base, int exponent, int modulus)
    {
        if(exponent == 0)
            return 1;

        if(exponent == 1)
            return (base % modulus);

        return ((base * RecursiveModExpo(base, (exponent - 1), modulus)) % modulus);
    }

    static int ModExpo(int base, int exponent, int modulus)
    {
        int result = 1;

        for(int i = 0; i < exponent; i++)
            result *= base;

        return (result % modulus);
    }

    public static void main(String[] args)
    {
        System.out.println("MODULAR EXPONENTIATION...\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base: ");
        int base = sc.nextInt();
        System.out.print("Enter the exponent: ");
        int exponent = sc.nextInt();
        System.out.print("Enter the modulus: ");
        int modulus = sc.nextInt();

        System.out.println("\nThe value of (" + base + "^" + exponent + ")%" + modulus + " is: " + ModExpo(base, exponent, modulus));
        System.out.println("Recursively - The value of (" + base + "^" + exponent + ")%" + modulus + " is: "  + RecursiveModExpo(base, exponent, modulus));
        System.out.println("Recursively (best approach) - The value of (" + base + "^" + exponent + ")%" + modulus + " is: "  + RecursiveModExpoBest(base, exponent, modulus));
    }
}