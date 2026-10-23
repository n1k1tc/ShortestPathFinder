# Shortest Path Finder Using Graph Algorithms in Java

## 1. Project Overview
The Shortest Path Finder is a menu-driven Java application that represents locations as vertices and routes as weighted edges in a graph. It helps users find the shortest route between two locations based on distance.

## 2. Objectives
- Represent locations and routes using a graph.
- Find the shortest path between two locations.
- Implement Breadth-First Search (BFS) and Depth-First Search (DFS).
- Allow users to add locations and routes dynamically.
- Display the graph and its route distances.

## 3. Technologies Used
- Programming Language: Java
- IDE: Visual Studio Code
- Data Structures: HashMap, LinkedHashMap, Set, Queue, PriorityQueue, and LinkedList

## 4. Algorithms Implemented

### Dijkstra's Algorithm
Finds the shortest path between two locations in a weighted graph with non-negative edge weights.

### Breadth-First Search (BFS)
Traverses the graph level by level using a queue.

### Depth-First Search (DFS)
Traverses the graph by exploring one path as far as possible before backtracking, using recursion.

## 5. Features
- Add new locations.
- Add routes with distances.
- Display the graph and its connections.
- Find the shortest path and total distance.
- Perform BFS and DFS traversals.
- Load a sample graph.
- Validate invalid locations and route inputs.

## 6. Project Structure
- `src/Main.java` — Main menu and user interaction.
- `src/Graph.java` — Graph representation and location/route management.
- `src/Dijkstra.java` — Shortest-path calculation.
- `src/GraphTraversal.java` — BFS and DFS implementations.
- `screenshots/` — Screenshots of project execution.

## 7. How to Compile and Run

Open the terminal in the project root directory.

Compile the Java files:

```bash
javac src/*.java
```

Run the application:

```bash
java -cp src Main
```

## 8. Sample Result
For the sample graph, the shortest path from A to D is:

`A -> C -> D`

Total distance: `3 km`

## 9. Conclusion
This project demonstrates how graph data structures and graph algorithms can solve route-finding problems. Dijkstra's algorithm calculates minimum distances, while BFS and DFS demonstrate different graph traversal techniques.