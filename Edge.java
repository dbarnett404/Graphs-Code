public class Edge {
    // stores the end vertex of the edge
    private int neighbourVertex;
    // stores the weight of the edge
    private int weight;

    public Edge(int neighbourVertex, int weight) {
        this.neighbourVertex = neighbourVertex;
        this.weight = weight;
    }

    // getters
    public int getNeighbourVertex() {
        return neighbourVertex;
    }

    public int getWeight() {
        return weight;
    }
}
