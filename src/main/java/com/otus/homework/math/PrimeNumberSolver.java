package com.otus.homework.math;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberSolver {

    //пункт 3
    public static int calcPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n ; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    //пункт 3
    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //пункт 15
    public static int optimizedCalcPrimes(int n) {
        if (n < 2) return 0;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= n ; i+=2) {
            if (isPrime(i, primes)) primes.add(i);
        }
        return primes.size();
    }

    //пункт 15
    private static boolean isPrime(int n, List<Integer> primes) {
        int sqrt = (int) Math.sqrt(n);
        for (Integer prime : primes) {
            if (prime > sqrt) break;
            if (n % prime == 0) return false;
        }
        return true;
    }

    //пункт 16
    public static int calcEratosthene(int n) {
        boolean[] composite = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!composite[i]) {
                count++;
                if (i > Integer.MAX_VALUE / i) continue;
                for (int j = i*i; j <= n; j+=i) {
                    composite[j] = true;
                }
            }
        }
        return count;
    }
}
