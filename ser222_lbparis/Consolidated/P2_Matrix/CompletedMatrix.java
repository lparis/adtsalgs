//package edu.ser222.m01_02;
package M1_Matrix

/**
 * An implementation of the Matrix ADT. Provides four basic operations over an immutable type.
 * 
 * Last updated 1/15/2023
 * 
 * @author lbparis, Ruben Acuna
 * @version (3.0)
 */

public class CompletedMatrix implements Matrix 
{
	// Attribute
	private int[][] data;

	// Constructor
    public CompletedMatrix(int[][] matrix) throws IllegalArgumentException
    {
    	// Check if other matrix is null
    	if(matrix == null)
    		throw new java.lang.IllegalArgumentException("Matrix cannot be null");
    	
    	// Otherwise create double array from it
        if(matrix.length == 0)
        {
        	data = new int[0][0];
        	return;
        }
        
        // Create 2D array of integers
        data = new int[matrix.length][matrix[0].length];
        // Copy the elements of the matrix into the 2D array 
        for(int i = 0; i < matrix.length; i++)
        	for(int j = 0; j < matrix[0].length; j++)
				data[i][j] = matrix[i][j];
    }

    /**
     * Returns the element at particular point in the matrix
     * 
     * @param y y position
     * @param x x position
     * @return element
     */
    @Override
    public int getElement(int y, int x) 
    {

    	return data[y][x];
    }

    /*
     * Returns the number of rows in the matrix
     * 
     * @returns rows
     */
    @Override
    public int getRows() 
    {
    	return data.length;
    }

    /**
     * Returns the number of columns in the matrix
     * 
     * @return columns
     */
    @Override
    public int getColumns() 
    {
        if(data.length == 0)
        	return 0;
        return data[0].length;
    }

    /** 
     * This Matrix returns a completed matrix scaled by a factor
     * It computes kA where k is a constant 
     * and A is a matrix (this object)
     * 
     * @param scalar scalar
     * @return matrix
     */

    @Override
    public Matrix scale(int scalar) 
    {
        // Create a CompletedMatrix object 
    	CompletedMatrix matrix = new CompletedMatrix(data);
    	
    	// Scale the matrix by a factor
    	for(int i = 0; i < matrix.getRows(); i++)
    		for(int j = 0; j < matrix.getColumns(); j++)
    			matrix.data[i][j] = scalar * data[i][j];

    	// Return the matrix
    	return matrix;
    }

    /** 
     * This Matrix returns a completed matrix added with another matrix
     * It computes A + B where A & B are matrices 
     * 
     * @param other added
     * @return matrix
     * @throws RuntimeException if matrices do not have matching dimensions
     * @throws IllegalArgumentException if other matrix is null
     */
    
    @Override
    public Matrix plus(Matrix other) 
    {
    	// Check if other matrix is null
    	if(other == null)
    		throw new IllegalArgumentException();

    	//Check if matrices do not have matching dimensions
    	if(other.getRows() != getRows() || other.getColumns() != getColumns())
    		throw new RuntimeException();
    	
    	// Create new matrixData object
    	int matrixData[][] = new int[getRows()][getColumns()];
    	
    	// Create instance object of CompletedMatrix
    	CompletedMatrix matrix = new CompletedMatrix(matrixData);
    	
    	// Perform matrix addition
    	for(int i = 0; i < matrix.getRows(); i++)
    		for(int j = 0; j < matrix.getColumns(); j++)
    			matrix.data[i][j] = data[i][j] + other.getElement(i, j);
    	
    	// Return the added matrix
    	return matrix;
    }

    /** 
     * This Matrix returns a completed matrix subtracted with another matrix
     * It computes A - B where A & B are matrices 
     * 
     * @param other subtracted
     * @return matrix
     * @throws RuntimeException if matrices do not have matching dimensions
     * @throws IllegalArgumentException if matrix is null
     */
    
    @Override
    public Matrix minus(Matrix other) 
    {
    	// Check if other matrix is null
    	if(other == null)
    		throw new IllegalArgumentException();

    	// Check if matrices do not have matching dimensions
    	if(other.getRows() != getRows() || other.getColumns() != getColumns())
    		throw new RuntimeException();
    	
    	// Create new matrixData object
    	int matrixData[][] = new int[getRows()][getColumns()];
    	
    	// Create an instance object of CompletedMatrix
    	CompletedMatrix matrix = new CompletedMatrix(matrixData);
    	
    	// Perform matrix subtraction
    	for(int i = 0; i < matrix.getRows(); i++)
    		for(int j = 0; j < matrix.getColumns(); j++)
    			matrix.data[i][j] = data[i][j] - other.getElement(i, j);
    	
    	// Return the subtracted matrix
    	return matrix;
    }

