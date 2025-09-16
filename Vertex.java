public class Vertex {
    // stores the label of the vertex
    private String label;
    //  stores the status of the vertex
    private boolean visited;

    // For Dijkstra's algorithm
    private int distance = Integer.MAX_VALUE;
    private Vertex previousVertex = null;

    public Vertex(String label) {
        this.label = label;
        this.visited = false;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getLabel() {
        return label;
    }

    public boolean isVisited() {
        return visited;
    }

    // Dijkstra's algorithm methods
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex vertex = (Vertex) obj;
        return label.equals(vertex.label);
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
