import java.util.Scanner;
import java.util.Stack;

public class ConnectedCell {
    
    public static int getBiggestRegion(int[][] matrix) {
        Stack<Node1> s = new Stack<Node1>();
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int numberOfCells = 0;
        int largestNumberOfCells = 0;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == 1 && !visited[row][col]) {
                	s.push(new Node1(row, col));
                	visited[row][col] = true;
                    numberOfCells = getNumberOfAdjacentCells(s, matrix, visited, n, m) + 1;
                    if(largestNumberOfCells < numberOfCells)    
                        largestNumberOfCells = numberOfCells;
                }
            }
        }
        return largestNumberOfCells;
    }
    
    public static int addAdjacentCells(Stack<Node1> s, int[][] matrix, int row, int col, boolean[][] visited, int n, int m) {
        int numberOfCells = 0;
    	if (row - 1 >= 0 && col - 1 >= 0 && !visited[row-1][col-1] && matrix[row-1][col-1] == 1) {
            s.push(new Node1(row - 1, col - 1));
            visited[row-1][col-1] = true;
            numberOfCells++;
        }
        if (row - 1 >=0 && !visited[row-1][col] && matrix[row-1][col] == 1) {
            s.push(new Node1(row - 1, col));
            visited[row-1][col] = true;
            numberOfCells++;
        }
        if (col - 1 >= 0 && !visited[row][col-1] && matrix[row][col-1] == 1) {
            s.push(new Node1(row, col - 1));
            visited[row][col-1] = true;
            numberOfCells++;
        }
        if (row + 1 < n && col + 1 < m && !visited[row+1][col+1] && matrix[row+1][col+1] == 1) {
            s.push(new Node1(row+1, col+1));
            visited[row+1][col+1] = true;
            numberOfCells++;
        }
        if (row + 1 < n && !visited[row+1][col] && matrix[row+1][col] == 1) {
        	s.push(new Node1(row+1, col));
        	visited[row+1][col] = true;
            numberOfCells++;
        }
        if (col + 1 < m && !visited[row][col+1] && matrix[row][col+1] == 1) {
            s.push(new Node1(row, col+1));
            visited[row][col+1] = true;
            numberOfCells++;
        }
        if (col + 1 < m  && row - 1 >= 0 && !visited[row-1][col+1] && matrix[row-1][col+1] == 1) {
            s.push(new Node1(row-1, col+1));
            visited[row-1][col+1] = true;
            numberOfCells++;
        }
        if (col - 1 >= 0  && row + 1 < n && !visited[row+1][col-1] && matrix[row+1][col-1] == 1) {
            s.push(new Node1(row+1, col-1));
            visited[row+1][col-1] = true;
            numberOfCells++;
        }
        return numberOfCells;
    }
    
    public static int getNumberOfAdjacentCells(Stack<Node1> s, int[][] matrix, boolean[][] visited, int n, int m) {
        int numberOfCells = 0;
        while (!s.empty()) {
            Node1 current = s.pop();
            visited[current.row][current.col] = true;
            numberOfCells += addAdjacentCells(s, matrix, current.row, current.col, visited, n, m);
        }
        return numberOfCells;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}

class Node1 {
    public int row;
    public int col;
    
    public Node1(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
