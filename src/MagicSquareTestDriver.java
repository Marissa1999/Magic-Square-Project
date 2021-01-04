/**
 *@author Marissa Gonçalves
 * Date: February 24, 2018
 * Purpose: To run the MagicSquare program, ensuring that the methods work and display a magic square.
 */

public class MagicSquareTestDriver
{

    public static void main (String[] args)

    {

       MagicSquare ms5 = new MagicSquare(5); //create a magic square object of order 5
       System.out.println("Order: " + ms5.getOrder()); //retrieve the order from the getOrder() method from the MagicSqaure class
       System.out.println("Magic Number: " + ms5.magicNumber()); //retrieve the magic number fom the magicNumber() method from the MagicSqaure class
       System.out.println(ms5);  //print it
       System.out.println();  //line break

       //Invalid argument, so default to 3. Construct a magic square of order 3.
       MagicSquare ms = new MagicSquare(-2); //same as new MagicSquare()
       System.out.println(ms);  //should print a magic square of order 3
       System.out.println();  //line break

       MagicSquare ms11 = new MagicSquare(11); //create a magic square object of order 11

       //based on the called order, determine if the printed pattern is a magic sqaure or not, and print the necessary messages
       if (ms11.isMagicSquare())
       {
           System.out.println ("The following array of numbers is a magic square.");
       }

       else
       {
           System.out.println ("The following array of numbers is NOT a magic square.");
       }

       System.out.println(ms11); //print it
       System.out.println("Magic Number: " + ms11.magicNumber()); //retrieve the magic number fom the magicNumber() method from the MagicSqaure class

    }


}
