/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davisbase;

import static davisbase.Index.davisbase_columns;
import static davisbase.Index.davisbase_tables;
import static davisbase.Index.pageSize;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import static davisbase.vdlCommands.*;
import java.util.Iterator;
import java.util.List;

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
                String toDrop= dropTableString.split(" ")[2];
                System.out.println("Dropping table "+toDrop+" ...");
                davisbase_tables.remove(toDrop);
                System.out.println(davisbase_tables);
                Iterator<List<String>> itr= davisbase_columns.iterator();
                while(itr.hasNext())
                {
                    List<String> t= itr.next();
                    if(t.get(0).equalsIgnoreCase(toDrop))
                    {
                        itr.remove();
                    }
                }
                
                System.out.println(davisbase_columns);
	}
        
        
	/**
	 *  Stub method for creating new tables
	 *  @param queryString is a String of the user input
	 */
	public static void parseCreateString(String createTableString) {
		
		System.out.println("STUB: Calling your method to create a table");
		System.out.println("Parsing the string:\"" + createTableString + "\"");
		ArrayList<String> createTableTokens = new ArrayList<String>(Arrays.asList(createTableString.split(" ")));
                //System.out.println(createTableTokens);
		/* Define table file name */
                String[] name=createTableTokens.get(2).split("\\(");
		String tableFileName = "data//user_data//"+name[0] + ".tbl";
                String[] temp1= createTableString.split("\\(");
                String[] temp2 = temp1[1].split("\\)"); //temp2[0] contains the query inside of round brackets of create statement query
                
                String[] columns= temp2[0].split(",");
               // System.out.println("number of columns: "+ columns.length);
                
                //assume that first column must be INT and a primary key so <colname datatype primary key>
                //columns[i] gives column1 description
                String[] primaryCol= columns[0].split(" ");
                String primaryDataType= primaryCol[1].toUpperCase();
                String primaryAttr= (primaryCol[2]).toUpperCase();
                if(!primaryDataType.equals("INT") || !primaryAttr.equals("PRIMARY"))
                {
                    System.out.println("ERROR!! Please Note: A DavisBase table PRIMARY KEY must be (a) a single column, (b) the first column listed in the CREATE statement, and (c) an INT data type");
                }
                else
                {
                   //primaryCol[0] is primary col's col name
                    
                    //if attr is primary key, put column-key="pri" , if anything else, column-key value=X
                    //if attr is not null or primary, put is_nullable="no", if anything else, value="yes"
                    
                    ArrayList<String> columnNames= new ArrayList<>();
                    columnNames.add(primaryCol[0]);
                    
                    ArrayList<String> dataTypes= new ArrayList<>();
                    dataTypes.add("int");
                  //  ArrayList<String> column_key= new ArrayList<>();  no need to make array list cz only 1st will be primary
                  //  column_key.add("PRI");
                    ArrayList<String> is_nullable= new ArrayList<>();
                    is_nullable.add("NO");
                    int noOfColumns= columns.length;
                    int i=1; //because first column is of primary key and has already been defined
                    while(i<noOfColumns)
                    {
                        if(columns[i].charAt(0)==' ')
                        {
                            columns[i]=columns[i].substring(1);
                        }
                        String[] colI= columns[i].split(" ");
                        String c= colI[0]; //col name
                        columnNames.add(c);
                        String dt= colI[1]; //data type: int or string?
                        dataTypes.add(dt);
                        if(colI.length>2)
                        { //no need to check if the attr is primary key or not null, because questions says that only one primary key should be there and it should be the first col
                            is_nullable.add("NO");
                        }else
                        {
                            is_nullable.add("YES");
                        }
                        i++;
                    }
                    
                    System.out.println(columnNames);
                    System.out.println(dataTypes);
                    System.out.println(is_nullable);
                    
                    
                //parse the table creation commands into hashmap named with table name and column names as first entry of the hashmap.
                
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
		davisbase_tables.add(Arrays.asList(Integer.toString(davisbase_tables.size()),name[0]));
		/*  Code to insert rows in the davisbase_columns table  
		 *  for each column in the new table 
		 *  i.e. database catalog meta-data 
		 */
                davisbase_columns.add(Arrays.asList(Integer.toString(davisbase_columns.size()),name[0],primaryCol[0],"int","PRI","NO"));
                for(int j=1; j<noOfColumns;j++)
                {
                davisbase_columns.add(Arrays.asList(Integer.toString(davisbase_columns.size()),name[0],columnNames.get(j), dataTypes.get(j),"X", is_nullable.get(j)));
                }
                }
                
                System.out.println(davisbase_tables);
                System.out.println(davisbase_columns);
	}
        
}
