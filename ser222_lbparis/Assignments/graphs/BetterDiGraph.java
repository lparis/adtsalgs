import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implementation of EditableDiGraph utilizing HashMaps.
 *
 * @author lbparis, Acuna
 * @version 1.0
 * @date 2023-02-26
 */
public class BetterDiGraph implements EditableDiGraph 
{
	// Class member vars
    private int V; 	// Nodes
    private int E;	// Edges
    // HashMap is key/value pair, key is Int, value is LinkedList array that contains adjacent nodes
    private HashMap<Integer, LinkedList<Integer>> adj; 

    /**
     * CONSTRUCTOR
     * 
     * Default constructor takes no args and 
     * creates empty digraph and adjacency hashmap
     */
    public BetterDiGraph() 
    {
        this.V = 0;	// Nodes
        this.E = 0; // Edges
        this.adj = new HashMap<>(); // Key (int) / Value (Adjacency list) 
    }

    /**
     * Adds an edge between two vertices, v and w. 
     * If vertices do not exist, adds them first.
     *
     * @param v source vertex/node
     * @param w destination vertex/node
     */
    @Override
    public void addEdge(int v, int w) 
    {
        if (!adj.containsKey(v)) 
        {
            addVertex(v);
        }

        if (!adj.containsKey(w)) 
        {
            addVertex(w);
        }
        
        // Update hashmap
        adj.get(v).push(w);
        
        // Increment edge count
        E++;
    }

    /**
     * Adds a vertex to the graph. 
     * Does not allow duplicate vertices.
     *
     * @param v vertex number
     */
    @Override
    public void addVertex(int v) 
    {
        if (!adj.containsKey(v)) 
        {
        	// Add vertex
            adj.put(v, new LinkedList<>());
            
            // Increment node count
            V++;
        }
    }

    /**
     * Returns the direct successors of a vertex v.
     *
     * @param v vertex
     * @return successors of v
     */
    @Override
    public Iterable<Integer> getAdj(int v) 
    {
        return adj.get(v);
    }

    /**
     * Number of edges.
     *
     * @return edge count
     */
    @Override
    public int getEdgeCount() 
    {
        return this.E;
    }

    /**
     * Returns the in-degree of a vertex/node.
     *
     * @param v vertex/node
     * @return in-degree (number of edges coming into the vertex/node)
     * @throws NoSuchElementException exception thrown if vertex does not exist.
     */
    @Override
    public int getIndegree(int v) throws NoSuchElementException 
    {
    	// Check that source vertex/node is present
        if (!adj.containsKey(v)) 
        {
            throw new NoSuchElementException();
        }

        int count = 0;

        // Loop over adj list for source node and count edge connections
        for (Integer i : vertices()) 
        {
            if (i != v) 
            {
                if (adj.get(i).contains(v)) 
                {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Returns number of vertices.
     *
     * @return vertex count
     */
    @Override
    public int getVertexCount() 
    {
        return this.V;
    }

    /**
     * Removes edge from graph. 
     * If vertices do not exist, does not remove edge.
     *
     * @param v source vertex
     * @param w destination vertex
     */
    @Override
    public void removeEdge(int v, int w) 
    {
    	// If key not present, don't do anything
        if (!adj.containsKey(v)) 
        {
            return;
        }

        // Else get the source node
        LinkedList<Integer> source = adj.get(v);
        
        // Get the source dest node
        int index = source.indexOf(w);
        
        // Remove the edge
        if (index != -1) 
        {
            source.remove(index);
            
            // decrement edge count
            E--;
        }
    }

    /**
     * Removes vertex from graph. 
     * If vertex does not exist, does not try to remove it.
     *
     * @param v vertex
     */
    @Override
    public void removeVertex(int v) 
    {
        if (!adj.containsKey(v)) 
        {
            return;
        }

        for (Integer i : adj.keySet()) 
        {
            if (i != v) 
            {
                int destIndex = adj.get(i).indexOf(v);
                
                if (destIndex != -1) 
                {
                    removeEdge(i, v);
                }
            }
        }

        // Remove vertex/node
        adj.remove(v);
        
        // Decrement vertex/node count
        V--;
    }

    /**
     * Returns iterable object containing all vertices in graph.
     *
     * @return iterable object of vertices
     */
    @Override
    public Iterable<Integer> vertices() 
    {
        return adj.keySet();
    }
    
    /**
    * Returns false if the graph contains at least one vertex.
    *
    * @return boolean
    */
    @Override
	public boolean isEmpty() 
	{		
		if (this.V > 0)
		{
			return false;
		}
		
		else
		{
			return true;
		}
	}

    /**
    * Returns true if the graph contains a specific vertex.
    *
    * @param v vertex
    * @return boolean
    */
	@Override
	public boolean containsVertex(int v) 
	{		
		if (this.adj.containsKey(v)) 
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}