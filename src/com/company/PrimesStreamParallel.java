package com.company;

import java.util.stream.LongStream;

public class PrimesStreamParallel {

    public long getPrimesStream(long min, long max) {

        return LongStream.rangeClosed(min, max).parallel().filter(x -> isPrime(x)).count();
    }

    private boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;
        int limit = (int)(Math.sqrt(n)+ 0.5);
        for (int i = 3; i <= limit; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
