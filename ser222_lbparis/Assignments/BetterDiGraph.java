import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class BetterDiGraph implements EditableDiGraph {

private HashMap<Integer, HashSet<Integer>> adjacencyMap;
private int numVertices;
private int numEdges;

public BetterDiGraph() {
this.adjacencyMap = new HashMap<>();
}

@Override
public void addEdge(int v, int w) {
addVertex(v);
addVertex(w);
if (this.adjacencyMap.containsKey(v)) {
if (!this.adjacencyMap.get(v).contains(w)) {
this.adjacencyMap.get(v).add(w);
this.numEdges++;
return;
}
}
return;

}

@Override
public void addVertex(int v) {
if (!this.adjacencyMap.containsKey(v)) {
this.adjacencyMap.put(v, new HashSet<>());
this.numVertices++;
return;
}
return;

}

@Override
public Iterable getAdj(int v) {
// TODO Auto-generated method stub
return this.adjacencyMap.get(v);
}

@Override
public int getEdgeCount() {
// TODO Auto-generated method stub
return this.numEdges;
}

@Override
public int getIndegree(int v) throws NoSuchElementException {

if (!containsVertex(v)) {
throw new NoSuchElementException();
}

List<Integer> inList = new ArrayList<Integer>();
for (Integer to : this.adjacencyMap.keySet()) {
for (Integer e : this.adjacencyMap.get(to))
if (e.equals(v))
inList.add(to);
}
return inList.size();

}

@Override
public int getVertexCount() {
// TODO Auto-generated method stub
return this.numVertices;
}

@Override
public void removeEdge(int v, int w) {
if (this.adjacencyMap.containsKey(v) && this.adjacencyMap.containsKey(w)) {
if (this.adjacencyMap.get(v).contains(w)) {
this.adjacencyMap.get(v).remove(w);
this.numEdges--;
return;
}
}
return;

}

@Override
public void removeVertex(int vertex) {
if (this.adjacencyMap.containsKey(vertex)) {
this.adjacencyMap.remove(vertex);
for (Map.Entry<Integer, HashSet<Integer>> entry : this.adjacencyMap.entrySet()) {
if (entry.getValue().contains(vertex)) {
this.adjacencyMap.get(entry.getKey()).remove(vertex);
}
}
this.numVertices--;
return;
}
return;

}

@Override
public Iterable vertices() {
// TODO Auto-generated method stub

List<Integer> inList = new ArrayList<Integer>();
for (Integer to : this.adjacencyMap.keySet()) {
if (!inList.contains(to))
inList.add(to);
}
return inList;

}

@Override
public boolean isEmpty() {
// TODO Auto-generated method stub
return this.numVertices == 0;
}

@Override
public boolean containsVertex(int v) {
if (this.adjacencyMap.containsKey(v)) {
return true;
}
return false;
}

}