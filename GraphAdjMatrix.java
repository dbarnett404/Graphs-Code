import java.util.HashMap;
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
        // ...existing code...
    }


    @Override
    public Vertex getVertex(int index) {
        String label = getVertexLabel(index);
        if (label != null) {
            return new Vertex(label);
        }
        return null;
    }

    @Override
    public java.util.List<Edge> getEdges(String vertexLabel) {
        java.util.List<Edge> edges = new java.util.ArrayList<>();
        Integer vIdx = labelToIndex.get(vertexLabel);
        if (vIdx == null) return edges;
        for (int i = 0; i < size; i++) {
            if (adjacencyMatrix[vIdx][i] != 0) {
                String neighborLabel = getVertexLabel(i);
                if (neighborLabel != null) {
                    edges.add(new Edge(neighborLabel, adjacencyMatrix[vIdx][i]));
                }
            }
        }
        return edges;
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

}


