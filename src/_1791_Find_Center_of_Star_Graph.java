import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _1791_Find_Center_of_Star_Graph {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1, 2},
                {2, 3},
                {4, 2},
        };

        System.out.println(findCenter(edges));
    }

    static public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> nodesEdgesCountsMap = new HashMap<>();
        for (int[] edge : edges) {
            nodesEdgesCountsMap.put(edge[0], nodesEdgesCountsMap.getOrDefault(edge[0], 0) + 1);
            nodesEdgesCountsMap.put(edge[1], nodesEdgesCountsMap.getOrDefault(edge[1], 0) + 1);
        }
        System.out.println(nodesEdgesCountsMap);

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nodesEdgesCountsMap.get(o2) - nodesEdgesCountsMap.get(o1);
            }
        });
        heap.addAll(nodesEdgesCountsMap.keySet());

//        while(!heap.isEmpty()) {
//            System.out.println();
//        }


        return heap.poll();
    }
}
