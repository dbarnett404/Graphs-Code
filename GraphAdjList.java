import java.util.*;

public class GraphAdjList implements Graph {
    private Vertex[] vertices;
    private ArrayList<ArrayList<Edge>> adjacencyList;

    /**
     * Constructor
     * @param size
     */
    public GraphAdjList(int size) {
        vertices = new Vertex[size];
        adjacencyList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    @Override    
    public void addVertex(int index, Vertex vertex) {
        vertices[index] = vertex;
    }
    
    @Override
    public void addEdge(int start, int end, int weight) {
        adjacencyList.get(start).add(new Edge(end, weight));
    }

    public ArrayList<Edge> getEdges(int vertex) {
        return adjacencyList.get(vertex);
    }

    @Override
    public int size() {
        return vertices.length;
    }

    @Override
    public void clearVisited() {
        for (Vertex vertex : vertices) {
            vertex.setVisited(false);
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < vertices.length; i++) {
            System.out.print(vertices[i].getLabel() + " ");
            for (Edge edge : adjacencyList.get(i)) {
                int destIdx = edge.getNeighbourVertex();
                String destLabel = vertices[destIdx].getLabel();
                int weight = edge.getWeight();
                System.out.print("(" + destLabel + ", " + weight + ") ");
            }
            System.out.println();
        }
    }

    @Override
    public Vertex getVertex(int index) {
        return vertices[index];
    }

    @Override
    public int getEdge(int start, int end) {
        for (Edge edge : adjacencyList.get(start)) {
            if (edge.getNeighbourVertex() == end) {
                return edge.getWeight();
            }
        }
        return 0;
    }
}