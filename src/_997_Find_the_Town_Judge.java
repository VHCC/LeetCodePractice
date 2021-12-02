import java.util.ArrayList;
import java.util.List;

public class _997_Find_the_Town_Judge {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = new int[][]{
//                {1, 2},
                {1, 3},
                {2, 3},
                {3, 1},
//                {4, 3},
        };

        System.out.println(findJudge(n, edges));
    }

    static public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adjArray = new ArrayList<>();
        createGraph(n, trust, adjArray);

        int[] links = new int[n + 1];
        for (int[] nodes : trust) {
            links[nodes[1]] += 1;
        }


        for (int link : links) {
            System.out.print(link + ", ");
        }
        System.out.println("");

        System.out.println(adjArray);

        for (int label = 1; label <= n; label++) {
            System.out.println("links[" + label + "]:> " + links[label]);
            if (links[label] == (n - 1) && (adjArray.get(label).size() == 0)) {
                return label;
            }
        }

        return -1;
    }

    public static void createGraph(int n, int[][] trust, List<List<Integer>> adjArray) {
        for (int i = 0; i< n + 1; i++) {
            adjArray.add(new ArrayList<>());
        }
        for (int[] nodes : trust) {
            adjArray.get(nodes[0]).add(nodes[1]);
        }
    }
}
