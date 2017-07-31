import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PathStats {

    public static HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        int[][] adjMatrix = new int[n][n];
        for(int a0 = 0; a0 < n-1; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            adjMatrix[u-1][v-1] = 1;
            adjMatrix[v-1][u-1] = 1;
            adjMatrix[v-1][v-1] = 1;
            adjMatrix[u-1][u-1] = 1;
        }
        for(int a0 = 0; a0 < q; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            int k = in.nextInt();
            System.out.println(getPathStats(adjMatrix, u-1, v-1, k, c));
        }
        in.close();
    }
    
    public static int getPathStats(int[][] adjMatrix, int u, int v, int k, int[] c) {
        ArrayList<Integer> path = null;
        boolean[] visited = new boolean[adjMatrix.length];
        
        if (map.containsKey(u + "-" + v))
            path = map.get(u + "-" + v);
        else {
            path = new ArrayList<Integer>();
            getPath(adjMatrix, u, v, 0, path, visited);
            map.put(u + "-" + v, path);
            map.put(v + "-" + u, path);
        }
        if (path == null) {
            System.out.println("no path exists between " + u+1 + " and " + v+1);
            return 0;
        }
        //System.out.println("path: " + path.size());

        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (Integer node : path) {
            if (counts.containsKey(c[node])) {
                counts.put(c[node], counts.get(c[node]) + 1);
            } else {
                counts.put(c[node], 1);
            }
        }
        Node7[] nodes = new Node7[counts.size()];        
        //System.out.println("counts: " + Arrays.asList(counts));
        
        int i = 0;
        for (Map.Entry<Integer, Integer> e : counts.entrySet())
            nodes[i++] = new Node7(e.getKey(), e.getValue());
        
        Arrays.sort(nodes);
        //System.out.println(Arrays.toString(nodes));
        if (k-1 < 0 || k - 1 > nodes.length-1)
            return 0;
        return nodes[k-1].cValue;
    }
    
    public static boolean getPath(int[][] adjMatrix, int u, int v, int level, ArrayList<Integer> path, boolean[] visited) {
       //try {
        //if (u >= visited.length || u < 0)
        //    return false;
        visited[u] = true;
        path.add(level, u);
        //System.out.println("current:" + u);
        //System.out.println("path:" + path);
        if (u == v) {
            return true;
        }
        
        for (int i = 0; i < adjMatrix.length; i++) {
            if (!visited[i] && adjMatrix[u][i] == 1 && i != u) {
                if (getPath(adjMatrix, i, v, level+1, path, visited)) {
                    return true;
                }                
            }
        }
        //if (path.size() > level && visited.length > u) {
            path.remove(level);
            visited[u] = false;
        //}
        return false;
       //} catch (Exception e) {
       //    return false;
       //}
    }
}

class Node7 implements Comparable<Node7>{
    int cValue;
    int count;
    
    public Node7(int cValue, int count) {
        this.cValue = cValue;
        this.count = count;
    }
    
    public int compareTo(Node7 n) {
        if (this.count == n.count) 
            return n.cValue - this.cValue;
        else 
            return n.count - this.count;
    }
    
    public String toString() {
        return cValue + ":" + count;
    }
}
