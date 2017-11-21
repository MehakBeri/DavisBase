/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mehak Beri
 */
package davisbase;
import static davisbase.Index.isExit;

public class vdlCommands {
    /**
	 *  Stub method for executing queries
	 *  @param queryString is a String of the user input
	 */
	public static void parseSelectString(String queryString) {
		System.out.println("STUB: Calling parseQueryString(String s) to process queries");
		System.out.println("Parsing the string:\"" + queryString + "\"");
	}
        
        public static void exit()
        {
            isExit = true;
        }
}
