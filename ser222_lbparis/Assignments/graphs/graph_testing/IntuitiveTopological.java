package graph_testing;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implementation of TopologicalSort to not rely on DFS
 *
 * @author paris, Sedgewick and Wayne, Acuna
 */
public class IntuitiveTopological implements TopologicalSort {
    private Iterable<Integer> order;

    public IntuitiveTopological(BetterDiGraph diGraph) {
        topologyOrder(diGraph);
    }

    private void topologyOrder(BetterDiGraph diGraph) {
        LinkedList<Integer> topologyOrder = new LinkedList<>();

        while (diGraph.getVertexCount() > 0) {
            HashMap<Integer, Integer> indegreesMap = getIndegreesMap(diGraph);
            for (Integer i : indegreesMap.keySet()) {
                if (indegreesMap.get(i) == 0) {
                    topologyOrder.add(i);
                    diGraph.removeVertex(i);
                }
            }
        }
        order = topologyOrder;
    }

    private HashMap<Integer, Integer> getIndegreesMap(BetterDiGraph diGraph) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer i : diGraph.vertices()) {
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
    public Iterable<Integer> order() {
        return order;
    }

    /**
     * Returns true if the graph being sorted is a DAG, false otherwise.
     *
     * @return is graph a DAG
     */
    @Override
    public boolean isDAG() {
        return order == null;
    }


}