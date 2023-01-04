// Arup Guha
// Written in CIS 3362 on 10/17/2011
// Prints out a chart of modular exponents
// to illustrate why the discrete log problem is (probably) difficult.

public class DiscLog {


	public static void main(String[] args) {
	    printExpTable(25);
	}
	
	public static void printExpTable(int n) {
	
		// Prints out the top of the chart.
		System.out.print("Base number \t");
		for (int exp = 0; exp<n; exp++)
			System.out.printf("%4d", exp);
		System.out.println();
		 
		// Draws dashes to make the chart look nice.
		System.out.print("----\t");
		for (int exp = 0; exp<n; exp++)
		    System.out.printf("  --", exp);
		System.out.println();
		 
		 
		 // Print each exponent using this base.
	    for (int base=2; base<n; base++) {
		 
		    System.out.print(base+"\t\t");
			  
			// Raise base to each exponent mod n.  
			int ans = 1;
			for (int exp = 0; exp<n; exp++) {
			    System.out.printf("%4d", ans);
                                                    ... Multiply ans with base mod n 
			}
			System.out.println();
	    }
	}

}
