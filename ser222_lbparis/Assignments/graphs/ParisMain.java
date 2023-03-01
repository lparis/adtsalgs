import java.io.*;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Program for generating kanji component data graph 
 * that is ordered using topological sort.
 *
 * @author lbparis, Acuna
 * @version 1.0
 * @date 2023-02-26
 */
public class ParisMain 
{
	// Class variables
	
	// Files are constants
    private static final String DATA_KANJI = "data-kanji.txt";
    private static final String DATA_COMPONENTS = "data-components.txt";
    
    // BetterDiGraph type
    private BetterDiGraph aDiGraph;

    /**
     * Entry point for testing.
     *
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) 
    {
    	// Call run(), DiGraph not static
        new ParisMain().run();        
    }

    private void run()
    {
    	// Create instance of BetterDiGraph
        aDiGraph = new BetterDiGraph();
        
        try 
        {
        	// Load data-kanji.txt
        	BufferedReader indexReader = getBufferedReader(DATA_KANJI);
        	
        	// Method call with data-kanji.txt as input for HashMap 
        	// Method returns populated HashMap
            HashMap<Integer, Integer> kanjiMap = processDataKanji(indexReader);
            
            // Close buffer
            indexReader.close();
            
            // Print original contents
            System.out.println("Original:");
            
            // Print HashMap
            for (Integer i : aDiGraph.vertices()) 
            {
                printFormatted(kanjiMap, i);
            }
            
            // Read in data-components.txt
            indexReader = getBufferedReader(DATA_COMPONENTS);
            
            // method call for processing
            processDataComponents(indexReader);

            // Close buffer reader            
            indexReader.close();
            
            // Check if graph is empty (testing)
            checkIfEmpty();            

            // Call IntuitiveToplogical for sorting and pass in the populated
            TopologicalSort topologicalSort = new IntuitiveTopological(aDiGraph);

            // Output the sorted graph
            System.out.println("\nSorted:");
            
            // Loop over the sorted graph
            for (Integer i : topologicalSort.order()) 
            {
                printFormatted(kanjiMap, i);
            }
            
            System.out.println(); // Empty line             
        } 
        
        catch (IOException e) 
        {
            System.out.println("File not found");
        }
    }

    /**
     * 
     * Method that populates HashMap from data Kani file 
     * Maps IDs to chars and adds the IDs as nodes in the graph
     * 
     * @param reader
     * @return hashmap populated
     * @throws NoSuchElementException
     * 
     */
    private HashMap<Integer, Integer> processDataKanji(BufferedReader reader) throws NoSuchElementException     
    {
    	// Create new HashMap
        HashMap<Integer, Integer> hashmap = new HashMap<>();

    	// Read first line
        try 
        {
			reader.readLine();
		} 
        
        catch (NoSuchElementException | IOException e) 
        {
        	System.out.println("Cannot read file");
			e.printStackTrace();
		} 		
        
        // Set currentLine (which is the first line) equal to null
        String currentLine = null;		
        
        // Now while current line is not null (i.e., not the first line), read the rest of the file
        try 
        {
			while ((currentLine = reader.readLine()) != null) 
			{
				// Process line by line unless prefixed with # (i.e., comment)
			    if (!currentLine.substring(0, 1).equals("#")) 
			    {
			    	// Tab-delimited, split line at the tab
			        String[] splitString = currentLine.split("\t");
			        
			        // ID is the key
			        int id = Integer.parseInt(splitString[0]);
			        
			        // Kanji char is the value
			        int kanjiId = Character.codePointAt(splitString[1], 0);
			        
			        // Populate the HM with IDs and chars
			        hashmap.put(id, kanjiId);
			        
			        // Add IDs as nodes on the digraph
			        aDiGraph.addVertex(id);
			    }
			}
		} 
        
        catch (NumberFormatException | NoSuchElementException | IOException e)
        {
        	System.out.println("Error proessing kanji data");
			e.printStackTrace();
		}
        
        // return populated HashMap
        return hashmap;
    }

    /**
     *
     * Method that takes as input file data-components.txt
     * and uses it to add edges to the digraph
     * 
     * @param reader
     * @throws NoSuchElementException
     * 
     */
    private void processDataComponents(BufferedReader reader) throws NoSuchElementException 
    {
        String currentLine;
        
        try 
        {	
        	while ((currentLine = reader.readLine()) != null) 
			{
				// Parse the components file
			    if (!currentLine.substring(0, 1).equals("#")) 
			    {
			    	// Tab-delimited, split line/string
			        String[] splitString = currentLine.split("\t");
			        
			        // v is source node
			        int v = Integer.parseInt(splitString[0]);
			        
			        // w is destination node
			        int w = Integer.parseInt(splitString[1]);

			        // add src and dst to graph
			        aDiGraph.addEdge(v, w);
			    }
			}
		} 
        
        catch (NumberFormatException | NoSuchElementException | IOException e) 
        {
        	System.out.println("Error proessing components data");
			e.printStackTrace();
		}
    }

    /**
     * 
     * Method that returns UTF8 formated character data from input file
     * 
     * @param filename
     * @return 
     * @throws NoSuchElementException
     */
    private BufferedReader getBufferedReader(String filename) throws NoSuchElementException 
    {
    	try 
    	{
			return new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename)), "UTF8"));
		} 
    	catch (UnsupportedEncodingException e) 
    	{
    		System.out.println("Encoding error");
			e.printStackTrace();
		} 
    	catch (FileNotFoundException e) 
    	{
    		System.out.println("File not found");
			e.printStackTrace();
		}
		return null;    	
    }
    
    /**
     * Method to print formatted HashMap
     * 
     * @param map
     * @param i
     */
    private void printFormatted(HashMap<Integer, Integer> map, int i) 
    {
        System.out.print(String.valueOf(Character.toChars(map.get(i))));
    }
    
    /**
     * Helper method that checks if graph is empty
     */
    private void checkIfEmpty() 
    {
        // Test if BetterDiGraph.isEmpty()
//    	System.out.println(" ");
//    	System.out.println(" ");
//      System.out.println("Graph is empty: " + aDiGraph.isEmpty());
	}    
}