public class Vertex {
    // stores the label of the vertex
    private String label;
    //  stores the status of the vertex
    private boolean visited;
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
}
