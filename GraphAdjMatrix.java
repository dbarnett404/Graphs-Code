import java.util.HashMap;
import java.util.Map;

public class GraphAdjMatrix implements Graph {
    // Map to store vertices by their labels
    private HashMap<String, Integer> labelToIndex;
    private HashMap<String, Vertex> vertexMap;
    private int[][] adjacencyMatrix;
    private int size;
    public GraphAdjMatrix(int matrixSize) {
        adjacencyMatrix = new int[matrixSize][matrixSize];
        labelToIndex = new HashMap<>();
        vertexMap = new HashMap<>();
        size = 0;
    }
    @Override
    public void addVertex(String vertexLabel) {
        if (!labelToIndex.containsKey(vertexLabel)) {
            labelToIndex.put(vertexLabel, size);
            vertexMap.put(vertexLabel, new Vertex(vertexLabel));
            size++;
        }
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
            return vertexMap.get(label);
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
        Integer vIdx = labelToIndex.get(vertexLabel);
        if (vIdx == null) return neighbors;
        for (int i = 0; i < size; i++) {
            if (adjacencyMatrix[vIdx][i] != 0) {
                String neighborLabel = getVertexLabel(i);
                if (neighborLabel != null) {
                    neighbors.put(neighborLabel, adjacencyMatrix[vIdx][i]);
                }
            }
        }
        return neighbors;
    }
}


