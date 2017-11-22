package davisbase;

import static davisbase.splashScreen.splashScreen;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
			userCommand = scanner.next().replace("\n", "").replace("\r", "").trim();
			
			parseCommand.parseUserCommand(userCommand);
		}
		System.out.println("Exiting...");


	}

	//test: create table test(col1 int primary key, col2 char, col3 int not null, col4 int);
}
