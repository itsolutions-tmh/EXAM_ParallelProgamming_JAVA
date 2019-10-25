package com.company;


public class PrimesSequential {

    public long countPrimes(long first, long last)
    {
        long count = 0;
        for (long i = first; i < last; i++)
        {
            if (isPrime(i)) {
                count += 1;
            }
        }
        return count;
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
