import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


public class ShortestReach {
    public static class Graph {
        static int[][] matrix;
        static Set<Integer> visited;
        static final int DISTANCE = 6;
        Queue<Node2> q;
        
        public Graph(int size) {
            matrix = new int[size][size];
            visited = new HashSet<Integer>();
        }

        public void addEdge(int first, int second) {
            matrix[first][second] = 1;
            matrix[second][first] = 1;
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            int[] shortestPaths = new int[matrix.length];
            
            for (int i = 0; i < matrix.length; i++) {
                if(i != startId) {
                    q = new LinkedList<Node2>();
                    q.add(new Node2(startId, 0));
                    visited.add(startId);
                    shortestPaths[i] = getDistance(startId, i);
                }
            }
            return shortestPaths;
        }
        
        public int getDistance(int source, int target) {
        	if(matrix[source][target] > 0)
            	return matrix[source][target]*DISTANCE;
        	if(matrix[source][target] == -1)
            	return matrix[source][target];
            
        	while(!q.isEmpty()) {
                Node2 n = q.poll();
            	matrix[source][n.node] = n.level;
            	matrix[n.node][source] = n.level;
                addLinkedNodes(n.node, n.level+1);
            }
            if (matrix[source][target] == 0) {
            	matrix[source][target] = -1;
            	matrix[target][source] = -1;
            	return matrix[source][target];
            } else 
            	return matrix[source][target]*DISTANCE;
        }
        
        public void addLinkedNodes(int node, int level) {
            for (int i = 0; i < matrix.length; i++) {
                if (i != node && !visited.contains(i) && matrix[i][node] > 0) {
                    q.add(new Node2(i, level));
                    visited.add(i);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}

class Node2 {
    public int node;
    public int level;
    
    public Node2(int node, int level) {
        this.node = node;
        this.level = level;
    }
}