import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _310_Minimum_Height_Trees {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][]{
//                {1, 0},
//                {1, 2},
//                {2, 3},
                {3,0},
                {3,1},
                {3,2},
                {3,4},
                {5,4},
        };


        System.out.println(findMinHeightTrees(n, edges));
    }

    static public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }


        List<List<Integer>> adj = new ArrayList<>();
        int[] inlinks = new int[n];
        createGraph(n, edges, adj, inlinks);

        List<Integer> leaves = new LinkedList<>();
        System.out.print("leaves:> ");
        for (int i = 0; i < inlinks.length; i++) {
            if (inlinks[i] == 1) {
                leaves.add(i); // 確認leaves點
            }
        }

        System.out.println(leaves);

        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leave : leaves) {
                for (int nb : adj.get(leave)) {
                    inlinks[nb]--;
                    if (inlinks[nb] == 1) {
                        newLeaves.add(nb);
                    }
                }
            }
            n -= leaves.size();
            leaves = newLeaves;
        }

        return leaves;
    }

    static public void createGraph(int n, int[][] edges, List<List<Integer>> adjacent, int[] inlinks) {
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<Integer>()); // 初始每個點的adjacent nodes
        }
        for (int[] e : edges) {
            adjacent.get(e[0]).add(e[1]); //製作連結點
            adjacent.get(e[1]).add(e[0]);
            inlinks[e[0]]++; // 累積Node的邊數
            inlinks[e[1]]++;
        }
        System.out.print("Nodes Links:> ");
        for (int link : inlinks) {
            System.out.print(link + ", ");
        }
        System.out.println("");
        System.out.println(adjacent);
    }

}
