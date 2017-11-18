/* File: NutritionInfo.java
 * Author: Vanessa Abrahams
 * Date: November 16, 2017
 * Purpose: Provide Java code for a simple class of your choice. Be sure to include at least one constructor, two methods and two fields. The fields should be private.
Create a test class to construct and call the methods of your class.
 */

public class PeopleInfoModded {
  public static void main(String[] args) {
    //
    NutritionInfoModded george = new NutritionInfoModded("George");
	  // george.setName("George"); /* commented out since you pass the name in as an argument in the constructor */
	  george.setAge(40);
	  george.setBmi((short)20); /*since shorts have no suffix (like longs, ex. 231412412414141312121L) you need to explicity cast as short*/
	  george.setCalories(2400);

    NutritionInfoModded carrie = new NutritionInfoModded("Carrie");
    // carrie.setName("Carrie"); /* commented out since you pass the name in as an argument in the constructor */
    carrie.setAge(23);
    carrie.setBmi((short)22); /*since shorts have no suffix (like longs, ex. 231412412414141312121L) you need to explicity cast as short */
    carrie.setCalories(2000);

	 // Print results
   /* You cannot use dot notation to access fields from other classes that are private.
   You might want to make them public so other fields can use them, or you can call the
   get methods you added in NutritionInfo.java to return those values */

   	System.out.println(george.getName() + " is " + george.getAge() + " years old ");
	  System.out.println(george.getName() + " has a BMI of " + george.getBmi());
    System.out.println(george.getName() + " should consume 2400 calories a day.");

  	System.out.println(carrie.getName() + " is " + carrie.getAge() + " years old ");
  	System.out.println(carrie.getName() + " has a BMI of " + carrie.getBmi());
    System.out.println(carrie.getName() + " should consume 2000 calories a day.");

    }
}
