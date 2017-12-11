import java.util.Scanner;
import java.util.ArrayList;

public class StatesDataEntry {
	// states data information
	private final String[][] statesData = {
	        {"Alabama", "Yellowhammer", "Camelia"},
	        {"Alaska", "Willow Ptarmigan", "Forget Me Not"},
	        {"Arizona", "Cactus Wren", "Saguaro Cactus Blossom"},
	        {"Arkansas", "Mockingbird", "Apple Blossom"},
	        {"California", "California Valley Quail", "Golden Poppy"},
	        {"Colorado", "Lark Bunting", "Rocky Mountain Columbine"},
	        {"Connecticut", "Robin", "Mountain Laurel"},
	        {"Delaware", "Blue Hen Chicken", "Peach Blossom"},
	        {"Florida", "Mockingbird", "Orange Blossom"},
	        {"Georgia", "Brown Thrasher", "Cherokee Rose"},
	        {"Hawaii", "Nene", "Hawaiian Hibiscus"},
	        {"Idaho", "Mountain Bluebird", "Syringa, mock orange"},
	        {"Illinois", "Cardinal", "Violet"},
	        {"Indiana", "Cardinal", "Peony"},
	        {"Iowa", "Eastern Goldfinch", "Wild Praire Rose"},
	        {"Kansas", "Western Meadowlark", "Sunflower"},
	        {"Kentucky", "Cardinal", "Goldenrod"},
	        {"Louisiana", "Eastern Brown Pelican", "Magnolia"},
	        {"Maine", "Chickadee", "Pine Cone and Tassel"},
	        {"Maryland", "Baltimore Oriole", "Black Eyed Susan"},
	        {"Massachusetts", "Chickadee", "Mayflower"},
	        {"Michigan", "Robin", "Apple Blossom"},
	        {"Minnesota", "Common Loon", "Pink and White Ladys Slippper"},
	        {"Mississippi", "Mockingbird", "Magnolia"},
	        {"Missouri", "Bluebird", "Hawthorn"},
	        {"Montana", "Western Meadowlark", "Bitterroot"},
	        {"Nebraska", "Western Meadowlark", "Goldenrod"},
	        {"Nevada", "Mountain Bluebird", "Sagebrush"},
	        {"New Hampshire", "Purple Finch", "Purple Lilac"},
	        {"New Jersey", "Eastern Goldfinch", "Violet"},
	        {"New Mexico", "Roadrunner", "Yucca Flower"},
	        {"New York", "Bluebird", "Rose"},
	        {"North Carolina", "Cardinal", "Flowering Dogwood"},
	        {"North Dakota", "Western Meadowlark", "Wild Praire Rose"},
	        {"Ohio", "Cardinal", "Scarlet Carnation"},
	        {"Oklahoma", "Scissor tailed Flycatcher", "Oklahoma Rose"},
	        {"Oregon", "Western Meadowlark", "Oregon Grape"},
	        {"Pennsylvania", "Ruffed Grouse", "Mountain Laurel"},
	        {"Rhode Island", "Rhode Island Red", "Violet"},
	        {"South Carolina", "Great Carolina Wren", "Yellow Jessamine"},
	        {"South Dakota", "Ring-necked Pheasant", "Pasque Flower"},
	        {"Tennessee", "Mockingbird", "Purple Passionflower"},
	        {"Texas", "Mockingbird", "Bluebonnet"},
	        {"Utah", "Common American Gull", "Sego Lily"},
	        {"Vermont", "Hermit Thrush", "Red Clover"},
	        {"Virginia", "Cardinal", " American Dogwood"},
	        {"Washington", "Willow Goldfinch", "Coast Rhododendrum"},
	        {"West Virginia", "Cardinal", "Rhododendron"},
	        {"Wisconsin", "Robin", "Wood Violet"},
	        {"Wyoming", "Western Meadowlark", "Indian Paintbrush"}
	    };
	// arraylist to hold searched for data
	private ArrayList<Integer> searchedStates = new ArrayList<Integer>();
	
	//method to search for state in data
	private void searchForState(String state) {
		// iterate through 2d array
		for (int i = 0; i < statesData.length; i++) {
			if (statesData[i][0].equalsIgnoreCase(state.trim())) { // if search term found
				searchedStates.add(i); // add to searched arraylist and end 
				System.out.println("Added '" + state + "'."); 
				return;
			}
		}
		System.out.println("'" + state + "' could not be found."); // if not found notify user
	}
	
	public void enterData() {
		Scanner scan = new Scanner(System.in);
		String name = "";
		// declare array list to hold states entered
		while (true) {
			System.out.println("Enter a State or None to exit:");
			name = scan.nextLine();
			// scan name 
			if (name.equalsIgnoreCase("none")) { // if name is none then end data entry
				break;
			} else {
				searchForState(name);
			}
		}
		scan.close();
	}
	
	public void printData() {
		// print results headers
		System.out.println("");
		System.out.println("**** Thank you *****");
		System.out.println("A summary report for each State, Bird, and Flower is:");
		
		// iterate through searched states, and print line of data
		for (int i = 0; i < searchedStates.size(); i++) {
			// call printInfo for each state in statesData to print data
			System.out.println(statesData[searchedStates.get(i)][0] + ", " + 
			statesData[searchedStates.get(i)][1] +", " + 
			statesData[searchedStates.get(i)][2]);
		}
		
		System.out.println("Please vist our site again!");
	}
}
