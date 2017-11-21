/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davisbase;

import static davisbase.Index.isExit;
import static davisbase.helpCommands.displayVersion;
import static davisbase.ddlCommands.*;
import static davisbase.dmlCommands.*;
import static davisbase.vdlCommands.*;
import static davisbase.helpCommands.help;
import java.util.ArrayList;
import java.util.Arrays;
import static davisbase.vdlCommands.parseSelectString;


/**
 *
 * @author Mehak Beri
 */
public class parseCommand {
    public static void parseUserCommand (String userCommand) {
		
		/* commandTokens is an array of Strings that contains one token per array element 
		 * The first token can be used to determine the type of command 
		 * The other tokens can be used to pass relevant parameters to each command-specific
		 * method inside each case statement */
		ArrayList<String> commandTokens = new ArrayList<>(Arrays.asList(userCommand.split(" ")));
		

		/*
		*  This switch handles a very small list of hardcoded commands of known syntax.
		*  You will want to rewrite this method to interpret more complex commands. 
		*/
		switch (commandTokens.get(0)) {
			case "select":
				parseSelectString(userCommand);
				break;
			case "drop":
				System.out.println("STUB: Calling your method to drop items");
				dropTable(userCommand);
				break;
			case "create":
				parseCreateString(userCommand);
				break;
			case "help":
				help();
				break;
			case "version":
				displayVersion();
				break;
			case "exit":
				exit();
				break;
			case "quit":
				exit();
			default:
				System.out.println("I didn't understand the command: \"" + userCommand + "\"");
				break;
		}
	}
	
}
