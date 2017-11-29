/*
* File: DoubleArraysResponse.java
* Name: Stephen Makowski
* Date: Nov 26, 2017
* Purpose: Response code to Fallon Hunt's Post for Arrays discussion
*/

//Import java class
import java.util.Arrays;

/**
* DoubleArrays.java
*/

public class DoubleArraysResponse {
  public static void main(String[] args){
     //Array stores the double primitive type
    double[] jewelryPrice = new double[] {100.32, 987.22, 55.0, 548.12, 1000.19};
     //Prints the length of the array
    System.out.println("Length of jewelryPrice array: " + jewelryPrice.length);

    for (int i = 0; i < jewelryPrice.length; i++) {
      System.out.println("Element at index " + i + " is " + jewelryPrice[i] + ".");
    }
   }
}
