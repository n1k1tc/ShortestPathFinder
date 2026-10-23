
import java.util.*;

public class GraphTraversal {

    public void bfs(Graph graph, String start) {

        if (!graph.hasLocation(start)) {
            System.out.println("Invalid starting location.");
            return;
        }

        start = start.trim();

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new LinkedHashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            for (String neighbour :
                    graph.getNeighbours(current).keySet()) {

                if (visited.add(neighbour)) {
                    queue.offer(neighbour);
                }
            }
        }

        System.out.println(
                "BFS Traversal: " + String.join(" -> ", visited)
        );
    }

    public void dfs(Graph graph, String start) {

    if (!graph.hasLocation(start)) {
        System.out.println("Invalid starting location.");
        return;
    }

    Set<String> visited = new LinkedHashSet<>();

    dfsVisit(graph, start.trim(), visited);

    System.out.println(
        "DFS Traversal: " + String.join(" -> ", visited)
    );
}

private void dfsVisit(
        Graph graph, String current, Set<String> visited) {

    visited.add(current);

    for (String neighbour :
            graph.getNeighbours(current).keySet()) {

        if (!visited.contains(neighbour)) {
            dfsVisit(graph, neighbour, visited);
        }
    }
}
}
