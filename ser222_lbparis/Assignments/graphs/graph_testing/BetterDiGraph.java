package graph_testing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implementation of EditableDiGraph utilizing HashMaps.
 *
 * @author paris, Acuna
 */
public class BetterDiGraph implements EditableDiGraph {
    private int V;
    private int E;
    private HashMap<Integer, LinkedList<Integer>> adj;

    public BetterDiGraph() {
        this.V = 0;
        this.E = 0;
        this.adj = new HashMap<>();
    }

    /**
     * Adds an edge between two vertices, v and w. If vertices do not exist,
     * adds them first.
     *
     * @param v source vertex
     * @param w destination vertex
     */
    @Override
    public void addEdge(int v, int w) {
        if (!adj.containsKey(v)) {
            addVertex(v);
        }

        if (!adj.containsKey(w)) {
            addVertex(w);
        }

        adj.get(v).push(w);
        E++;
    }

    /**
     * Adds a vertex to the graph. Does not allow duplicate vertices.
     *
     * @param v vertex number
     */
    @Override
    public void addVertex(int v) {
        if (!adj.containsKey(v)) {
            adj.put(v, new LinkedList<>());
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
    public Iterable<Integer> getAdj(int v) {
        return adj.get(v);
    }

    /**
     * Number of edges.
     *
     * @return edge count
     */
    @Override
    public int getEdgeCount() {
        return this.E;
    }

    /**
     * Returns the in-degree of a vertex.
     *
     * @param v vertex
     * @return in-degree.
     * @throws NoSuchElementException exception thrown if vertex does not exist.
     */
    @Override
    public int getIndegree(int v) throws NoSuchElementException {
        if (!adj.containsKey(v)) {
            throw new NoSuchElementException();
        }

        int count = 0;

        for (Integer i : vertices()) {
            if (i != v) {
                if (adj.get(i).contains(v)) {
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
    public int getVertexCount() {
        return this.V;
    }

    /**
     * Removes edge from graph. If vertices do not exist, does not remove edge.
     *
     * @param v source vertex
     * @param w destination vertex
     */
    @Override
    public void removeEdge(int v, int w) {
        if (!adj.containsKey(v)) {
            return;
        }

        LinkedList<Integer> source = adj.get(v);
        int index = source.indexOf(w);
        if (index != -1) {
            source.remove(index);
            E--;
        }
    }

    /**
     * Removes vertex from graph. If vertex does not exist, does not try to
     * remove it.
     *
     * @param v vertex
     */
    @Override
    public void removeVertex(int v) {
        if (!adj.containsKey(v)) {
            return;
        }

        for (Integer i : adj.keySet()) {
            if (i != v) {
                int destIndex = adj.get(i).indexOf(v);
                if (destIndex != -1) {
                    removeEdge(i, v);
                }
            }
        }

        adj.remove(v);
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

//	@Override
	public boolean isEmpty() 
	{		
		if (this.V > 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
//	@Override
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