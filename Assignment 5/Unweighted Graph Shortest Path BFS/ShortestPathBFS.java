// To find the shortest path in an unweighted graph, we can use the Breadth-First Search (BFS) algorithm. BFS is particularly well-suited for this task because it explores nodes level by level, ensuring that the shortest path is found first.

import java.util.*;

public class ShortestPathBFS {
    
    // Class representing a graph using an adjacency list
    static class Graph {
        private final int V; // Number of vertices
        private final List<List<Integer>> adj; // Adjacency list

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new LinkedList<>());
            }
        }

        // Function to add an edge to the graph
        void addEdge(int source, int dest) {
            adj.get(source).add(dest);
            adj.get(dest).add(source); // For undirected graph
        }

        // Function to find the shortest path using BFS
        List<Integer> findShortestPath(int start, int end) {
            boolean[] visited = new boolean[V];
            int[] parent = new int[V];
            Queue<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.add(start);
            parent[start] = -1;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                if (current == end) {
                    return constructPath(parent, end);
                }

                for (int neighbor : adj.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                        parent[neighbor] = current;
                    }
                }
            }

            return Collections.emptyList(); // No path found
        }

        // Function to construct the path from parent array
        private List<Integer> constructPath(int[] parent, int end) {
            List<Integer> path = new ArrayList<>();
            for (int at = end; at != -1; at = parent[at]) {
                path.add(at);
            }
            Collections.reverse(path);
            return path;
        }
    }

    // Driver method to test above methods
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        int start = 0;
        int end = 5;
        List<Integer> path = graph.findShortestPath(start, end);

        if (!path.isEmpty()) {
            System.out.println("Shortest path from " + start + " to " + end + ": " + path);
        } else {
            System.out.println("No path found from " + start + " to " + end);
        }
    }
}

// Explanation
// Graph Class:

// This class represents a graph using an adjacency list.
// addEdge(int source, int dest): Adds an undirected edge between source and dest.
// findShortestPath(int start, int end): Uses BFS to find the shortest path from start to end. It returns the path as a list of integers.
// BFS Implementation:

// We use a visited array to keep track of visited nodes.
// We use a parent array to keep track of the parent of each node. This helps in reconstructing the path once the end node is reached.
// We use a queue to perform BFS. The starting node is added to the queue and marked as visited.
// We dequeue a node, explore its neighbors, and if a neighbor hasn't been visited, we mark it as visited, set its parent, and enqueue it.
// If we reach the end node during BFS, we reconstruct the path using the parent array.
// Path Reconstruction:

// The constructPath method reconstructs the path from the end node to the start node using the parent array.
// The path is then reversed to get the correct order from start to end.
// Driver Method:

// A sample graph is created with 6 vertices.
// Edges are added to create connections between the vertices.
// The findShortestPath method is called to find the shortest path from node 0 to node 5.
// The path is printed if found; otherwise, a message indicating no path is found is printed.
// Time and Space Complexity
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges. Each vertex and edge is processed once.
// Space Complexity: O(V), due to the storage of the visited array, parent array, and the queue used for BFS.
// This implementation efficiently finds the shortest path in an unweighted graph using BFS.