
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Graph graph = new Graph();
        Dijkstra dijkstra = new Dijkstra();
        GraphTraversal traversal = new GraphTraversal();

        int choice;

        do {
            System.out.println("\n===== SHORTEST PATH FINDER =====");
            System.out.println("1. Add Location");
            System.out.println("2. Add Route");
            System.out.println("3. Display Graph");
            System.out.println("4. Find Shortest Path");
            System.out.println("5. BFS Traversal");
            System.out.println("6. DFS Traversal");
            System.out.println("7. Load Sample Graph");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Please enter a number.");
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter location name: ");
                    String location = sc.nextLine().trim();

                    if (graph.addLocation(location)) {
                        System.out.println("Location added successfully!");
                    } else {
                        System.out.println(
                            "Invalid or duplicate location."
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter source location: ");
                    String source = sc.nextLine().trim();

                    System.out.print("Enter destination location: ");
                    String destination = sc.nextLine().trim();

                    System.out.print("Enter distance in km: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Distance must be a whole number.");
                        sc.nextLine();
                        break;
                    }

                    int distance = sc.nextInt();
                    sc.nextLine();

                    if (graph.addRoute(source, destination, distance)) {
                        System.out.println("Route added successfully!");
                    } else {
                        System.out.println(
                            "Invalid route. Check locations and distance."
                        );
                    }
                    break;

                case 3:
                    graph.displayGraph();
                    break;

                case 4:
                    System.out.print("Enter source location: ");
                    source = sc.nextLine().trim();

                    System.out.print("Enter destination location: ");
                    destination = sc.nextLine().trim();

                    dijkstra.findShortestPath(
                        graph, source, destination
                    );
                    break;

                case 5:
                    System.out.print("Enter starting location: ");
                    String bfsStart = sc.nextLine().trim();

                    traversal.bfs(graph, bfsStart);
                    break;

                case 6:
                    System.out.print("Enter starting location: ");
                    String dfsStart = sc.nextLine().trim();

                    traversal.dfs(graph, dfsStart);
                    break;

                case 7:
                    if (!graph.getLocations().isEmpty()) {
                        System.out.println(
                            "Sample graph can only be loaded into an empty graph."
                        );
                        break;
                    }

                    graph.addLocation("A");
                    graph.addLocation("B");
                    graph.addLocation("C");
                    graph.addLocation("D");

                    graph.addRoute("A", "B", 4);
                    graph.addRoute("A", "C", 2);
                    graph.addRoute("B", "D", 3);
                    graph.addRoute("C", "D", 1);

                    System.out.println("Sample graph loaded!");
                    graph.displayGraph();
                    break;

                case 8:
                    System.out.println("Thank you for using Shortest Path Finder!");
                    break;

                default:
                    System.out.println("Invalid choice. Select 1 to 8.");
            }

        } while (choice != 8);

        sc.close();
    }
}
