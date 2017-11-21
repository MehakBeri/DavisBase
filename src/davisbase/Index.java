package davisbase;

import static davisbase.splashScreen.splashScreen;
import java.util.Scanner;

/**
 * * Main file of the project. Start from here.

 * @author Mehak Beri
 */
public class Index{

	
	static String prompt = "davisql> ";
	static String version = "v 1.0.0";
	static String copyright = "©2017 Mehak Beri";
	static boolean isExit = false;
	/*
	 * Page size for all files is 512 bytes by default.
	 * You may choose to make it user modifiable
	 */
	static long pageSize = 512; 

	/* 
	 *  The Scanner class is used to collect user commands from the prompt
	 *  There are many ways to do this. This is just one.
	 *
	 *  Each time the semicolon (;) delimiter is entered, the userCommand 
	 *  String is re-populated.
	 */
	static Scanner scanner = new Scanner(System.in).useDelimiter(";");
	
	/** ***********************************************************************
	 *  Main method
     * @param args
	 */
    public static void main(String[] args) {

		/* Display the welcome screen */
		splashScreen();

		/* Variable to collect user input from the prompt */
		String userCommand = ""; 

		while(!isExit) {
			System.out.print(prompt);
			/* toLowerCase() renders command case insensitive */
			userCommand = scanner.next().replace("\n", "").replace("\r", "").trim().toLowerCase();
			
			parseCommand.parseUserCommand(userCommand);
		}
		System.out.println("Exiting...");


	}

	
	
		

	
	
	
}
