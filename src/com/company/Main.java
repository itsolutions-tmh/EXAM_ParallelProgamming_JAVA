package com.company;

import java.util.List;

public class Main {
    static final long MIN = 1_000_000;
    static final long MAX = 2_000_000;


    static PrimesSequential primesSequential = new PrimesSequential();
    static PrimesParallel primesParallel = new PrimesParallel(MIN, MAX);
    public static void main(String[] args) {
       runSequential();
        runParallel();

        System.out.println("Done.");

    }

  private static void runSequential(){

          long start = System.nanoTime();
          long n = primesSequential.countPrimes(MIN, MAX);
          long finish = System.nanoTime();
          System.out.println(n + " primes more than " + MIN + " primes less than " + MAX);
          System.out.println("Time for Sequential approach : " + ((finish - start) / 1e9) + " sec.\n");

  }

  private static void runParallel(){
          long start = System.nanoTime();
          long n = primesParallel.countPrimes(MIN, MAX);
          long finish = System.nanoTime();
      System.out.println(n + " primes more than " + MIN + " primes less than " + MAX);
          System.out.println("Time for Parallel approach: " + ((finish - start) / 1e9) + " sec.\n");

      System.out.println(Runtime.getRuntime().availableProcessors() + " processors.");
  }
}