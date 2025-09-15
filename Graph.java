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
}
