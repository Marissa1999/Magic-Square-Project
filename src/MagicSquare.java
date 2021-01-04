/**
 * @author Marissa Gonçalves
 * Date: February 24, 2018
 * Purpose: To generate a magic square using a two dimensional array, consisting of a called order that is odd and greater or equal to 3.
 */

public class MagicSquare
{
    /**
     * Allows a two-dimensional array to be created, containing rows and columns.
     */
    private final int[][] array;
    
    /**
     * Determines the number of elements in the array, for each row and column.
     */
    private final int order;

    /**
     * Ensures that the order meets specified criteria above and initializes this order and array instances.
     * @param initialOrder The called number of elements in every row and column, creating a square.
     */
    public MagicSquare(int initialOrder)
    {
        //prints an error message and increments, if the order is greater than 3, but is even
        if (initialOrder > 3 && initialOrder % 2 == 0)
        {
           ++initialOrder;
           System.out.println("Invalid argument: " + initialOrder);
           System.out.println("A default value of" + (initialOrder + 1) + "is used instead.");
        }

        //prints an error message and sets the default order to 3, if the order is less than 3
        else if (initialOrder < 3)
        {
           initialOrder = 3;
           System.out.println("Invalid argument: " + initialOrder);
           System.out.println("A default value of 3 is used instead.");
        }

        //sets the order and creates a two-dimensional array, from the called initial order
        this.order = initialOrder;
        this.array = new int[this.order][this.order];
        
        //move to a method where the magic square is produced
        makeMagicSquare();
    }

    /**
     * Prints equal-sign patterns and the magic square numbers.
     * @return The String result which prints the numbers and the equal-signed pattern.
     */
    @Override
    public String toString()
    {
        //initialize the result to an empty string
        String result = "";


        //prints an equal-sign pattern, based the number of elements
        for (int elementOrder = 1; elementOrder <= this.order; elementOrder++)
        {
            result += "=====";
        }

        //line break
        result += "\n";

        
        //for every cell in each row and column, a number is printed and formatted to a maximum of 5 spaces
        for (int row = 0; row < this.order; row++)
        {
             for (int column = 0; column < this.order; column++)
             {
                 result += String.format("%5d", this.array[row][column]);
             }
             
            //line break
            result += "\n";
        }
        
        
        //prints an equal-sign pattern, based the number of elements
        for (int elementOrder = 1; elementOrder <= this.order; elementOrder++)
        {
            result += "=====";
        }

        
        return result;
    }

    /**
     * Determines if this and other arrays are equal to one another.
     * @param other The other MagicSqaure object.
     * @return The boolean value between the comparison of the equality of this and other arrays.
     */
    public boolean equals(MagicSquare other)
    {
        if (this.array != other.array)
        {
            return false;
        }
        
      for (int row = 0; row < this.order; row++)
        {
             for (int column = 0; column < this.order; column++)
             {
                 if (this.array[row][column] != other.array[row][column])
                 {
                     return false;
                 }
             } 
        }
        
          return true;
    }

    /**
     * Returns the number of elements for every row and column, thus the order.
     * @return The order of the magic square.
     */
    public int getOrder()
    {
        return this.order;
    }

    /**
     * Returns the magic number and ensures the sums that all rows, columns and diagonals have the same result.
     * @return The magic number result from the mathematical equation below.
     */
    public int magicNumber()
    {
        return (int)((Math.pow(this.order, 3) + this.order) / 2);
    }

    /**
     * Adds all cells in per row, making sure that it equals to the magic number.
     * @return The sum of elements per row.
     */
    public int rowSum()
    {
        //initialize the sum to zero
        int sum = 0;

        //return the sum from every element per row
        for (int row = 0; row < this.order; row++)
        {
            for (int k = 0; k < this.order; k++)
            {
                sum += this.array[row][k];   
            }
            
            return sum;
        }

       return sum;
    }

    /**
     * Adds all cells in per column, making sure that it equals to the magic number.
     * @return The sum of elements per column.
     */
    public int columnSum()
    {
        //initialize the sum to zero
        int sum = 0;

        //return the sum from every element per column
        for (int column = 0; column < this.order; column++)
        {
             for (int k = 0; k < this.order; k++)
             {
                 sum += this.array[k][column];
             }
             
             return sum;
        }

       return sum;
    }

    /**
     * Adds all cells from the left-diagonal, making sure that it equals to the magic number.
     * @return The sum of elements in the left-diagonal.
     */
    public int mainDiagonalSum()
    {
        //initialize the sum to zero
        int sum = 0;

        //return the sum of all elements contained from the left-diagonal
        for (int k = 0; k < this.order; k++)
        {
            sum += this.array[k][k];
        }

       return sum;
    }

    /**
     * Adds all cells from the right-diagonal, making sure that it equals to the magic number.
     * @return The sum of elements in the right-diagonal.
     */
    public int subDiagonalSum()
    {
        //initialize the sum to zero
        int sum = 0;

        //return the sum of all elements contained from the right-diagonal
        for (int k = 0; k < this.order; k++)
        {
            sum += this.array[k][(this.order - 1)- k];
        }

       return sum;
    }

    /**
     * Returns whether every row, column and diagonals are equal to the magic number.
     * @return The boolean result indicating the equality to the magic number or not.
     */
    public boolean isMagicSquare()
    {  
        int magicalNumber = magicNumber();
        return rowSum() == magicalNumber
               && columnSum() == magicalNumber
               && mainDiagonalSum() == magicalNumber
               && subDiagonalSum() == magicalNumber;
    }

    /**
     * Creates the magic square pattern and fills every cell from this array.
     */
    public final void makeMagicSquare()
    {
        //start at the top row and middle cell
        int row = 0;
        int column = this.order / 2;

        
        //prints out the numbers until it reaches the sqaured result of the order
        for (int k = 1; k <= this.order * this.order; k++)
        {
            
             //set k to this array
             this.array[row][column] = k;
             
             
             //save the row and column values for array bounds checking situations
             int saveRow = row;
             int saveColumn = column;
              
             
             //move diagonally up by one cell to the right
	     row--;
             column++;
            
            
             
            //bounds checking for top-right cell
            if ((row < 0 && column == this.order))
            {
                row = saveRow;
                column = saveColumn;
                row++;
            }
            
            
            
            //bounds checking for the top row
            else if (row < 0)
            {
		row = this.order - 1;  
	    }

            
            //bounds checking for the rightmost column
            else if (column == this.order)
	    {
		column = 0;
            }
            
          
            //bounds checking for occupied cells
            if (this.array[row][column] != 0)
            {
                row += 2; 
                column--;     
            }
          
            
        }

    }


    
}