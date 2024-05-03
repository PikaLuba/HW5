package org.example;

import java.util.HashMap;
import java.util.Map;

class Fibonacci {
    private static Map<Integer, Long> memo = new HashMap<>();
    public static void main(String[] args) {
        int n = 6;
        long start = System.nanoTime();
        System.out.println("FibonacciIterative(" + n + ")= " + fibonacciIterative(n) + "   Time= " + (System.nanoTime() - start) + " нс");
        start = System.nanoTime();
        System.out.println("FibonacciRecursive(" + n + ")= " + fibonacciRecursive(n) + "   Time= " + (System.nanoTime() - start) + " нс");
        start = System.nanoTime();
        System.out.println("FibonacciDP(" + n + ")= " + fibonacciDP(n) + "   Time= " + (System.nanoTime() - start) + " нс");

        System.out.println("");

        n = 45;
        start = System.nanoTime();
        System.out.println("FibonacciIterative(" + n + ")= " + fibonacciIterative(n) + "   Time= " + (System.nanoTime() - start) + " нс");
        start = System.nanoTime();
        System.out.println("FibonacciRecursive(" + n + ")= " + fibonacciRecursive(n) + "   Time= " + (System.nanoTime() - start) + " нс");
        start = System.nanoTime();
        System.out.println("FibonacciDP(" + n + ")= " + fibonacciDP(n) + "   Time= " + (System.nanoTime() - start) + " нс");

    }
    /**
     * Time Complexity: O(N)
     * Auxiliary Space: O(1)
     */
    private static long fibonacciIterative(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        if (n <= 1) {
            return n;
        } else {
            for (int i = 2; i < n+1; i++) {
                c = b;
                b = a + b;
                a = c;
            }
            return b;
        }
    }

    /**
     * Time Complexity: O(2**N)
     * Auxiliary Space: O(n)
     */
    private static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    /**
     * Time Complexity: O(n)
     * Auxiliary Space: O(n)
     */
    private static long fibonacciDP(int n) {

        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long fib = fibonacciDP(n - 1) + fibonacciDP(n - 2);
        memo.put(n, fib);
        return fib;
    }


}

