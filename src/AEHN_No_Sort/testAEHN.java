package AEHN_No_Sort;

import java.io.IOException;

// EFIM TESTER
public class testAEHN {

	public static void main(String[] arg) throws IOException {
		String input = ("Dynamic//pumsb.negative.txt");
		float oldMin = 3000000;
		// the input and output file paths
		float minutil = oldMin;
		int max = Integer.MAX_VALUE;
		for (int i = 1; i <= 1; i++) {
			//System.out.println("--"+i+"--");
			System.gc();
			AlgoAEHN algo = new AlgoAEHN(); // Run the EFIM algorithm
			Itemsets output = algo.runAlgorithm(minutil, input, null, true, max, true);
			algo.printStats();
			//minutil -= Giam;
		} 

	}

}
