// To detect a cycle in a directed graph using Depth-First Search (DFS), we can use the following approach:

// Track Visited Nodes: We need to keep track of the visited nodes to avoid reprocessing them.
// Recursion Stack: We need another tracking mechanism to keep track of the recursion stack (i.e., the nodes currently in the current path of the DFS).
// Approach
// Visited Array: This keeps track of nodes that have been fully processed.
// Recursion Stack (RecStack): This keeps track of nodes in the current recursion path.
// If we revisit a node that is currently in the recursion stack, it indicates the presence of a cycle.

import java.util.*;

public class GraphCycleDetection {
    
    // Class representing a directed graph using adjacency list
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
        }

        // Function to detect cycle using DFS
        boolean isCyclic() {
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];

            // Call the recursive helper function to detect cycle in different DFS trees
            for (int i = 0; i < V; i++) {
                if (isCyclicUtil(i, visited, recStack)) {
                    return true;
                }
            }

            return false;
        }

        // A recursive function to detect cycle in the graph
        private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
            if (recStack[i]) {
                return true;
            }

            if (visited[i]) {
                return false;
            }

            visited[i] = true;
            recStack[i] = true;
            List<Integer> children = adj.get(i);

            for (Integer c : children) {
                if (isCyclicUtil(c, visited, recStack)) {
                    return true;
                }
            }

            recStack[i] = false;
            return false;
        }
    }

    // Driver method to test above methods
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        if (graph.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
}

// Explanation
// Graph Class:

// This class represents a directed graph using an adjacency list representation.
// addEdge(int source, int dest): Adds an edge from source to dest.
// isCyclic(): Checks if the graph contains a cycle using DFS.
// isCyclicUtil(int i, boolean[] visited, boolean[] recStack): A utility function that uses DFS to detect a cycle. It returns true if a cycle is detected, otherwise false.
// Cycle Detection:

// We iterate through all vertices and apply the isCyclicUtil function.
// If isCyclicUtil returns true for any vertex, it indicates that the graph contains a cycle.
// The visited array keeps track of nodes that have been fully processed.
// The recStack array keeps track of nodes currently in the recursion stack (current path).
// Driver Method:

// A sample graph is created with 4 vertices.
// Edges are added to create a cycle.
// The isCyclic method is called to detect if there is a cycle in the graph.
// Time and Space Complexity
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges. Each vertex and edge is processed once.
// Space Complexity: O(V), due to the visited and recStack arrays and the recursion stack.
// This implementation efficiently detects cycles in a directed graph using the DFS approach.