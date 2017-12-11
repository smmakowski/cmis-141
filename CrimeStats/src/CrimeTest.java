import java.io.*;
import java.util.Scanner;

public class CrimeTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Crime crimeData = new Crime();
		try {
			crimeData.readCrimeData("data/Crime.csv");
		} catch (FileNotFoundException e) {
			System.exit(1);
		}
		
	}

}
