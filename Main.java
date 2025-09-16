
public class Main {
    private static String[] vertexLabels = {"A", "B", "C", "D", "E", "F", "G", "H"};
    
    public static Graph buildGraph(Graph graph) {
        // Create a map to hold vertex labels to their indices
        for (String label : vertexLabels) {
            graph.addVertex(label);
        }

        // A: (B,20), (C,15)
        graph.addEdge("A", "B", 20);
        graph.addEdge("A", "C", 15);
        // B: (A,20), (C,22), (D, 25), (E,18)
        graph.addEdge("B", "A", 20);
        graph.addEdge("B", "C", 22);
        graph.addEdge("B", "D", 25);
        graph.addEdge("B", "E", 18);
        // C: (A,15), (B,22), (D,24), (F, 12)
        graph.addEdge("C", "A", 15);
        graph.addEdge("C", "B", 22);
        graph.addEdge("C", "D", 24);
        graph.addEdge("C", "F", 12);
        // D: (B, 25), (C,24), (E,22)
        graph.addEdge("D", "B", 25);
        graph.addEdge("D", "C", 24);
        graph.addEdge("D", "E", 22);
        // E: (B,18), (D,22)
        graph.addEdge("E", "B", 18);
        graph.addEdge("E", "D", 22);
        // F: (C,12), (G,16)
        graph.addEdge("F", "C", 12);
        graph.addEdge("F", "G", 16);
        // G: (F,16)
        graph.addEdge("G", "F", 16);
        // H: (D, 14)
        graph.addEdge("H", "D", 14);
        return graph;
    }

    public static void main(String[] args) {        
        GraphAdjList adjacencyListGraph = new GraphAdjList();
        buildGraph(adjacencyListGraph);
        adjacencyListGraph.display();
        GraphAdjMatrix adjacencyMatrixGraph = new GraphAdjMatrix(vertexLabels.length);
        buildGraph(adjacencyMatrixGraph);    
        adjacencyMatrixGraph.display();
        
        System.out.println("DFS Traversal (Adjacency List):");
        System.out.println(DepthFirstSearch.dfs(adjacencyListGraph));
        System.out.println("\nBFS Traversal (Adjacency List):");
        System.out.println(BreadthFirstSearch.bfs(adjacencyListGraph));
        System.out.println("\nDFS Traversal (Adjacency Matrix):");
        System.out.println(DepthFirstSearch.dfs(adjacencyMatrixGraph));
        System.out.println("\nBFS Traversal (Adjacency Matrix):");
        System.out.println(BreadthFirstSearch.bfs(adjacencyMatrixGraph));
        
        System.out.println("\nDijkstra's Shortest Path (Adjacency List) from A to G:");
        System.out.println(DijkstrasShortestPath.findShortestPath(adjacencyListGraph, "A", "G"));
        System.out.println("\nDijkstra's Shortest Path (Adjacency Matrix) from A to G:");
        System.out.println(DijkstrasShortestPath.findShortestPath(adjacencyMatrixGraph, "A", "G"));
    }
}