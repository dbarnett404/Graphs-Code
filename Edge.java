public class Edge {
    // stores the end vertex label of the edge
    private String neighbourVertex;
    // stores the weight of the edge
    private int weight;

    public Edge(String neighbourVertex, int weight) {
        this.neighbourVertex = neighbourVertex;
        this.weight = weight;
    }

    // getters
    public String getNeighbourVertex() {
        return neighbourVertex;
    }

    public int getWeight() {
        return weight;
    }
}
