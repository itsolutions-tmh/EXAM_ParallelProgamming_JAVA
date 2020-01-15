package com.company;

public class Main {
    static final long MIN = 0;
    static final long MAX = 2_000_000;


    static PrimesSequential primesSequential = new PrimesSequential();
    static PrimesParallel primesParallel = new PrimesParallel(MIN, MAX);
    static PrimesStreamParallel primesStreamParallel = new PrimesStreamParallel();
    public static void main(String[] args) {
       runSequential();
       runParallel();
       runStream();

        System.out.println(Runtime.getRuntime().availableProcessors() + " processors.");
        System.out.println("Done.");

    }

  private static void runSequential(){

          long start = System.nanoTime();
          long n = primesSequential.countPrimes(MIN, MAX);
          long finish = System.nanoTime();
          System.out.println(n + " primes between " + MIN + " and " + MAX);
          System.out.println("Time for Sequential approach : " + ((finish - start) / 1e9) + " sec.\n");

  }

  private static void runParallel(){
          long start = System.nanoTime();
          long n = primesParallel.countPrimes(MIN, MAX);
          long finish = System.nanoTime();
      System.out.println(n + " primes between " + MIN + " and " + MAX);
          System.out.println("Time for Parallel approach: " + ((finish - start) / 1e9) + " sec.\n");


  }

  private static void runStream(){
      long start = System.nanoTime();
      long n = primesStreamParallel.getPrimesStream(MIN, MAX);
      long finish = System.nanoTime();
      System.out.println(n + " primes between " + MIN + " and " + MAX);
      System.out.println("Time for Parallel Stream approach : " + ((finish - start) / 1e9) + " sec.\n");
  }
}