public interface Graph {
    /**
     * Add a vertex to the graph
     * @param index
     * @param vertex
     */
    void addVertex(String vertexLabel);

    /**
     * Add an edge to the graph
     * @param startLabel - the label of the start vertex
     * @param endLabel - the label of the end vertex
     * @param weight - the weight of the edge
     */
    void addEdge(String startLabel, String endLabel, int weight);

    /**
     * Get the edges of a vertex
     * @param startLabel
     * @param endLabel
     * @return
     */
    int fetchEdgeWeight(String startLabel, String endLabel);

    /**
     * Get the number of vertices in the graph
     * @return
     */
    int size();

    /**
     * Display the graph
     */
    void display();

    /**
     * Get the vertex object at a given index.
     * @param index The index of the vertex.
     * @return The Vertex object, or null if not found.
     */
    Vertex getVertex(int index);

    /**
     * Get the vertex object by its label.
     * @param label The label of the vertex.
     * @return The Vertex object, or null if not found.
     */
    Vertex getVertexByLabel(String label);

    /**
     * Get the edges of a vertex by label.
     * @param vertexLabel The label of the vertex.
     * @return A list of Edge objects for the vertex.
     */
    java.util.List<Edge> getEdges(String vertexLabel);

    /**
     * Get the neighbors of a vertex as a map of label to edge weight.
     * @param vertexLabel The label of the vertex.
     * @return Map of neighbor label to edge weight.
     */
    java.util.Map<String, Integer> getNeighbors(String vertexLabel);
}
