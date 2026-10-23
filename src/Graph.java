
import java.util.*;

public class Graph {

    // Stores each location and its connected locations with distances
    private final Map<String, Map<String, Integer>> adj =
            new LinkedHashMap<>();

            
public boolean addLocation(String name) {

    if (name == null || name.trim().isEmpty()) {
        return false;
    }

    name = name.trim();

    if (adj.containsKey(name)) {
        return false;
    }

    adj.put(name, new LinkedHashMap<>());
    return true;
}


public boolean addRoute(String source, String destination, int distance) {

    if (!adj.containsKey(source) || !adj.containsKey(destination)) {
        return false;
    }

    if (source.equals(destination) || distance < 0) {
        return false;
    }

    adj.get(source).put(destination, distance);
    adj.get(destination).put(source, distance);

    return true;
}


public void displayGraph() {

    if (adj.isEmpty()) {
        System.out.println("No locations added yet.");
        return;
    }

    System.out.println("\n--- Graph ---");

    for (String location : adj.keySet()) {

        System.out.print(location + " -> ");

        Map<String, Integer> neighbours = adj.get(location);

        if (neighbours.isEmpty()) {
            System.out.print("No routes");
        } else {
            for (Map.Entry<String, Integer> route : neighbours.entrySet()) {
                System.out.print(
                    route.getKey() + " (" + route.getValue() + " km) "
                );
            }
        }

        System.out.println();
    }
}


public boolean hasLocation(String name) {
    return name != null && adj.containsKey(name.trim());
}

public Map<String, Integer> getNeighbours(String location) {
    if (!hasLocation(location)) {
        return Collections.emptyMap();
    }

    return Collections.unmodifiableMap(
        adj.get(location.trim())
    );
}


public Set<String> getLocations() {
    return Collections.unmodifiableSet(adj.keySet());
}

}
