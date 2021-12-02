import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _1971_Find_if_Path_Exists_in_Graph {


    public static void main(String[] args) {

//        int n = 3;
        int n = 1;
//        int[][] edges = new int[][]{
//                {0, 1},
//                {1, 2},
//                {2, 0},
//        };

        int[][] edges = new int[][]{
                {0, 1},
                {1, 2},
                {2, 0},
        };

//        int[][] edges = new int[][]{
//                {0, 1},
//                {0, 2},
//                {3, 5},
//                {5, 4},
//                {4, 3},
////                {1, 3},
//        };


        System.out.println(validPath(n, edges, 0, 0));
    }


    static public boolean validPath(int n, int[][] edges, int start, int end) {
        if (n == 1) return true;
        List<List<Integer>> adj = new ArrayList<>();
        createGraph(n, edges, adj);
        boolean[] visited = new boolean[n];
        canTouchEnd(start, end, adj, visited);
        return isExist;
    }

    static boolean isExist = false;

    static public void canTouchEnd(int start, int end, List<List<Integer>> adj, boolean[] visited) {
        visited[start] = true;

        for (int node : adj.get(start)) {
            if (visited[node] || isExist) {
                System.out.println("VISITED node:> " + node);
                continue;
            }
            if (node == end) {
                System.out.println("FIND TARGET:> " + node);
                isExist = true;
                return ;
            }
            canTouchEnd(node, end, adj, visited);
        }
        return;

    }

    static public void createGraph(int n, int[][] edges, List<List<Integer>> adj) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }



        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        System.out.println(adj);

    }
}
