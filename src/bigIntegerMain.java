import java.math.BigInteger;
import java.util.*;


public class bigIntegerMain {

    public static void main(String[] args){


        // Task 1
        // #1 - r0 = 11069529223, r1 = 188351587
        // #2 - Coefficients S and T that solve the equation 435985 * S + 288651 * T = 11
        // #3 - Multuiplicative inverse of 300 modulo 104759
        // #4 - Multiplicative inverse of 300 modulo 104003


        // Declaring variables

        BigInteger r0, r1, ans, S, T;

        // Scanner Testing

        Scanner console = new Scanner(System.in);


        // Setting up the input

        System.out.println("r0 = ??");
        r0 = console.nextBigInteger();
        System.out.println("r0 = " + r0);

        System.out.println("r1 = ??");
        r1 = console.nextBigInteger();
        System.out.println("r1 = " + r1);


        // Finding the GCD of r0 and r1
        ans = r0.gcd(r1);


        // Printing the results
        System.out.println("gcd(" + r0 + ", " + r1 + ") = " + ans);


        while (S = (ans - T * r1) / r0);

        

    }

}
