import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, Integer> vertexMap = new java.util.HashMap<>();
    static {
        vertexMap.put("A", 0);
        vertexMap.put("B", 1);
        vertexMap.put("C", 2);
        vertexMap.put("D", 3);
        vertexMap.put("E", 4);
    }

    public static Graph buildAdjacencyMatrix(GraphAdjMatrix graph) {
        graph.addVertex(vertexMap.get("A"), new Vertex("A"));
        graph.addVertex(vertexMap.get("B"), new Vertex("B"));
        graph.addVertex(vertexMap.get("C"), new Vertex("C"));
        graph.addVertex(vertexMap.get("D"), new Vertex("D"));
        graph.addVertex(vertexMap.get("E"), new Vertex("E"));
        // A: (B,20), (C,30)
        graph.addEdge(vertexMap.get("A"), vertexMap.get("B"), 20);
        graph.addEdge(vertexMap.get("A"), vertexMap.get("C"), 30);
        // B: (A,20), (C,30), (E,25)
        graph.addEdge(vertexMap.get("B"), vertexMap.get("A"), 20);
        graph.addEdge(vertexMap.get("B"), vertexMap.get("C"), 30);
        graph.addEdge(vertexMap.get("B"), vertexMap.get("E"), 25);
        // C: (A,30), (B,30), (D,35)
        graph.addEdge(vertexMap.get("C"), vertexMap.get("A"), 30);
        graph.addEdge(vertexMap.get("C"), vertexMap.get("B"), 30);
        graph.addEdge(vertexMap.get("C"), vertexMap.get("D"), 35);
        // D: (C,35), (E,40)
        graph.addEdge(vertexMap.get("D"), vertexMap.get("C"), 35);
        graph.addEdge(vertexMap.get("D"), vertexMap.get("E"), 40);
        // E: (B,25), (D,40)
        graph.addEdge(vertexMap.get("E"), vertexMap.get("B"), 25);
        graph.addEdge(vertexMap.get("E"), vertexMap.get("D"), 40);
        return graph;
    }

    public static Graph buildAdjacencyList(GraphAdjList graph) {
        graph.addVertex(vertexMap.get("A"), new Vertex("A"));
        graph.addVertex(vertexMap.get("B"), new Vertex("B"));
        graph.addVertex(vertexMap.get("C"), new Vertex("C"));
        graph.addVertex(vertexMap.get("D"), new Vertex("D"));
        graph.addVertex(vertexMap.get("E"), new Vertex("E"));
        // A: (B,20), (C,30)
        graph.addEdge(vertexMap.get("A"), vertexMap.get("B"), 20);
        graph.addEdge(vertexMap.get("A"), vertexMap.get("C"), 30);
        // B: (A,20), (C,30), (E,25)
        graph.addEdge(vertexMap.get("B"), vertexMap.get("A"), 20);
        graph.addEdge(vertexMap.get("B"), vertexMap.get("C"), 30);
        graph.addEdge(vertexMap.get("B"), vertexMap.get("E"), 25);
        // C: (A,30), (B,30), (D,35)
        graph.addEdge(vertexMap.get("C"), vertexMap.get("A"), 30);
        graph.addEdge(vertexMap.get("C"), vertexMap.get("B"), 30);
        graph.addEdge(vertexMap.get("C"), vertexMap.get("D"), 35);
        // D: (C,35), (E,40)
        graph.addEdge(vertexMap.get("D"), vertexMap.get("C"), 35);
        graph.addEdge(vertexMap.get("D"), vertexMap.get("E"), 40);
        // E: (B,25), (D,40)
        graph.addEdge(vertexMap.get("E"), vertexMap.get("B"), 25);
        graph.addEdge(vertexMap.get("E"), vertexMap.get("D"), 40);
        return graph;
    }

    private static void printPath(Graph graph, List<Integer> path) {
         for (int vertex : path) {
            System.out.print(graph.getVertex(vertex).getLabel() + " ");
        }
        System.out.println();
    }
    private static void doDepthFirstSearch(Graph graph, int startVertex) {
        List<Integer> path = Traversal.depthFirstSearch(graph, startVertex);
        System.out.println("DFS Path from " + graph.getVertex(startVertex).getLabel() + ": ");
        printPath(graph, path);
    }

    private static void doBreadthFirstSearch(Graph graph, int startVertex) {
        List<Integer> path = Traversal.breadthFirstSearch(graph, startVertex);
        System.out.println("BFS Path from " + graph.getVertex(startVertex).getLabel() + ": ");
        printPath(graph, path);
    }
    public static void main(String[] args) {
        GraphAdjMatrix adjacencyMatrixGraph = new GraphAdjMatrix(vertexMap.size());
        buildAdjacencyMatrix((GraphAdjMatrix) adjacencyMatrixGraph);
        adjacencyMatrixGraph.display();
        doDepthFirstSearch(adjacencyMatrixGraph, vertexMap.get("A"));
        doBreadthFirstSearch(adjacencyMatrixGraph, vertexMap.get("A"));
        
        GraphAdjList adjacencyListGraph = new GraphAdjList(vertexMap.size());
        buildAdjacencyList(adjacencyListGraph);
        adjacencyListGraph.display();
        doDepthFirstSearch(adjacencyListGraph, vertexMap.get("A"));
        doBreadthFirstSearch(adjacencyListGraph, vertexMap.get("A"));
    }
}