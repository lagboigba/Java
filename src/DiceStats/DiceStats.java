package DiceStats;

import DiceStats.StatCalc;
import DiceStats.Dice;



/**
 * This program performs the following type of experiment:  Given a desired 
 * total roll, such as 7, roll a pair of dice until the given total comes up, 
 * and count how many rolls are necessary.  Now do that over and over, and
 * find the average number of rolls.  The number of times the experiment is 
 * repeated is given by the constant, NUMBER_OF_EXPERIMENTS.  The average is
 * computed and printed out for each possible roll = 2, 3, ..., 12. 
 */

public class DiceStats {

   /**
    * The number of times that the experiment "roll for a given total"
    * is to be repeated.  The program performs this many experiments, and
    * prints the average of the result, for each possible roll value, 
    */
   public static final int NUMBER_OF_EXPERIMENTS = 10000;

   public static void main(String[] args) {
       StatCalc stats;  // The average number of rolls to get a given total.
       System.out.println("Total On Dice     Average Number of Rolls     Standard Deviation     	Max");
       System.out.println("-------------     -----------------------");
       for ( int dice = 2;  dice <= 12;  dice++ ) {
    	   StatCalc sc = new StatCalc();
    	   sc.enter(dice);
          stats = getAverageRollCount(dice);
          /*average = stats.getMean();*/
          System.out.println("	"+dice +"		"+ stats.getMean() +"			"+ stats.getStandardDeviation() +"	"+
        		  stats.getMax());
             // Use 10 spaces to output dice, and use 22 spaces to output
             // average, with 4 digits after the decimal.
       }
   } 

  
   /**
    * Find the average number of times a pair of dice must be rolled to get
    * a given total.  The experiment of rolling for the given total is
    * repeated NUMBER_OF_EXPERIMENTS times and the average number of rolls
    * over all the experiments is computed.
    * Precondition:  The given total must be be between 2 and 12, inclusive.
    * @param roll the total that we want to get on the dice
    * @return the average number of rolls that it takes to get the specified
    *    total
    **/
   public static StatCalc getAverageRollCount( int roll ) {
	   
       StatCalc sc = new StatCalc();
       for ( int i = 0;  i < NUMBER_OF_EXPERIMENTS;  i++ ) {
          sc.enter(rollFor(roll));
       }
     
       return sc;
   }
  
   
   
   /**
    * Simulates rolling a pair of dice until a given total comes up.
    * Precondition:  The desired total is between 2 and 12, inclusive.
    * @param N the total that we want to get on the dice
    * @return the number of times the dice are rolled before the
    *    desired total occurs
    * @throws IllegalArgumentException if the parameter, N, is not a number
    *    that could possibly come up on a pair of dice
    */
   public static int rollFor( int N ) {
       if ( N < 2 || N > 12 )
          throw new IllegalArgumentException("Impossible total for a pair of dice.");
       Dice dice = new Dice();  // Numbers between 1 and 6 representing the dice.
       int roll;        // Total showing on dice.
       int rollCt;      // Number of rolls made.
       rollCt = 0;
       do {
    	  dice.roll();
          rollCt++;
       } while (  dice.getTotal() != N );
       return rollCt;
   }
   
}  // end DiceRollStats
