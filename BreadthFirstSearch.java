import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
     /**
     * Perform a breadth-first search (BFS) traversal of any Graph implementation.
     * Visits all vertices, including disconnected components.
     * Returns a list of vertex labels in the order they are visited.
     *
     * @param graph The graph to traverse.
     * @return List of vertex labels in BFS order.
     */
    public static List<String> bfs(Graph graph) {
        Set<String> visited = new HashSet<>(); // Track visited vertices by label
        Queue<String> queue = new LinkedList<>(); // Queue for BFS
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
            // If this vertex hasn't been visited, start a BFS from it
            if (label != null && !visited.contains(label)) {
                visited.add(label);
                queue.add(label);

                // Standard BFS loop
                while (!queue.isEmpty()) {
                    String vertex = queue.poll();
                    order.add(vertex);

                    // For each neighbour (edge) of the current vertex
                    for (Edge edge : graph.getEdges(vertex)) {
                        String neighbour = edge.getNeighbourVertex();
                        // If neighbour hasn't been visited, add to queue and mark as visited
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
