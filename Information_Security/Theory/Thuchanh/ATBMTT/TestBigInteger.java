import java.math.*;
import java.util.*;

public class TestBigInteger {
	
	public static void main(String[] args) {
		
		// Get two numbers from the user for testing.
		Scanner stdin = new Scanner(System.in);
		System.out.println("Please enter a big integer.");
		String strNum1 = stdin.next();
		System.out.println("Please enter another big integer.");
		String strNum2 = stdin.next();		
		
		// Create BigInteger objects from string input.
		BigInteger num1 = new BigInteger(strNum1);
		BigInteger num2 = new BigInteger(strNum2);
		
		// Add the two values - and print result.
		BigInteger sum = num1.add(num2);
		System.out.println(num1+" + "+num2+" = "+sum);
		
		// Test compareTo
		int cmpResult = num1.compareTo(num2);
		if (cmpResult < 0)
			System.out.println("num1 is smaller.");
		else if (cmpResult == 0)
			System.out.println("They are the same number.");
		else
			System.out.println("num2 is smaller.");
		
		BigInteger quotient = num1.divide(num2);
		System.out.println(num1+" / "+num2+" = "+quotient);

		BigInteger mod = num1.mod(num2);
		System.out.println(num1+" % "+num2+" = "+mod);
		
		BigInteger gcd = num1.gcd(num2);
		System.out.println("gcd("+num1+", "+num2+") = "+gcd);
		
		// Test Mod inverse, but only if one exists.
		if (gcd.equals(BigInteger.ONE)) {
			if (cmpResult < 0) {
				System.out.println("In num1<num2 mod inverse code.");
				BigInteger modInv = num1.modInverse(num2);
				System.out.println("The mod inverse is "+modInv);
				BigInteger check = num1.multiply(modInv).mod(num2);
				if (check.equals(BigInteger.ONE))
					System.out.println("Inverse check worked.");
			}
			else {
				System.out.println("In num2<num1 mod inverse code.");
				BigInteger modInv = num2.modInverse(num1);
				System.out.println("The mod inverse is "+modInv);
				BigInteger check = num2.multiply(modInv).mod(num1);
				if (check.equals(BigInteger.ONE))
					System.out.println("Inverse check worked.");				
			}
		}
		
		// Generate a random 512 bit prime number.
		Random r = new Random();
		BigInteger prime = null;
		int numTrials = 0;
		
		// Keep on going until we have a prime number.
		// Count how many times the loop runs also.
		while (prime == null) {
			BigInteger tmp = new BigInteger(512, r);
			numTrials++;
			if (tmp.isProbablePrime(100)) 
				prime = tmp;
		}
		
		// Print out the prime and how long it took.
		System.out.println("Here is big probable prime: "+prime);
		System.out.println("It took us "+numTrials+" guesses before generating it.");
		
		BigInteger base = new BigInteger(512, r);
		BigInteger exp = new BigInteger(512, r);
		BigInteger finalresult = base.modPow(exp, prime);
		System.out.println("Mod pow result = "+finalresult);
	}
}