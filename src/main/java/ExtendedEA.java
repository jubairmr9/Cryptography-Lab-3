// Credits to Ahnaf and Chuck for the help.

package main.java;
import java.math.BigInteger;
import java.util.*;


public class ExtendedEA {

    public static void main(String[] args){


        // Task 1

        // #1 - r0 = 11069529223, r1 = 188351587
        // gcd(11069529223, 188351587) = x
        // Answer: x = 105401
        // printValues(extendedEuclidean(BigInteger.valueOf(11069529223L), BigInteger.valueOf(188351587)));

        // #2 - Coefficients S and T that solve the equation 435985 * S + 288651 * T = 11
        // 435985 * S + 288651 * T = 11
        // Answer: S = 7004, T = -10579
        // printValues(extendedEuclidean(BigInteger.valueOf(435985), BigInteger.valueOf(288651)));

        // #3 - Multuiplicative inverse of 300 modulo 104759
        // 300 * x ≡ 1 mod 104759
        // Answer: x = 21301
        // printValues(extendedEuclidean(BigInteger.valueOf(104759), BigInteger.valueOf(300)));

        // #4 - Multiplicative inverse of 300 modulo 104003
        // 300 * x ≡ 1 mod 104003
        // Answer: x = 46108
        // printValues(extendedEuclidean(BigInteger.valueOf(104003), BigInteger.valueOf(300)));

        // Scanner Set Up

        Scanner console = new Scanner(System.in);
        System.out.println("Enter r0: ");
        BigInteger r0 = new BigInteger(console.nextLine());
        System.out.println("Enter r1: ");
        BigInteger r1 = new BigInteger(console.nextLine());

        printResults(extEuclidean(r0, r1));

    }

    public static Map<String, BigInteger> extEuclidean(BigInteger r0, BigInteger r1) {

        // Storing the values returned from Extended Euclidean Algorithm

        Map<String, BigInteger> euclidValues = new HashMap<>();
        euclidValues.put("r0", r0);
        euclidValues.put("r1", r1);

        // Initializing Values

        BigInteger q, s, tLast;
        q = s = tLast = BigInteger.valueOf(0);

        BigInteger t, sLast;
        t = sLast = BigInteger.valueOf(1);

        BigInteger r0Holder, tHolder, sHolder;

        // Extended Euclidean Algorithm

        while (!r1.equals(BigInteger.valueOf(0))) {

            q = r0.divide(r1);

            r0Holder = r0;
            r0 = r1;
            r1 = r0Holder.mod(r1);

            sHolder = s;
            s = (sLast.subtract(q.multiply(sHolder)));
            sLast = sHolder;

            tHolder = t;
            t = (tLast.subtract(q.multiply(tHolder)));
            tLast = tHolder;
        }

        euclidValues.put("s", sLast);
        euclidValues.put("t", tLast);
        euclidValues.put("gcd", r0);

        return euclidValues;
    }

    // Print out all results from EEA map

    private static void printResults(Map<String, BigInteger> values) {
        for(Map.Entry<String, BigInteger> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();
        System.out.println("Linear combination:");
        System.out.println(values.get("s") + "*" + values.get("r0") + " + " + values.get("t") + "*"
                + values.get("r1") + " = gcd(" + values.get("r0") + ", " + values.get("r1") + ") = " + values.get("gcd"));
    }


}