    /** 
     * This Matrix returns a completed matrix multiplied by another matrix
     * It computes A * B where A & B are matrices (using dot products)
     * 
     * @param other multiplicand
     * @return matrix
     * @throws RuntimeException if matrices do not have appropriate dimensions
     * @throws IllegalArgumentException if other matrix is null
     */
        
    @Override
    public Matrix multiply(Matrix other) 
    {
    	// Check if other matrix is null
    	if(other == null)
    		throw new IllegalArgumentException();

    	// Check if matrices do not have matching dimensions
    	if(other.getRows() != getColumns())
    		throw new RuntimeException();
    	
    	// Create matrixData object
    	int matrixData[][] = new int[getRows()][other.getColumns()];
    	
    	// Create an instance object of CompletedMatrix
    	CompletedMatrix matrix = new CompletedMatrix(matrixData);
    	
    	// Perform matrix multiplication using dot product
    	for(int i = 0; i < getRows(); i++)
    		for(int j = 0; j < other.getColumns(); j++)
    		{
    			matrix.data[i][j] = 0;
				for(int k = 0; k < getColumns(); k++)
				{
					matrix.data[i][j] += data[i][k] * other.getElement(j, k);
				}
    		}
    	
    	// Return the multiplied matrix
    	return matrix;
    }
    
	
	/**
	* This method returns true if this matrix matches another matrix
	* 
	* @param other another matrix
	* @return equality
	*/
	@Override
	public boolean equals(Object other) 
	{
		if(!(other instanceof Matrix))
			return false;
	
		// Typecast to Matrix
		Matrix matrix = (Matrix)other;
		
		// Check if matrices do not have matching dimensions
		if(matrix.getRows() != getRows() || matrix.getColumns() != getColumns())
			return false;
		
		// Check matrix by elements
		for(int i = 0; i < matrix.getRows(); i++)
			for(int j = 0; j < matrix.getColumns(); j++)
				if(data[i][j] != matrix.getElement(i, j))
					return false;
		
		// Otherwise return true 
		return true;
	}
	
	/**
	* Returns a string representation of this matrix. 
	* A new line separates each row; a space separates each column.
	* 
	* @return string representation
	*/
	@Override
	public String toString() 
	{
		String string = "";
		for(int i = 0; i < getRows(); i++) 
		{
			for(int j = 0; j < getColumns(); j++) 
			{
				string  = string + data[i][j] + " ";
			}
			string = string + "\n";
		}
		
		// Return the matrix as a string
		return string;
	}    

    /**
     * Entry point for matrix testing.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {

        //These tests show sample usage of the matrix, and some basic ideas for testing. They are not comprehensive.

        int[][] data1 = new int[0][0];
        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] data4 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] data5 = {{1, 4, 7}, {2, 5, 8}};

        Matrix m1 = new CompletedMatrix(data1);
        Matrix m2 = new CompletedMatrix(data2);
        Matrix m3 = new CompletedMatrix(data3);
        Matrix m4 = new CompletedMatrix(data4);
        Matrix m5 = new CompletedMatrix(data5);

        System.out.println("m1 --> Rows: " + m1.getRows() + " Columns: " + m1.getColumns());
        System.out.println("m2 --> Rows: " + m2.getRows() + " Columns: " + m2.getColumns());
        System.out.println("m3 --> Rows: " + m3.getRows() + " Columns: " + m3.getColumns());

        //check for reference issues
        System.out.println("m2 -->\n" + m2);
        data2[1][1] = 101;
        System.out.println("m2 -->\n" + m2);

        //test equals
        System.out.println("m2==null: " + m2.equals(null));             //false
        System.out.println("m3==\"MATRIX\": " + m2.equals("MATRIX"));   //false
        System.out.println("m2==m1: " + m2.equals(m1));                 //false
        System.out.println("m2==m2: " + m2.equals(m2));                 //true
        System.out.println("m2==m3: " + m2.equals(m3));                 //false
        System.out.println("m3==m4: " + m3.equals(m4));                 //true

        //test operations (valid)
        System.out.println("m1 + m1:\n" + m1.plus(m1));
        System.out.println("m1 + m1:\n" + m1.plus(m1));
        System.out.println("2 * m2:\n" + m2.scale(2));
        System.out.println("m2 + m3:\n" + m2.plus(m3));
        System.out.println("m2 - m3:\n" + m2.minus(m3));
        System.out.println("3 * m5:\n" + m5.scale(3));

        //not tested... multiply(). you know what to do.

        //test operations (invalid)
        //System.out.println("m1 + m2" + m1.plus(m2));
        //System.out.println("m1 + m5" + m1.plus(m5));
        //System.out.println("m1 - m2" + m1.minus(m2));
    }
}