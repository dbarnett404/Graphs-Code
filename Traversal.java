import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Traversal {

    /**
     * Perform a depth-first search (DFS) traversal of any Graph implementation.
     * Visits all vertices, including disconnected components.
     * Prints each visited vertex label in order.
     */
    public static java.util.List<String> depthFirstSearch(Graph graph) {
        Set<String> visited = new HashSet<>();
        java.util.List<String> order = new java.util.ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            String label = null;
            try {
                Vertex v = graph.getVertex(i);
                if (v != null) label = v.getLabel();
            } catch (Exception e) {
                // fallback: skip
            }
            if (label != null && !visited.contains(label)) {
                dfsUtil(graph, label, visited, order);
            }
        }
        return order;
    }

    /**
     * Recursive utility method for DFS traversal.
     * @param graph The graph to traverse.
     * @param vertexLabel The current vertex label.
     * @param visited Set tracking visited vertex labels.
     */
    private static void dfsUtil(Graph graph, String vertexLabel, Set<String> visited, java.util.List<String> order) {
        visited.add(vertexLabel);
        order.add(vertexLabel);
        try {
            for (Edge edge : graph.getEdges(vertexLabel)) {
                String neighbor = edge.getNeighbourVertex();
                if (!visited.contains(neighbor)) {
                    dfsUtil(graph, neighbor, visited, order);
                }
            }
        } catch (Exception e) {
            // fallback: skip
        }
    }

    public static java.util.List<String> breadthFirstSearch(Graph graph) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        java.util.List<String> order = new java.util.ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            String label = null;
            try {
                Vertex v = graph.getVertex(i);
                if (v != null) label = v.getLabel();
            } catch (Exception e) {
                // fallback: skip
            }
            if (label != null && !visited.contains(label)) {
                visited.add(label);
                queue.add(label);

                while (!queue.isEmpty()) {
                    String vertex = queue.poll();
                    order.add(vertex);

                    for (Edge edge : graph.getEdges(vertex)) {
                        String neighbour = edge.getNeighbourVertex();
                        if (!visited.contains(neighbour)) {
                            visited.add(neighbour);
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }
        return order;
    }
}
