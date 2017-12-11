import java.io.*;
import java.util.Scanner;


public class Crime {
	
	public void readCrimeData(String fileName) throws FileNotFoundException {
		Scanner scan = null;
	
		try {
			//
			scan = new Scanner(new File(fileName));
			// while there are more lines to parse
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Unable to find file");
		} finally {
			if (scan != null) {
			scan.close();
			}
		}
	}
	
	public void printMenu() {
		
	}
}
