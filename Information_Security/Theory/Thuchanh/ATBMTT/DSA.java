import java.util.*;
import java.math.BigInteger;

public class DSA {

	final static BigInteger one = new BigInteger("1");
	final static BigInteger zero = new BigInteger("0");
	
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		Random randObj = new Random();
		
		System.out.println("Enter an approximate value for p.");
		String ans = stdin.next();
		
		// Establish the global public key components.
		BigInteger p = getNextPrime(ans);
		BigInteger q = findQ(p.subtract(one));
		BigInteger g = getGen(p,q,randObj);
		
		// Print these out.
		System.out.println("\nHere are the public key components:\n");
		System.out.println("p is "+p);
		System.out.println("q is "+q);
		System.out.println("g is "+g);
		
		// First the private key.
		BigInteger x = new BigInteger(q.bitLength(), randObj);
		x = x.mod(q);
		
		// Now the corresponding public key.
		BigInteger y = g.modPow(x,p);
		
		// Here we have the random value for one message.
		BigInteger k = new BigInteger(q.bitLength(), randObj);
		k = k.mod(q);
		
		// Print out the secret information.
		System.out.println("\nSecret Information:\n");
		System.out.println("x is "+x);
		System.out.println("k is "+k);
		
		// and the other public key.
		System.out.println("\nPublic Key:\n");
		System.out.println("y is "+y);
		
		// Signature is here.
		..... BigInteger r = .....

		BigInteger hashVal = new BigInteger(p.bitLength(), randObj);
		
		// Print out a randomly generated hash value and the signature.
		System.out.println("Hash Val = "+hashVal);
		
		BigInteger kInv = k.modInverse(q);
		BigInteger s = kInv.multiply(hashVal.add(x.multiply(r)));
		s = s.mod(q);
		
		System.out.println("\nThe signature:\n");
		System.out.println("r is "+r);
		System.out.println("s is "+s);
		
		// Now we verify.
		BigInteger w = s.modInverse(q);
		BigInteger u1 = (hashVal.multiply(w)).mod(q);
		BigInteger u2 = (r.multiply(w)).mod(q);
		
                                   .... BigInteger v = .....
		v = (v.mod(p)).mod(q);
		
		// These are the different values generated during the verification
		// process.
		System.out.println("\nVerifying checkpoints:\n");
		System.out.println("w is "+w);
		System.out.println("u1 is "+u1);
		System.out.println("u2 is "+u2);
		System.out.println("v is "+v);
		
		// Here's the actual check for the valid signature.
		if (v.equals(r))
			System.out.println("Signature is verified!");
		else
			System.out.println("Incorrect signature.");
		
	}	
	
	// Incrementally tries each BigInteger starting at the value passed
	// in as a parameter until one of them is tests as being prime.
	public static BigInteger getNextPrime(String ans) {
		BigInteger test = new BigInteger(ans);
		while (!test.isProbablePrime(99))
			test = test.add(one);
		return test;		
	}
	
	// Finds largest prime factor of n, assuming n is
	// composite. Not efficient.
	public static BigInteger findQ(BigInteger n) {
		
		BigInteger start = new BigInteger("2");
		
		// Keep on dividing n until it's prime.
		while (!n.isProbablePrime(99)) {
			
			// Try to find the next factor.
			while (!((n.mod(start)).equals(zero))) {
				start = start.add(one);
			}
			// Now divide by it.
			n = n.divide(start);
			
		}
		// This is the prime that is left.
		return n;
	}
	
	// Returns a generator mod p.
	public static BigInteger getGen(BigInteger p, BigInteger q, Random r) {
		// Pick the random value.
		BigInteger h = new BigInteger(p.bitLength(), r);
		h = h.mod(p);
		
		// Exponentiate it to this power: (p-1)/q.
		return h.modPow((p.subtract(one)).divide(q), p);
	}
}