import java.util.HashMap;

/**
 * Implements a topological graph search.
 * 
 * @author lbparis
 */
public class IntuitiveTopological implements TopologicalSort
{
	/** 
	 * CONSTRUCTOR 
	 * Takes a BetterDiGraph typed object as input
	 * 
	 * @param bdg
	 */
	public IntuitiveTopological(BetterDiGraph bdg) 
	{
		// TODO
		// Intuitive- Topological
		// This algorithm works as follows: 
		// look at your graph, pick out a node with in-degree zero, 
		// add it to the topological ordering, and remove it from the graph. 
		// This process repeats until the graph is empty.
	}


	@Override
	public Iterable<Integer> order() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDAG() 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
