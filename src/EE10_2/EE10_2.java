package EE10_2;

import java.util.TreeSet;
import EE10_2.TextIO;

import java.util.TreeSet;


/**
 * This program is a very simple "set calculator" that can compute
 * the intersection, union, and set difference of two sets of 
 * non-negative integers.  Each line of the user's input contains two 
 * such sets, separated by one of the operators +, *, or -, standing
 * for union, intersection, and set difference respectively.  A set
 * must be given in the form of a list of non-negative integers, separated
 * by commas, and enclosed in square brackets.  For example:
 * [1, 2, 3] + [4, 3, 10, 0].  Spaces can occur anywhere in the input.
 * If an error is found in the input, the program will report it.
 * The program ends when the user inputs an empty line.
 *
 * This program is mainly a demonstration of Sets.
 */


public class EE10_2 {

   public static void main(String[] args) {

      while (true) {
         char ch;
         System.out.print("\n? ");
         TextIO.skipBlanks();
         
         calc(); // Reads and processes one line of input.
         
         do {  // Copy extra characters on line to output.  If there 
               // was no error, then the only character that is copied
               // is the end-of-line character.
            ch = TextIO.getAnyChar();
            System.out.print(ch);
         } while (ch != '\n');
      }

   } // end main()


   /**
    * Read a line of input, consisting of two sets separated by
    * an operator.  Perform the operation and output the value.
    * If any syntax error is found in the input, an
    * IllegalArgumentException is thrown
    */
   private static void calc() {

      TreeSet<Integer> A, B;  // The two sets of integers.
      char op;                // The operator, +, *, or -.

      A = readSet(); 
      TextIO.skipBlanks();
      op = TextIO.getAnyChar(); 
      B = readSet(); 
      TextIO.skipBlanks();
      if (TextIO.peek() == '\n' && (op=='*' | op=='+' | op=='-')){
      if (op == '+')
         A.addAll(B);     // Union.
      else if (op == '*')
         A.retainAll(B);  // Intersection.
      else
         A.removeAll(B);  // Set difference.
      }
      
      System.out.print("Value:  " + A);

   } // end calc()


   /**
    * Reads a set of non-negative integers from standard input,
    * and stores them in a TreeSet that contains objects belonging
    * to the wrapper class Integer.  The set must be enclosed
    * between square brackets and must contain a list of zero or
    * more non-negative integers, separated by commas.  Spaces 
    * are allowed anywhere.  If the input is not of the correct
    * form, an IllegalArgumentException is thrown.
    */
   private static TreeSet<Integer> readSet() {

      TreeSet<Integer> set = new TreeSet<Integer>();  // The set that will be read.

      TextIO.skipBlanks();
      if (TextIO.peek() != '[')
         throw new IllegalArgumentException("Expected '[' at start of set.");
      TextIO.getAnyChar(); // Read the '['.
      TextIO.skipBlanks();
      if (TextIO.peek() == ']') {
            // The set has no integers.  This is the empty set, which
            // is legal.  Return the value.
         TextIO.getAnyChar(); // Read the ']'.
         return set;
      }

      while (true) {
            // Read the next integer and add it to the set.
         TextIO.skipBlanks();
         if (Character.isDigit(TextIO.peek()));
         int n = TextIO.getInt(); // Read the integer.
         set.add( new Integer(n) );
         TextIO.skipBlanks();
         if (TextIO.peek() == ']')
            break;  // ']' marks the end of the set.
         else if (TextIO.peek() == ',')
            TextIO.getAnyChar(); // Read a comma and continue.
      }

      TextIO.getAnyChar(); // Read the ']' that ended the set.

      return set;

   } // end readSet()


} 