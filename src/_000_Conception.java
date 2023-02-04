import java.util.*;

public class _000_Conception {
    public static void main(String[] args) {
//        IntegerCheck();
//        System.out.println();

//        MergeSort();
    }


    public static void MergeSort() {
        List<Integer> a = new ArrayList<>();
        // 確保每一個Array都是由小到大

        a.add(1);
        a.add(2);
        a.add(4);


        List<Integer> b = new ArrayList<>();
        b.add(6);
        b.add(9);

        a.addAll(b);

        System.out.println(a);
    }


    public static void IntegerCheck() {
        int i1 = 1;
        int i2 = 1;
        System.out.println("is 1 = 1 ? :> " + (i1 == i2));

        int[] i1Array= new int[]{1,2};
//        System.out.println("is [1] contain 1? :> " + i1Array);

        List<Integer> i1List = new ArrayList<>();
        i1List.add(5);
        i1List.add(2);
        System.out.println("is List{1,2} contain 1 ? :> " + i1List.contains(1));
        i1List.add(1);
        System.out.println("is List{1,2,1} size ? :> " + i1List.size());
        System.out.println("i1List.remove(0) ? :> " + i1List.remove(0));
    }
}
