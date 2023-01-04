import java.io.*;
import java.util.*;

public class RC4 {
	
	
	public static void main(String[] args) {
		
		int[] key = new int[256];
		int[] s = new int[256];
		Scanner stdin = new Scanner(System.in);
		
		// Get the initial key. (It's 32 bits, since we just seed the first 4 bytes.)
		System.out.println("Please enter the first four key values (0-255).");
		for (int i=0; i<4; i++)
			key[i] = stdin.nextInt();
			
		// Set the rest of the key up with cyclic repeats.
		for (int i=4; i<256; i++)
			key[i] = key[i-4];
			
		// This is the initial state of s.
		for (int i=0; i<256; i++)
			s[i] = i;
			
		// First randomization.
		int j=0;
		for (int i=0; i<256; i++) {
			j=(i+s[i]+key[i])%256;
			... swap i and j ...
		}
		
		// This is just for my purposes to print out s.
		for (int i=0; i<256; i++) {
			System.out.print(s[i]+" ");
			if (i%8 == 7)
				System.out.println();
		}
		
		// Asks the user how many random output bytes are desired.
		System.out.println("How many random bytes do you want?");
		int numbytes = stdin.nextInt();
		
		int i=0;
		j=0;
		
		// This is the algorithm given in the text.
		for (int loop=0; loop<numbytes; loop++) {
			i = (i+1)%256;
			j = (j + s[i])%256;
                                                   
			... swap i and j ...
			
                                                   ... Choose t be a sum of s[i] and  s[j]  mod  256;
			
			// This function just outputs the value s[t] in binary.
                                                   outputBin(s[t],8);
			
			// This is to try to match CAP's output format.
			if (loop%2 == 1)
				System.out.println();
			
		}
			
	}
	
	// A swap...
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	// Recursive method to output n using numBits number of binary bits.
	public static void outputBin(int n, int numBits) {
		
		// We have stuff to output.
		if (numBits > 0) {
			// Do the rest of the bits first,
			outputBin(n/2, numBits-1);
			
			// then the least significant one.
			System.out.print(n%2);
		}
		
	}
	
}