import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;

public class DijkstrasShortestPath {
        /**
         * Finds the shortest path between two vertices using Dijkstra's algorithm.
         * Returns the path as a List<String> of vertex labels, or null if no path exists.
         */
        public static List<String> findShortestPath(Graph graph, String startVertexLabel, String endVertexLabel) {
            PriorityQueue<Vertex> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.getDistance(), b.getDistance()));
            Vertex startVertex = graph.getVertexByLabel(startVertexLabel);
            Vertex endVertex = graph.getVertexByLabel(endVertexLabel);
            if (startVertex == null || endVertex == null) return null;
            // Reset all distances and previous pointers (assumes all vertices can be iterated by index)
            for (int i = 0; i < graph.size(); i++) {
                Vertex v = graph.getVertex(i);
                if (v != null) {
                    v.setDistance(Integer.MAX_VALUE);
                    v.setPreviousVertex(null);
                }
            }
            startVertex.setDistance(0);
            queue.add(startVertex);
            while (!queue.isEmpty()) {
                Vertex currentVertex = queue.poll();
                if (currentVertex.equals(endVertex)) {
                    // Found the shortest path to the destination
                    break;
                }
                Map<String, Integer> neighbours = graph.getNeighbors(currentVertex.getLabel());
                for (Map.Entry<String, Integer> entry : neighbours.entrySet()) {
                    Vertex neighbourVertex = graph.getVertexByLabel(entry.getKey());
                    int newDistance = currentVertex.getDistance() + entry.getValue();
                    if (newDistance < neighbourVertex.getDistance()) {
                        neighbourVertex.setDistance(newDistance);
                        queue.remove(neighbourVertex); // Remove if present to update its priority
                        queue.add(neighbourVertex);
                        neighbourVertex.setPreviousVertex(currentVertex);
                    }
                }
            }
            // Reconstruct path
            if (endVertex.getDistance() == Integer.MAX_VALUE) {
                return null; // No path found
            }
            java.util.LinkedList<String> path = new java.util.LinkedList<>();
            for (Vertex v = endVertex; v != null; v = v.getPreviousVertex()) {
                path.addFirst(v.getLabel());
            }
            return path;
        }

    public static String showPath(Vertex destinationVertex) {
        if (destinationVertex.getPreviousVertex() != null) {
            return showPath(destinationVertex.getPreviousVertex()) + " -> " + destinationVertex.getLabel();
        }
        return destinationVertex.getLabel();
    }
}