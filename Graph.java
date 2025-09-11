public interface Graph {
    /**
     * Add a vertex to the graph
     * @param index
     * @param vertex
     */
    void addVertex(int index, Vertex vertex);

    /**
     * Add an edge to the graph
     * @param start
     * @param end
     * @param weight
     */
    void addEdge(int start, int end, int weight);

    /**
     * Get a vertex from the graph
     * @param index
     * @return
     */
    Vertex getVertex(int index);

    /**
     * Get the edges of a vertex
     * @param start
     * @param end
     * @return
     */
    int getEdge(int start, int end);

    /**
     * Get the number of vertices in the graph
     * @return
     */
    int size();

    /**
     * Clear the visited status of all vertices
     */
    void clearVisited();

    /**
     * Display the graph
     */
    void display();
}
