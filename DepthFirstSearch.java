import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {
     /**
     * Perform a depth-first search (DFS) traversal of any Graph implementation.
     * Visits all vertices, including disconnected components.
     * Returns a list of vertex labels in the order they are visited.
     *
     * @param graph The graph to traverse.
     * @return List of vertex labels in DFS order.
     */
    public static List<String> dfs(Graph graph) {
        Set<String> visited = new HashSet<>(); // Track visited vertices by label
        List<String> order = new ArrayList<>(); // Store the order of traversal
        // Loop through all vertices by index to ensure disconnected components are covered
        for (int i = 0; i < graph.size(); i++) {
            String label = null;
            try {
                Vertex v = graph.getVertex(i); // Get the vertex at index i
                if (v != null) label = v.getLabel();
            } catch (Exception e) {
                // fallback: skip if vertex not found
            }
            // If this vertex hasn't been visited, start a DFS from it
            if (label != null && !visited.contains(label)) {
                dfsUtil(graph, label, visited, order);
            }
        }
        return order;
    }

    /**
     * Recursive utility method for DFS traversal.
     * Adds the current vertex to the visited set and order list, then recursively visits all unvisited neighbors.
     *
     * @param graph The graph to traverse.
     * @param vertexLabel The current vertex label.
     * @param visited Set tracking visited vertex labels.
     * @param order List to record the order of traversal.
     */
    private static void dfsUtil(Graph graph, String vertexLabel, Set<String> visited, java.util.List<String> order) {
        visited.add(vertexLabel); // Mark this vertex as visited
        order.add(vertexLabel);   // Record the visit order
        try {
            // For each neighbor (edge) of the current vertex
            for (Edge edge : graph.getEdges(vertexLabel)) {
                String neighbor = edge.getNeighbourVertex();
                // If neighbor hasn't been visited, recurse
                if (!visited.contains(neighbor)) {
                    dfsUtil(graph, neighbor, visited, order);
                }
            }
        } catch (Exception e) {
            // fallback: skip if edges not found
        }
    }
}
