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

public class Hanoi {

   public void getMovementsHanoi(int n, char start, char temp, char end) {
       if (n == 1) {
           System.out.println("Disc " + n + " from " + start + " to " + end);
       } else {
           getMovementsHanoi(n - 1, start, end, temp);
           System.out.println("Disc " + n + " from " + start + " to " + end);
           getMovementsHanoi(n - 1, temp, start, end);
       }
   }

}