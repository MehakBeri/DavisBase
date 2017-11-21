/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davisbase;

import static davisbase.Index.pageSize;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import static davisbase.vdlCommands.*;

/**
 *
 * @author Mehak Beri
 */
public class ddlCommands {
    
        public static void showTables()
        {
            System.out.println("Showing all tables..");
            parseSelectString("SELECT table_name FROM davisbase_tables;");
        }
    
	/**
	 *  Stub method for dropping tables
	 *  @param dropTableString is a String of the user input
	 */
	public static void dropTable(String dropTableString) {
		System.out.println("STUB: Calling dropTable(String s) to drop a table");
		System.out.println("Parsing the string:\"" + dropTableString + "\"");
	}
        
        
	/**
	 *  Stub method for creating new tables
	 *  @param queryString is a String of the user input
	 */
	public static void parseCreateString(String createTableString) {
		
		System.out.println("STUB: Calling your method to create a table");
		System.out.println("Parsing the string:\"" + createTableString + "\"");
		ArrayList<String> createTableTokens = new ArrayList<String>(Arrays.asList(createTableString.split(" ")));

		/* Define table file name */
		String tableFileName = createTableTokens.get(2) + ".tbl";

		/* YOUR CODE GOES HERE */
		
		/*  Code to create a .tbl file to contain table data */
		try {
			/*  Create RandomAccessFile tableFile in read-write mode.
			 *  Note that this doesn't create the table file in the correct directory structure
			 */
			RandomAccessFile tableFile = new RandomAccessFile(tableFileName, "rw");
			tableFile.setLength(pageSize);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		/*  Code to insert a row in the davisbase_tables table 
		 *  i.e. database catalog meta-data 
		 */
		
		/*  Code to insert rows in the davisbase_columns table  
		 *  for each column in the new table 
		 *  i.e. database catalog meta-data 
		 */
	}
}
