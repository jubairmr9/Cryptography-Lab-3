package main.java;

import java.math.BigInteger;
import java.util.*;

public class MillerRabin {

    // Check if the number is prime

    public static boolean isPrime(BigInteger n, int someVal) {

        // Add base cases

        if (n.equals(BigInteger.valueOf(0)) || n.equals(BigInteger.valueOf(1)))
            return false;

        if (n.equals(BigInteger.valueOf(2)))
            return true;

        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)))
            return false;

        BigInteger s = n.subtract(BigInteger.valueOf(1));

        while (s.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
            s = s.divide(BigInteger.valueOf(2));
        }

        int counter = 0;
        Random random = new Random();

        for (int i = 0; i < someVal; i++) {

            counter++;

            BigInteger q0 = BigInteger.valueOf(Math.abs(random.nextInt()));
            BigInteger q1 = q0.mod((n.subtract(BigInteger.valueOf(1))).add(BigInteger.valueOf(1))), temp = s;
            BigInteger mod = q1.modPow(temp, n);

            while (!Objects.equals(temp, n.subtract(BigInteger.valueOf(1))) && !mod.equals(BigInteger.valueOf(1)) && !mod.equals(n.subtract(BigInteger.valueOf(1)))) {
                mod = mod.multiply(mod).mod(n);
                temp = temp.multiply(BigInteger.valueOf(2));
            }

            if (!mod.equals(n.subtract(BigInteger.valueOf(1))) && temp.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
                System.out.println("Number of candidates tried to determine composite: " + counter);
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Running the Miller-Rabin test\n");

        MillerRabin mr = new MillerRabin();
        System.out.println("Input Number: ");

        BigInteger someNum = console.nextBigInteger();
        System.out.println("\nInput number of k tests: ");

        int k = console.nextInt();
        boolean prime = mr.isPrime(someNum, k);

        if (prime) {
            System.out.println("\n" + someNum + " is prime!");
        }

        else {
            System.out.println("\n" + someNum + " is composite!");
        }
    }
}