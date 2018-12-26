package test;

import org.junit.*;
import main.java.*;
import java.math.BigInteger;
import java.util.*;

public class MillerRabinTest {
    @Test
    public void primeTesting(){
        BigInteger largePrime = BigInteger.probablePrime(512, new Random());
        Assert.assertEquals(MillerRabin.isPrime(largePrime, 45), true);

        BigInteger largePrime2 = BigInteger.probablePrime(1024, new Random());
        Assert.assertEquals(MillerRabin.isPrime(largePrime2, 45), true);
    }

    @Test
    public void compositeTesting(){
        BigInteger largeComposite = (BigInteger.probablePrime(512, new Random()).multiply(BigInteger.probablePrime(512, new Random())));
        Assert.assertEquals(MillerRabin.isPrime(largeComposite, 45), false);

        BigInteger largeComposite2 = (BigInteger.probablePrime(1024, new Random()).multiply(BigInteger.probablePrime(1024, new Random())));
        Assert.assertEquals(MillerRabin.isPrime(largeComposite2, 45), false);

    }
}