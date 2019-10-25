package com.company;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class PrimesParallel extends RecursiveTask<Long> {

    private final ForkJoinPool fjPool = new ForkJoinPool();

    private long start;
    private long end;

    public PrimesParallel(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public long countPrimes(long start, long end) {
        return fjPool.invoke(new PrimesParallel(start, end));
    }
    @Override
    protected Long compute() {
        long count = 0;

        if (end - start <= 250) {
            for (long i = start; i < end; i++) {
                if (isPrime(i)) count += 1;
            }
        } else {

            long divider = ((end - start) / 2) + start;
            PrimesParallel small = new PrimesParallel(start, divider);
            PrimesParallel large = new PrimesParallel(divider, end);
            large.fork();
            count += small.compute();
            count += large.join();
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
