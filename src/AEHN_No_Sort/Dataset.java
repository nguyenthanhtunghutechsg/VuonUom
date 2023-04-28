package AEHN_No_Sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dataset {

	/** the list of transactions in this dataset */
	List<Transaction> transactions;
	float totalUtility;
	
	/** the largest item name */
	private int maxItem = 0;

	/**
	 * Constructor
	 * @param datasetPath the path of the file containing the dataset
	 * @param maximumTransactionCount the number of transaction to be read from the input file
	 * @throws IOException exception if error reading the file
	 */
    public Dataset(String datasetPath, int maximumTransactionCount) throws IOException {

    	// Initialize a list to store transactions in memory
        transactions = new ArrayList<Transaction>();
        totalUtility = 0.0f;
        
        // Create a buffered reader to read the input file
        BufferedReader br = new BufferedReader(new FileReader(datasetPath));
        String line;
        int i=0;
        // iterate over the lines to build the transaction
        while((line = br.readLine()) != null) { 
			// if the line is  a comment, is  empty or is  metadata
			if (line.isEmpty() == true || line.charAt(0) == '#' 
					|| line.charAt(0) == '%' || line.charAt(0) == '@') {
				continue;
			}
			i++;
			Transaction t = createTransaction(line);
			totalUtility += t.getUtility();
			// read the transaction
			transactions.add(t);
			// if the number of transaction to be read is reached, we stop
        	if(i==maximumTransactionCount) {
        		break;
        	}
			
        }
        //****** Show the number of transactions in this dataset**************************//
        //System.out.println("Transaction count :" +  transactions.size());
        br.close();
    }

    /**
     * Create a transaction object from a line from the input file
     * @param line a line from input file
     * @return a transaction
     */
    private Transaction createTransaction(String line) {
    	// split the line into tokens according to the ":" separator
    	String[] split = line.split(":");
    	
    	// Get the transaction utility
    	float transactionUtility = Float.parseFloat(split[1]);
    	
    	// Get the list of items 
        String[] itemsString = split[0].split(" ");
    	
        // Get the list of item utilities
        String[] itemsUtilitiesString = split[2].split(" ");
    	
        //Create array to store the items and their utilities
        int[] items = new  int[itemsString.length];
        float[] utilities = new  float[itemsString.length];

        // for each item
        for (int i = 0; i < items.length; i++) {
        	//store the item
        	items[i] = Integer.parseInt(itemsString[i])+1;
        	
        	// store its utility in that transaction
        	utilities[i] = Float.parseFloat(itemsUtilitiesString[i]);
            
            // if the item name is larger than the largest item read from the database until now, we remember
        	// its name
            if(items[i] > maxItem) {
                maxItem = items[i];
            }
        }

		// create the transaction object for this transaction and return it
		return new Transaction(items, utilities, transactionUtility);
    }

    /**
     * Get the list of transactions in this database
     * @return the list of transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }


    /**
     * Get the largest item  in this database.
     * @return the largest item
     */
    public int getMaxItem() {
        return maxItem;
    }

   /**
    * Get a string representation of this database
    * @return a string
    */
    public String toString() {
    	// Create a stringbuilder for storing the string
        StringBuilder datasetContent = new StringBuilder();

        // We will append each transaction to this string builder
        int STT = 0 ;
        for(Transaction transaction : transactions) {
        	STT++;
        	 datasetContent.append(STT+": ");
            datasetContent.append(transaction.toString());
            datasetContent.append("\n");
        }
        // Return the string
        return datasetContent.toString();
    }

    public float getTotalUtility()
    {
    	return totalUtility;
    }
}
