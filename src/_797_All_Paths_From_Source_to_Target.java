import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _797_All_Paths_From_Source_to_Target {

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {},
        };

        System.out.println(allPathsSourceTarget(graph));
    }

    static public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> path;
        for (int adjNode : graph[0]) {
            path = new Stack<>();
            path.push(0);
            findPathToTarget(ans, path, graph, adjNode, n);
        }
        return ans;
    }

    static public void findPathToTarget(List<List<Integer>> ans, Stack<Integer> path, int[][] graph, int startNode, int n) {
        path.push(startNode);
        if (startNode == n) {
            System.out.println("path:> " + path);
            ans.add(new ArrayList<>(path));
            return;
        } else {
            if (graph[startNode].length > 0) {
                for (int nextNode : graph[startNode]) {
                    findPathToTarget(ans, path, graph, nextNode, n);
                    path.pop();
                }
            }
        }
    }
}
