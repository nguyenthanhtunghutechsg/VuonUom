package AEHN_No_Prune;

import java.util.ArrayList;

/*
 *	---------------------------------------------[ TIDSET ] ------------------------------------------------------------- 
 *	Novel data structure for reducing the cost of database scan while mining HUIs.
 *	The data structure holds lists of transaction IDs that contain an item, each item has it own list. This 
 *	help the algorithm only need to scan through the transactions that have their IDs stored inside the list
 *	instead of scanning the whole database, thus increasing the effective of the overall utilized algorithm.
 *	The class is designed for the purpose of creating a higher abstract level for the code. 
 *	---------------------------------------------------------------------------------------------------------------------
 *	Coded by Dzu Trinh Dac Nguyen, 2017-2018.
 *	Utilized by the dEFIM and pdEFIM algorithm
 */
public class TIDset {
	
	// Our data structure is organized as follows:
	//	sTIDSET
	//	+-------+-----+-----+- # -+-----+
	//	| Row 1 | TID | TID | ... | TID |
	//	+-------+-----+-----+- # -+-----+-----+
	//	| Row 2 | TID | TID | ... | TID | TID |
	//	+-------+-----+-----+- # -+-----+-----+
	//	|  ...  | ... | ... | ... | ... |
	//	+-------+-----+-----+- # -+-----+-----+-----+
	//	| Row n | TID | TID | ... | TID | TID | TID |
	//	+-------+-----+-----+- # -+-----+-----+-----+
	
	public ArrayList<ArrayList<Integer>>	tid;						// property
	
	// constructor
	TIDset() {		
		this.tid = new ArrayList<ArrayList<Integer>>();		// allocate the set of transaction IDs
	}
	
	// constructor
	TIDset(int rows) {
		this.tid = new ArrayList<ArrayList<Integer>>();		// allocate the set of transaction IDs
		this.addRows(rows);
	}
	
	// reset the whole data structure
	public void reset() {
		int size = this.tid.size();
		for (int i = 0; i < size; i++) {
			this.tid.get(i).clear();
		}				
	}
	
    // add a new row into the data structure
    public void addRow() {
        this.tid.add(new ArrayList<Integer>());
    }
    
    // add count rows into the data structure
    public void addRows(int count) {
    		for (int i = 0; i < count; i++) {
    			//this.addRow();
    			this.tid.add(new ArrayList<Integer>());
    		}
    }

    // return a full row at index-th 
    ArrayList<Integer> getRow(int index) {
    		return this.tid.get(index);
    }
    
    // add a transaction ID into a row
    public void addTID(int index, Integer value) {
        this.tid.get(index).add(value);
    }

    // clear a row of transaction IDs
    public void clearTID(int index) {
    		this.tid.get(index).clear();
    }
    
    // return total rows in the TID set
    public int size() {
        return this.tid.size();
    }

    // return a row's length
    public int length(int index) {
        return this.tid.get(index).size();
    }

    // return the maximal row's length inside the data structure
    public int getMaxLength() {
        int maxLen = 0, len, size = this.tid.size();
        for (int i = 0; i < size; i++)
        {
            len = this.tid.get(i).size();
            if (maxLen < len)
                maxLen = len;
        }
        return maxLen;
    }	

    // TODO: a toString() method needed for debugging purpose
}
