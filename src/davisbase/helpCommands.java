/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davisbase;

import static davisbase.Index.copyright;
import static davisbase.Index.version;
import static davisbase.splashScreen.line;

/**
 *
 * @author Mehak Beri
 */
public class helpCommands {
    /**
		 *  Help: Display supported commands
		 */
	public static void help() {
			System.out.println(line("*",80));
			System.out.println("SUPPORTED COMMANDS");
			System.out.println("All commands below are case insensitive");
			System.out.println();
                        System.out.println("\tSHOW TABLES;                                                  Displays a list of all tables in DavisBase.");
                        System.out.println("\tCREATE TABLE;                                                 Creates a new table schema, i.e., a new empty table.");
                        System.out.println("\tDROP TABLE table_name;                                        Remove table data and its schema.");
			System.out.println("\tINSERT INTO table_name [column_list] VALUES value_list;       Inserts a single record into a table.");
                        System.out.println("\tDELETE FROM table_name [column_list] [WHERE condition];       Inserts a single record into a table.");
                        System.out.println("\tUPDATE table_name SET column_name = value [WHERE condition];  Modifies one or more records in a table.");
                        System.out.println("\tSELECT * FROM table_name;                                     Display all records in the table.");
			System.out.println("\tSELECT * FROM table_name WHERE rowid = <value>;               Display records whose rowid is <id>.");
                        System.out.println("\tSELECT colname FROM table_name WHERE rowid = <value>;         Display records whose rowid is <id> and column name is <colname>");
			System.out.println("\tVERSION;                                                      Show the program version.");
			System.out.println("\tHELP;                                                         Show this help information");
			System.out.println("\tEXIT;                                                         Exit the program");
			System.out.println();
			System.out.println();
			System.out.println(line("*",80));
		}

	/** return the DavisBase version
     * @return  */
	public static String getVersion() {
		return version;
	}
	
	public static String getCopyright() {
		return copyright;
	}
	
	public static void displayVersion() {
		System.out.println("DavisBase Version " + getVersion());
		System.out.println(getCopyright());
	}
		
	
}
