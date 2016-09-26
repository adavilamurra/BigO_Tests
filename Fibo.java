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

public class Fibo {
  Fibo(){
  }
  
  //get nth fibonacci number with iteration
  public int iteraFibo(int n){
    int prev = 0;
    int next = 1; 
    int result = 0;
    for (int i = 1; i < n; i++) {
        result = prev + next;
        prev = next;
        next = result;
    }
    return result;
  }
  
  //get nth fibonacci number with recursion
  public int recursFibo(int n){
    if(n == 0 || n == 1) return n;
    return recursFibo(n - 1) + recursFibo(n - 2);
  }
  
}