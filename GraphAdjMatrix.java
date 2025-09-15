import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphAdjMatrix implements Graph {
        // Map to store vertices by their labels
    private HashMap<String, Integer> labelToIndex;
    private int[][] adjacencyMatrix;
    private int size;
    public GraphAdjMatrix(int matrixSize) {
        adjacencyMatrix = new int[matrixSize][matrixSize];
        labelToIndex = new HashMap<>();
        size = 0;
    }
    @Override
    public void addVertex(String vertexLabel) {
        labelToIndex.put(vertexLabel, size);
        size++;
    }
    @Override
    public void addEdge(String label1, String label2, int weight) {
        int i = labelToIndex.get(label1);
        int j = labelToIndex.get(label2);
        adjacencyMatrix[i][j] = weight;
        adjacencyMatrix[j][i] = weight; // if undirected
    }

    @Override
    public int fetchEdgeWeight(String label1, String label2) {
        int i = labelToIndex.get(label1);
        int j = labelToIndex.get(label2);
        return adjacencyMatrix[i][j];
    }

    @Override
    public int size() {
        return labelToIndex.size();
    }

    @Override
    public void display() {
        // Build an array to map index to label
        String[] indexToLabel = new String[labelToIndex.size()];
        for (Map.Entry<String, Integer> entry : labelToIndex.entrySet()) {
            indexToLabel[entry.getValue()] = entry.getKey();
        }

        // Print header row
        for (int i = 0; i < indexToLabel.length; i++) {
            System.out.print(String.format("%5s", indexToLabel[i]));
        }
        System.out.println();

        // Print each row
        for (int i = 0; i < indexToLabel.length; i++) {
            //System.out.print(String.format("%4s", indexToLabel[i]));
            System.out.print(String.format("%s", indexToLabel[i]));
            for (int j = 0; j < indexToLabel.length; j++) {
                System.out.print("|" + String.format("%3d", adjacencyMatrix[i][j]) + " ");
            }
            System.out.println("|");
        }
    }

    /**
     * Perform a depth-first search (DFS) traversal of the graph.
     * Visits all vertices, including disconnected components.
     * Prints each visited vertex label in order.
     */
    public void depthFirstSearch() {
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                System.out.print("Starting DFS from: " + getVertexLabel(i) + ". Visiting: ");
                dfsUtil(i, visited);
                System.out.print("\n");
            }
        }
    }

    /**
     * Recursive utility method for DFS traversal.
     * @param vertex The current vertex index.
     * @param visited Array tracking visited vertices.
     */
    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(getVertexLabel(vertex) + " "); // Print as soon as visited
        for (int i = 0; i < size; i++) {
            if (adjacencyMatrix[vertex][i] != 0 && !visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }
    /**
     * Get the label of a vertex given its index in the adjacency matrix.
     * @param index The index of the vertex.
     * @return The label of the vertex, or null if not found.
     */
    private String getVertexLabel(int index) {
        for (Map.Entry<String, Integer> entry : labelToIndex.entrySet()) {
            if (entry.getValue() == index) {
                return entry.getKey();
            }
        }
        return null; // Should not happen if index is valid
    }
    /**
     * Perform a breadth-first search (BFS) traversal of the graph.
     * Visits all vertices, including disconnected components.
     * Prints each visited vertex label in order.
     */
    public void breadthFirstSearch() {
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                System.out.print("Starting BFS from: " + getVertexLabel(i) + ". Visiting: ");
                bfsUtil(i, visited);
                System.out.print("\n");
            }
        }
    }

    /**
     * Utility method for BFS traversal using a queue.
     * @param startVertex The starting vertex index.
     * @param visited Array tracking visited vertices.
     */
    private void bfsUtil(int startVertex, boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(getVertexLabel(vertex) + " ");

            for (int i = 0; i < size; i++) {
                if (adjacencyMatrix[vertex][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}
