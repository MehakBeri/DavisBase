/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package davisbase;

import static davisbase.Index.davisbase_columns;
import static davisbase.Index.davisbase_tables;
import static davisbase.Index.pageSize;
import static davisbase.helpCommands.getCopyright;
import static davisbase.helpCommands.getVersion;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Mehak Beri
 */
public class splashScreen {
    /**
	 *  Display the splash screen
	 */
	public static void splashScreen() {
		System.out.println(line("-",80));
        System.out.println("Welcome to DavisBase"); // Display the string.
		System.out.println("DavisBase Version " + getVersion());
		System.out.println(getCopyright());
		System.out.println("\nType \"help;\" to display supported commands.");
		System.out.println(line("-",80));
                
                createMetaData();
	}
        
        public static String line(String s,int num) {
		String a = "";
		for(int i=0;i<num;i++) {
			a += s;
		}
		return a;
	}
        
        public static void createMetaData()
        {
            //create data directory if does not exist
            try {
                
                Files.createDirectories(Paths.get("data/catalog"));
            } catch (IOException ex) {
                Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Files.createDirectories(Paths.get("data/user_data"));
            } catch (IOException ex) {
                Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            }
            davisbase_tables.add(Arrays.asList("ROW_ID","TABLE_NAME"));
            davisbase_columns.add(Arrays.asList("ROW_ID","TABLE_NAME","COLUMN_VALUE","DATA_TYPE","COLUMN_KEY","IS_NULLABLE"));
            davisbase_tables.add(Arrays.asList("1","davisbase_tables"));
            davisbase_tables.add(Arrays.asList("2","davisbase_columns"));
            davisbase_columns.add(Arrays.asList("1","davisbase_tables","ROW_ID","CHAR","PRI","NO"));
            davisbase_columns.add(Arrays.asList("2","davisbase_tables","TABLE_NAME","CHAR","X","NO"));
            davisbase_columns.add(Arrays.asList("3","davisbase_columns","ROW_ID","CHAR","PRI","NO"));
            davisbase_columns.add(Arrays.asList("4","davisbase_columns","TABLE_NAME","CHAR","X","NO"));
            davisbase_columns.add(Arrays.asList("5","davisbase_columns","COLUMN_VALUE","CHAR","X","NO"));
            davisbase_columns.add(Arrays.asList("6","davisbase_columns","DATA_TYPE","CHAR","X","NO"));
            davisbase_columns.add(Arrays.asList("7","davisbase_columns","COLUMN_KEY","CHAR","X","NO"));
            davisbase_columns.add(Arrays.asList("8","davisbase_columns","IS_NULLABLE","CHAR","X","NO"));
            //create two system tables named davisbase_tables and davisbase_columns
            
            try {
             // Create the empty file with default permissions, etc.
                     RandomAccessFile db_tables= new RandomAccessFile("data//catalog//davisbase_tables.tbl","rw");
                     
            } catch (Exception x) {
                         System.out.println(x);
                }
             try {
             // Create the empty file with default permissions, etc.
                     RandomAccessFile db_columns= new RandomAccessFile("data//catalog//davisbase_columns.tbl","rw");
                    } catch (Exception x) {
                         System.out.println(x);
                }
            
            

        }
}
