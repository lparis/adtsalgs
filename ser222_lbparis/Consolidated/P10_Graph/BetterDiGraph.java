import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Implements an editable graph with sparse vertex support.
 * 
 * @author lbparis
 */
public class BetterDiGraph implements EditableDiGraph 
{
	private HashMap<Integer, HashSet<Integer>> adjacencyMap;
	private int numVertices; 	// Number of nodes
	private int numEdges;		// Number of lines 
	
	/**
	 * DEFAULT CONSTRUCTOR
	 * 
	 * Takes no arguments
	 * Creates an empty graph from a HashMap
	 */
	public BetterDiGraph() 
	{
		this.adjacencyMap = new HashMap<>();
	}
	
    /**
     * Adds an edge between two vertices, v and w. 
     * If vertices do not exist, adds them first.
     *
     * @param v source vertex
     * @param w destination vertex
     */
	@Override
	public void addEdge(int v, int w) 
	{
		addVertex(v);
		addVertex(w);
		
		if (this.adjacencyMap.containsKey(v)) 
		{
			if (!this.adjacencyMap.get(v).contains(w)) 
			{
				this.adjacencyMap.get(v).add(w);
				this.numEdges++;
				return;
			}
		}
		return;
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
		if (!this.adjacencyMap.containsKey(v)) 
		{
			this.adjacencyMap.put(v, new HashSet<>());
			this.numVertices++;
			return;
		}
		return;
	}

    /**
     * Returns the direct successors of a vertex v.
     *
     * @param v vertex
     * @return successors of v
     */
	@Override
	public Iterable getAdj(int v) 
	{
		return this.adjacencyMap.get(v);
	}

    /**
     * Number of edges.
     *
     * @return edge count
     */
	@Override
	public int getEdgeCount() 
	{
		return this.numEdges;
	}

	/**
     * Returns the in-degree of a vertex.
     * 
     * @param v vertex
     * @return in-degree.
     * @throws NoSuchElementException exception thrown if vertex does not exist.
     */
	@Override
	public int getIndegree(int v) throws NoSuchElementException 
	{
		if (!containsVertex(v)) 
		{
			throw new NoSuchElementException();
		}

		List<Integer> inList = new ArrayList<Integer>();
		
		for (Integer to : this.adjacencyMap.keySet()) 
		{
			for (Integer e : this.adjacencyMap.get(to))
			{
				if (e.equals(v))
				{
					inList.add(to);
				}
			}
		}
		return inList.size();
	}

    /**
     * Returns number of vertices.
     * @return vertex count
     */
	@Override
	public int getVertexCount() 
	{
		return this.numVertices;
	}

    /**
     * Removes edge from graph. If vertices do not exist, does not remove edge.
     *
     * @param v source vertex
     * @param w destination vertex
     */
	@Override
	public void removeEdge(int v, int w) 
	{
		if (this.adjacencyMap.containsKey(v) && this.adjacencyMap.containsKey(w)) 
		{
			if (this.adjacencyMap.get(v).contains(w)) 
			{
				this.adjacencyMap.get(v).remove(w);
				this.numEdges--;
				return;
			}
		}
		return;
	}

	/**
     * Removes vertex from graph. 
     * If vertex does not exist, does not try to remove it.
     *
     * @param v vertex
     */
	@Override
	public void removeVertex(int vertex) 
	{
		if (this.adjacencyMap.containsKey(vertex)) 
		{
			this.adjacencyMap.remove(vertex);
			
			for (Map.Entry<Integer, HashSet<Integer>> entry : this.adjacencyMap.entrySet()) 
			{
				if (entry.getValue().contains(vertex)) 
				{
					this.adjacencyMap.get(entry.getKey()).remove(vertex);
				}
			}
			this.numVertices--;
			return;
		}
		return;
	}

    /**
     * Returns iterable object containing all vertices in graph.
     *
     * @return iterable object of vertices
     */	
	@Override
	public Iterable vertices() 
	{	
		List<Integer> inList = new ArrayList<Integer>();
		
		for (Integer to : this.adjacencyMap.keySet()) 
		{
			if (!inList.contains(to))
			{
				inList.add(to);
			}
		}
		return inList;
	}

    /**
    * Returns false if the graph contains at least one vertex.
    *
    * @return boolean
    */	
	@Override
	public boolean isEmpty() 
	{
		return this.numVertices == 0;
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
		if (this.adjacencyMap.containsKey(v)) 
		{
			return true;
		}
		return false;
	}
}