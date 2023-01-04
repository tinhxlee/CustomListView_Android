// zachariah abueg
// 10.19.20
// cis 3362 - fall 2020
// homework 5 - question 5
// finding primitive roots of primes

import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class primitiveRoots
{
	// here we do trial division to determine whether n is prime
	// if a non-trivial divisor of n is found, then n is composite
	// otherwise, n is prime
	static int smallestPrimeFactor(int n)
	{

	    for (int i = 2; i*i <= n; i++)
	        if (n % i == 0)
	            return i;

	    return -1;
	}

	public static void main(String[] args)
	{
		// scnr and scnr.nextInt() are functionally equivalent to scanf in C
		// System.out.println is equivalent to printf in C
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter an integer between 2 and 1000.");
		int n = scnr.nextInt();
		scnr.close();

	    int divisor = smallestPrimeFactor(n);

	    if (divisor != -1)
	    {
	        System.out.print(n + " is not prime. Its smallest non-trivial divisor is " + divisor + ".");
	        return;
	    }

	    // an ArrayList is equivalent to a dynamically allocated array in C
	    System.out.println(n + " is prime.");

	    int p = n;
	    int current = 1;
	    boolean isPrimitiveRoot = true;
	    ArrayList<Integer> primitiveRoots = new ArrayList<Integer>();

	    // here we exponentiate each 'a' iteratively
	    // if we reach 1 mod p before exponentiating 'a' to p - 1,
	    // then 'a' isn't a primitive root of p
	    for (int a = 1; a <= p - 1; a++)
	    {
	        for (int i = 1; i <= p - 1; i++)
	        {
	            current = (current * a) % p;
	            if (current == 1 && i < p - 1)
	            {
	            	... update isPrimitiveRoot ...
	                break;
	            }
	        }

	        if (isPrimitiveRoot)
		... Add to List of  primitiveRoots...

	        isPrimitiveRoot = true;
	    }

	    System.out.print("Its primitive roots are: ");

	    for (int i = 0; i < primitiveRoots.size(); i++)
	    	System.out.print(primitiveRoots.get(i) + " ");
	}
}