/* File: NutritionInfo.java
 * Author: Vanessa Abrahams
 * Date: November 16, 2017
 * Purpose: Provide Java code for a simple class of your choice. Be sure to include at least one constructor, two methods and two fields. The fields should be private.
Create a test class to construct and call the methods of your class.
 */

public class PeopleInfo {
    public static void main(String[] args) {
        //
        NutritionInfo george = new NutritionInfo("George");
	george.setName("George");
	george.setAge(40);
	george.setBmi(20);
	george.setCalories(2400);

	NutritionInfo carrie = new NutritionInfo("Carrie");
	carrie.setName("Carrie");
	carrie.setAge(23);
	carrie.setBmi(22);
	carrie.setCalories(2000);

	 // Print results
   	 System.out.println(george.getName() + " is " + george.age + " years old ");
	 System.out.println(george.getName() + " has a BMI of " + george.bmi);
    	 System.out.println(george.getName() + " should consume 2400 calories a day."); 

	 System.out.println(carrie.getName() + " is " + carrie.age + " years old ");
	 System.out.println(carrie.getName() + " has a BMI of " + carrie.bmi);
    	 System.out.println(carrie.getName() + " should consume 2000 calories a day."); 

    }
}
