
import java.util.HashMap;

public class _1306_Jump_Game_III {

    public static void main(String[] args) {
        int start = 5;
//        int[] input = new int[]{3,0,2,1,2};
        int[] input = new int[]{4,2,3,0,3,1,2};

        System.out.println(canReach(input, start));
    }

    public static HashMap<Integer, Boolean> visited = new HashMap<>();
    public static boolean canReach(int[] arr, int start) {

        return findNext(arr, start);
    }

    public static boolean findNext(int[] arr, int index) {
        System.out.println("index:> " + index);
        if (visited.get(index) != null) return false;
        visited.put(index, true);
        System.out.println("visited:> " + visited);
        int value = arr[index];
        if (value == 0) return true;

        if (((index + value) < arr.length))   {
            if(findNext(arr, index + value)) return true;
        }
        if (((index - value) >= 0)) {
            if (findNext(arr, index - value)) return true;
        }
        return false;
    }

}
