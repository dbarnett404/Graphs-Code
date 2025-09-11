import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    /**
     * Depth First Search for Graph - this will visit all the vertices in the graph
     * @param graph
     * @param start
     */
    public static List<Integer> depthFirstSearch(Graph graph, int start) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!graph.getVertex(vertex).isVisited()) {
                path.add(vertex);
                graph.getVertex(vertex).setVisited(true);
                for (int i = 0; i < graph.size(); i++) {
                    if (graph.getEdge(vertex, i) != 0 && !graph.getVertex(i).isVisited()) {
                        stack.push(i);
                    }
                }
            }
        }
        graph.clearVisited();
        return path;
    }

    /**
     * Breadth First Search for graph - this will visit all the vertices in the graph
     * @param graph
     * @param start
     */
    public static List<Integer> breadthFirstSearch(Graph graph, int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        queue.add(start);
        graph.getVertex(start).setVisited(true);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            path.add(vertex);
            for (int i = 0; i < graph.size(); i++) {
                if (graph.getEdge(vertex, i) != 0 && !graph.getVertex(i).isVisited()) {
                    queue.add(i);
                    graph.getVertex(i).setVisited(true);
                }
            }
        }
        graph.clearVisited();
        return path;
    }
}