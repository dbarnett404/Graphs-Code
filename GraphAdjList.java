import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Graph implementation using an adjacency list.
 * The adjacency list is represented as a map where each key is a vertex label
 * and the value is a list of edges originating from that vertex.
 * Each edge contains the destination vertex label and the weight of the edge.
 */


public class GraphAdjList implements Graph {
    // Map of vertex label to Vertex object (unique instance per label)
    private Map<String, Vertex> vertexMap;
    // Map of String keys to lists of edges
    private Map<String, List<Edge>> adjacencyList;

    /**
     * Constructor
     */
    public GraphAdjList() {
        vertexMap = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    /**
     * Add a vertex to the graph - initialise its adjacency list
     * @param vertexLabel
     */
    @Override    
    public void addVertex(String vertexLabel) {
        if (!vertexMap.containsKey(vertexLabel)) {
            vertexMap.put(vertexLabel, new Vertex(vertexLabel));
            adjacencyList.put(vertexLabel, new ArrayList<>());
        }
    }
    
    /**
     * Add an edge to the graph
     * @param startLabel - the label of the start vertex
     * @param endLabel - the label of the end vertex
     * @param weight - the weight of the edge
     */
    @Override
    public void addEdge(String startLabel, String endLabel, int weight) {
        adjacencyList.get(startLabel).add(new Edge(endLabel, weight));
    }

    public String getVertexLabel() {
        return null;
    }
    @Override
    public Vertex getVertex(int index) {
        int i = 0;
        for (String vertexLabel : adjacencyList.keySet()) {
            if (i == index) {
                return vertexMap.get(vertexLabel);
            }
            i++;
        }
        return null; // Index out of bounds
    }
    /**
     * Get the edges of a vertex
     * @param vertexLabel
     * @return
     */
    @Override
    public java.util.List<Edge> getEdges(String vertexLabel) {
        return new ArrayList<>(adjacencyList.get(vertexLabel));
    }

    /**
     * Get the number of vertices in the graph
     * @return
     */
    @Override
    public int size() {
        return adjacencyList.size();
    }


    /**
     * Display the graph
     */
    @Override
    public void display() {
        for (String vertexLabel : adjacencyList.keySet()) {
            System.out.print(vertexLabel + " ");
            List<Edge> edges = adjacencyList.get(vertexLabel);
            for (Edge edge : edges) {
                String destLabel = edge.getNeighbourVertex();
                int weight = edge.getWeight();
                System.out.print("(" + destLabel + ", " + weight + ") ");
            }
            System.out.println();
        }
    }


    /**
     * Get the weight of an edge between two vertices
     * @param startLabel
     * @param endLabel
     * @return the weight of the edge, or 0 if no edge exists
     */
    @Override
    public int fetchEdgeWeight(String startLabel, String endLabel) {
        for (Edge edge : adjacencyList.get(startLabel)) {
            if (edge.getNeighbourVertex().equals(endLabel)) {
                return edge.getWeight();
            }
        }
        return 0;
    }
    /**
     * Get the vertex object by its label.
     * @param label The label of the vertex.
     * @return The Vertex object, or null if not found.
     */
    @Override
    public Vertex getVertexByLabel(String label) {
        return vertexMap.get(label);
    }

    /**
     * Get the neighbors of a vertex as a map of label to edge weight.
     * @param vertexLabel The label of the vertex.
     * @return Map of neighbor label to edge weight.
     */
    @Override
    public java.util.Map<String, Integer> getNeighbors(String vertexLabel) {
        java.util.Map<String, Integer> neighbors = new java.util.HashMap<>();
        java.util.List<Edge> edges = adjacencyList.get(vertexLabel);
        if (edges != null) {
            for (Edge edge : edges) {
                neighbors.put(edge.getNeighbourVertex(), edge.getWeight());
            }
        }
        return neighbors;
    }
}