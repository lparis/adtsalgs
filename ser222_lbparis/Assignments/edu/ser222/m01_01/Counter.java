package edu.ser222.m01_01;
/**
 * This program implements Counter
 *
 * @author lbparis@asu.edu
 * @version 1.0
 */

class Counter implements CounterInterface
{
   String id;
   int count;

   //Constructor
   Counter(String i)
   {
       id = i;
       count = 0;
   }

   @Override
public void increment()
   {
      count++;
   }

   @Override
public int tally()
   {
      return count;
   }

   @Override
public String toString()
   {
      return "ID: "+id+" Counter: "+count;
   }

}