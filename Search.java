/************************************************************************************
 **                                                                                **
 **    Code by: Alejandro Davila Murra                                             **
 **                                                                                **
 **    CS 2401: Elementary Data Structures and Algorithms                          **
 **    Instructor: Mahmud Shahriar Hossain                                         **
 **    TAs: Debakar Shamanta, Anthony M. Ortiz Cepeda, Andres H Olivas Aguilar     **
 **    Lab Assignment #7                                                           **
 **    Objective: The goal of this assignment is to learn about empirical          **
 **               performance testing to compare the speed of different algorithms **            
 **    Due Date: Sunday, April 3                                                   **
 **    Last modification: 4/03/2016                                                **
 **                                                                                **
 ************************************************************************************/

import java.util.*;
public class Search {
  
  public static void main(String[] args){
    //create double array
    double[] nums = createDoubleArray(1280000);
    long avg = 0;
    long temp = 0;
    long sum = 0;
    
    //Sort double array
    Arrays.sort(nums);
    
    //create random index
    int randomIndex = (int) (Math.random() * 1280001);
    
    //print linear and binary search index locations
    System.out.println("Linear Search");
    System.out.println("Location of the number: " + nums[randomIndex]);
    System.out.println(indexOfLinearSearch(nums, nums[randomIndex]));
    System.out.println();
    System.out.println("Binary Search");
    System.out.println("Location of the number: " + nums[randomIndex]);
    System.out.println(indexOfBinarySearch(nums, nums[randomIndex]));
    
    //test 30 times linear and binary search and get time taken
    System.out.print("Linear: ");
    System.out.println("Test 30 times");
    for(int i = 0; i < 30; i++){
      sum = System.nanoTime();
      int index = indexOfLinearSearch(nums, nums[randomIndex]);
      temp = System.nanoTime();
      avg += (temp - avg);
    }
    System.out.println("Average time taken: " + (avg/30));
    System.out.println();
    System.out.print("Binary: ");
    System.out.println("Test 30 times");
    avg = 0;
    for(int i = 0; i < 30; i++){
      sum = System.nanoTime();
      int index = indexOfBinarySearch(nums, nums[randomIndex]);
      temp = System.nanoTime();
      avg += (temp - avg);
    }
    System.out.println("Average time taken: " + (avg/30));
   
    //get fibonacci nth number and time taken
    Fibo fibonacci = new Fibo();
    System.out.println();
    System.out.println("Fibonacci");
    
    sum = System.nanoTime();
    int fibo = fibonacci.iteraFibo(18);
    temp = System.nanoTime();
    System.out.println("18th number: " + fibo);
    System.out.println("Time taken to get 18th fibonacci number (non recursive): " + (temp - sum));
    System.out.println();
    
    sum = System.nanoTime();
    fibo = fibonacci.recursFibo(18);
    temp = System.nanoTime();
    System.out.println("18th number: " + fibo);
    System.out.println("Time taken to get 18th fibonacci number (recursive): " + (temp - sum));
    System.out.println();
    
    //get fibonacci nth number for range of n values and time taken
    System.out.println("Range of pairs from 6th to 24th numbers: ");
    for(int i = 6; i <= 24; i+=2){
      sum = System.nanoTime();
      fibo = fibonacci.iteraFibo(i);
      temp = System.nanoTime();
      System.out.println(i + "th number: " + fibo);
      System.out.println("Time taken (non recursive): " + (temp - sum));
      sum = System.nanoTime();
      fibo = fibonacci.recursFibo(i);
      temp = System.nanoTime();
      System.out.println("Time taken (recursive): " + (temp - sum));
    }    
    
    //Towers of Hanoi
    System.out.println();
    System.out.println("Towers of Hanoi");
    Hanoi towersOfHanoi = new Hanoi();
    int discs = 2;
    for(int i = discs; i < 7; i++){
      sum = System.currentTimeMillis();
      towersOfHanoi.getMovementsHanoi(i, 'A', 'B', 'C');
      temp = System.currentTimeMillis();
      System.out.println("Time taken with " + i + " discs: " + (temp - sum));
    }
    
  }
  
  //crate a double array with a number of elements
  public static double[] createDoubleArray(int numElements){
    double[] array = new double[numElements];
    for(int i = 0; i < array.length; i++){
      array[i] = Math.random() * 101.0 + 0.0;
    }
    return array;
  }
  
  //get index of searchee with linear search
  public static int indexOfLinearSearch(double[] array, double searchee){
    for(int i = 0; i < array.length; i++){
      if(array[i] == searchee) return i;
    }
    return -1;
  }
  
  //get index of searchee with binary search
  public static int indexOfBinarySearch(double[] array, double searchee){
    int low = 0;
    int high = array.length - 1;
    int mid = (low + high) / 2;
    while(low <= high && array[mid] != searchee){
      if(array[mid] < searchee) low = mid - 1;
      else high = mid - 1;
      mid = (low + high) / 2;
    }
    if(low > high) mid = -1;
    return mid;
  }

}