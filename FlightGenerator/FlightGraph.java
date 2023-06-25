import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FlightGraph<NodeType> extends CS400Graph implements DijkstraADT<NodeType> {

  private FlightGraph min;
  private int weight;
  Hashtable visited = new Hashtable();
  private List<Edge> edges;
  private Path krusk;

  FlightGraph() {
    min = new FlightGraph();
    weight = 0;
  }

  @Override
  public CS400Graph Kruskal(CS400Graph fullTree, NodeType start, NodeType end) {
    // Sort all edges from least to greatest cost
    Collections.sort(allEdges);
    // Begin Kruskal's
    for (int k = 0; k < getVertexCount() - 1; k++) {
      Edge addE = (CS400Graph.Edge) allEdges.get(k);
      // Take the next cheapest edge and add it to the tree
      min.insertVertex(addE.target);
      min.insertVertex(addE.target);
      min.insertEdge(addE.target, addE.target, addE.weight.doubleValue());
      // Discard subset if it results in a loop for the tree
      if (hasCycle(min)) {
        min.removeVertex(addE.target);
        min.removeVertex(addE.target);
        min.removeEdge(addE.target, addE.target);
      }



    }
    return min;// Use dataSequence.distance for total cost
  }

  // May have to implement a compareTo() method for edges, and implement Comparable<Edge>
  /**
   * Used by the Kruskal method to progressively check cycles while adding to the MST
   * 
   * @param graph
   * @return if no cycle is found
   */
  private boolean hasCycle(FlightGraph<NodeType> graph) {
    // Allocate memory for creating V subsets
    int[] parent = new int[graph.getVertexCount()];

    // Initialize all subsets as single element sets
    for (int i = 0; i < graph.getVertexCount(); i++)
      parent[i] = i;

    // Iterate through all edges of graph, find subset
    // of both vertices of every edge, if both subsets
    // are same, then there is cycle in graph.
    for (int i = 0; i < graph.getEdgeCount(); i++) {
      int x = graph.find(parent, (int) graph.allEdges.get(i));
      int y = graph.find(parent, (int) graph.allEdges.get(i));

      if (x == y)
        return true;

      graph.Union(parent, x, y);
    }
    return false;
  }

  public void Union(int[] parent, int x, int y) {
    parent[x] = y;
  }

  int find(int[] parent, int i) {
    if (parent[i] == i)
      return i;
    return find(parent, parent[i]);
  }

}
