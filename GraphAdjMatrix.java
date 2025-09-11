public class GraphAdjMatrix implements Graph {
    private Vertex[] vertices;
    private int[][] adjacencyMatrix;
    public GraphAdjMatrix(int size) {
        vertices = new Vertex[size];
        adjacencyMatrix = new int[size][size];
    }
    @Override
    public void addVertex(int index, Vertex vertex) {
        vertices[index] = vertex;
    }
    @Override
    public void addEdge(int start, int end, int weight) {
        adjacencyMatrix[start][end] = weight;
    }

    @Override
    public Vertex getVertex(int index) {
        return vertices[index];
    }
    @Override
    public int getEdge(int start, int end) {
        return adjacencyMatrix[start][end];
    }

    @Override
    public int size() {
        return vertices.length;
    }

    @Override
    public void clearVisited() {
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].setVisited(false);
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < vertices.length; i++) {
            System.out.print(vertices[i].getLabel() + " ");
            for (int j = 0; j < vertices.length; j++) {
                System.out.print("|" + String.format("%3d", adjacencyMatrix[i][j]) + " ");
            }
            System.out.println("|");
        }
    }

}
