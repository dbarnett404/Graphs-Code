import java.util.*;
/**
 * Graph implementation using an adjacency list.
 * The adjacency list is represented as a map where each key is a vertex label
 * and the value is a list of edges originating from that vertex.
 * Each edge contains the destination vertex label and the weight of the edge.
 */

public class GraphAdjList implements Graph {

    //Initiate the field as a map of String keys to lists of edges
    //This uses the interface for greater flexibility than a concrete class
    private Map<String, List<Edge>> adjacencyList;

    /**
     * Constructor
     */
    public GraphAdjList() {

        //Create the adjacency list as a HashMap
        adjacencyList = new HashMap<>();
    }

    /**
     * Add a vertex to the graph - initialise its adjacency list
     * @param vertexLabel
     */
    @Override    
    public void addVertex(String vertexLabel) {
        //Initialize the adjacency list for this vertex
        adjacencyList.put(vertexLabel, new ArrayList<>());
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
    public Vertex getVertex(int index) {
        int i = 0;
        for (String vertexLabel : adjacencyList.keySet()) {
            if (i == index) {
                return new Vertex(vertexLabel);
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
    public ArrayList<Edge> getEdges(String vertexLabel) {
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

    public void depthFirstSearch() {
        Set<String> visited = new HashSet<>();
        for (String vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                dfsUtil(vertex, visited);
            }
        }
    }

    // Helper method for DFS
    private void dfsUtil(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (Edge edge : adjacencyList.get(vertex)) {
            String neighbour = edge.getNeighbourVertex();
            if (!visited.contains(neighbour)) {
                dfsUtil(neighbour, visited);
            }
        }
    }

    public void breadthFirstSearch() {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        for (String startVertex : adjacencyList.keySet()) {
            if (!visited.contains(startVertex)) {
                visited.add(startVertex);
                queue.add(startVertex);

                while (!queue.isEmpty()) {
                    String vertex = queue.poll();
                    System.out.print(vertex + " ");

                    for (Edge edge : adjacencyList.get(vertex)) {
                        String neighbour = edge.getNeighbourVertex();
                        if (!visited.contains(neighbour)) {
                            visited.add(neighbour);
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }
    }
}