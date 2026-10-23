
import java.util.*;

public class Dijkstra {

    private static class Entry implements Comparable<Entry> {
        String location;
        int distance;

        Entry(String location, int distance) {
            this.location = location;
            this.distance = distance;
        }

        @Override
        public int compareTo(Entry other) {
            return Integer.compare(this.distance, other.distance);
        }
    }


    
public void findShortestPath(Graph graph, String source, String destination) {

    if (!graph.hasLocation(source) || !graph.hasLocation(destination)) {
        System.out.println("Invalid source or destination.");
        return;
    }

    Map<String, Integer> distances = new HashMap<>();
    Map<String, String> previous = new HashMap<>();

    for (String location : graph.getLocations()) {
        distances.put(location, Integer.MAX_VALUE);
    }

    source = source.trim();
    destination = destination.trim();

    distances.put(source, 0);

    
PriorityQueue<Entry> queue = new PriorityQueue<>();

queue.offer(new Entry(source, 0));


while (!queue.isEmpty()) {

    Entry current = queue.poll();

    if (current.distance != distances.get(current.location)) {
        continue;
    }

    if (current.location.equals(destination)) {
        break;
    }

    for (Map.Entry<String, Integer> route :
            graph.getNeighbours(current.location).entrySet()) {

        String neighbour = route.getKey();
        int distance = route.getValue();

        int newDistance = current.distance + distance;

        if (newDistance < distances.get(neighbour)) {

            distances.put(neighbour, newDistance);

            previous.put(neighbour, current.location);

            queue.offer(new Entry(neighbour, newDistance));
        }
    }
}

if (distances.get(destination) == Integer.MAX_VALUE) {
    System.out.println("No route exists from "
            + source + " to " + destination + ".");
    return;
}

LinkedList<String> path = new LinkedList<>();
String step = destination;

while (step != null) {
    path.addFirst(step);

    if (step.equals(source)) {
        break;
    }

    step = previous.get(step);
}

System.out.println("\n--- Shortest Path Result ---");
System.out.println("Shortest Path: " + String.join(" -> ", path));
System.out.println("Total Distance: " + distances.get(destination) + " km");




}

}
