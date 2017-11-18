/* File: NutritionInfo.java
 * Author: Vanessa Abrahams
 * Date: November 16, 2017
 * Purpose: Provide Java code for a simple class of your choice. Be sure to include at least one constructor, two methods and two fields. The fields should be private.
Create a test class to construct and call the methods of your class.
 */

public class NutritionInfoModded {
    // initialize Nutrition fields
    private String name;
    private int age;
    private short bmi;
    private int calories;
    /* If you want to instantiate classes you need to create the constructor method so
    you'll have a method to run when you use the 'new' keyword */
    public NutritionInfoModded(String n) {
      name = n; /* set name based on parameters; Note: Make sure the paramters are named similar, but different to fields to avoid variable collision */
      age = 0; /* default values here and below */
      bmi = 0;
      calories = 0;
    }

    /* You use 'set methods in PeopleInfo.java that do not exist
    make sure to include them in your class. The 'symbol not found' error that you get is
    the result of the PeopleInfo.java looking for the method in the NutritionInfo class and
    not finding it */

    /* Alternatively you can also set these fields by adding them as parameters in the
    constructor function like adding a 'name' in the above constructor */

    public void setAge(int age) {
      this.age = age;
    }
    public void setBmi(short bmi) {
      this.bmi = bmi;
    }
    public void setCalories(int calories) {
      this.calories = calories;
    }

    // getters to access field values
    public String getName() {
        return name;
    }

    public int getAge() {
        return this.age;
    }

    public short getBmi() {
        return this.bmi;
    }

    public int getCalories() {
        return this.calories;
    }

}
