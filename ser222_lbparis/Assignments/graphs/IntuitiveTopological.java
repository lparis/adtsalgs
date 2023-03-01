import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implementation of TopologicalSort to not rely on DFS
 *
 * @author lbparis, Sedgewick and Wayne, Acuna
 * @version 1.0
 * @date 2023-02-26
 */
public class IntuitiveTopological implements TopologicalSort 
{
    private Iterable<Integer> order;
    
    /**
     * Constructor  
     * 
     * Takes as input a BetterDiGraph typed object
     * and calls method topologyOrder()
     * 
     * @param diGraph
     */
    public IntuitiveTopological(BetterDiGraph diGraph) 
    {
        topologyOrder(diGraph);
    }

    /**
     * IntuitiveToplogical algorithm
     * - Looks at graph
     * - Pick node with in-degree zero (no edges)
     * - Add node to topological ordering
     * - Remove node from graph
     * 
     * @param diGraph
     */
    private void topologyOrder(BetterDiGraph diGraph) 
    {
        LinkedList<Integer> topologyOrder = new LinkedList<>();
        
//        while (diGraph.containsVertex(0)) 
        while (diGraph.getVertexCount() > 0) 
        {
            HashMap<Integer, Integer> indegreesMap = getIndegreesMap(diGraph);
            
            for (Integer i : indegreesMap.keySet()) 
            {
                if (indegreesMap.get(i) == 0) 
                {
                    topologyOrder.add(i);
                    
                    diGraph.removeVertex(i);
                }
            }
        }
        order = topologyOrder;
    }

    /**
     * Create HashMap from graph vertices
     * 
     * @param diGraph
     * @return map
     */
    private HashMap<Integer, Integer> getIndegreesMap(BetterDiGraph diGraph) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer i : diGraph.vertices()) 
        {
            map.put(i, diGraph.getIndegree(i));
        }
        return map;
    }

    /**
     * Returns an iterable object containing a topological sort.
     *
     * @return a topological sort.
     */
    @Override
    public Iterable<Integer> order() 
    {
        return order;
    }

    /**
     * Returns true if the graph being sorted is a DAG, false otherwise.
     *
     * @return is graph a DAG
     */
    @Override
    public boolean isDAG() 
    {
        return order == null;
    }
}