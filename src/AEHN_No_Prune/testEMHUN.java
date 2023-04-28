package AEHN_No_Prune;

import java.io.IOException;

// EFIM TESTER
public class testEMHUN {

	public static void main(String[] arg) throws IOException {
		String input = ("Dynamic//accidents.negative.txt");
		float oldMin = 5000000;
		float minutil = oldMin;
		/*
		 * Accident = 340183 BMS 59602 Chainstore 1112949 Chess 3196 Connect 67557
		 * Kosarak 990002 Mushroom 8416 Pumsb 49046
		 */
		int max = 340183 * 1 / 4;
		for (int i = 1; i <= 1; i++) {
			// System.out.println("--"+i+"--");
			System.gc();
			AlgoEMHUN algo = new AlgoEMHUN(); // Run the EFIM algorithm
			Itemsets output = algo.runAlgorithm(minutil, input, null, true, max, true);
			algo.printStats();
			// minutil -= Giam;
		}

	}

}
