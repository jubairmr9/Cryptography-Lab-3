package main.java;

import java.math.BigInteger;
import java.util.*;

public class FermatPrimality {

    // Check if the number is prime

    public static boolean isPrime(BigInteger n, int someVal) {

        // Add the base cases

        if (n.equals(BigInteger.valueOf(0)) || n.equals(BigInteger.valueOf(1)))
            return false;

        if (n.equals(BigInteger.valueOf(2)))
            return true;

        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)))
            return false;

        int counter = 0;
        Random random = new Random();

        for (int i = 0; i < someVal; i++) {

            counter++;

            BigInteger q0 = BigInteger.valueOf(Math.abs(random.nextInt()));
            BigInteger q1 = q0.mod(n.subtract(BigInteger.valueOf(1))).add(BigInteger.valueOf(1));

            if (!(q1.modPow(n.subtract(BigInteger.valueOf(1)), n).equals(BigInteger.valueOf(1)))) {

                System.out.println("Number of candidates tried to determine composite: " + counter);

                return false;
            }
        }

        return true;
    }

    public static void main (String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Running the Fermat Primality test\n");

        FermatPrimality fp = new FermatPrimality();
        System.out.println("Input: ");

        BigInteger value = console.nextBigInteger();
        System.out.println("\nInput number of k tests: ");

        int k = console.nextInt();
        boolean prime = fp.isPrime(value, k);

        if (prime) {
            System.out.println("\n" + value + " is prime!");
        }

        else{
            System.out.println("\n" + value + " is composite!");
        }
    }
}
