package com.phasmidsoftware.dsaipg.adt.threesum;

import java.util.Random;

public class IntGenerator {

    private Random random = new Random();

    public int[] generator(int length) {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            int n = random.nextInt(5000);
            a[i] = n;
        }
        return a;
    }
}
