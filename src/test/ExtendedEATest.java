package test;

import org.junit.*;
import main.java.ExtendedEA;
import java.math.BigInteger;
import java.util.*;

public class ExtendedEATest {
    @Test
    public void EEATest(){
        Map<String, BigInteger>

        // r0=78, r1=97
        values = ExtendedEA.extEuclidean(BigInteger.valueOf(78), BigInteger.valueOf(97));

        // gcd = 1, s = -45, t = 37
        Assert.assertEquals(values.get("gcd"), BigInteger.valueOf(1));
        Assert.assertEquals(values.get("s"), BigInteger.valueOf(-46));
        Assert.assertEquals(values.get("t"), BigInteger.valueOf(37));

        // r0=165, r1=297
        values = ExtendedEA.extEuclidean(BigInteger.valueOf(165), BigInteger.valueOf(297));

        // gcd = 1, s = -2, t = 13
        Assert.assertEquals(values.get("gcd"), BigInteger.valueOf(33));
        Assert.assertEquals(values.get("s"), BigInteger.valueOf(2));
        Assert.assertEquals(values.get("t"), BigInteger.valueOf(-1));
    }
}
