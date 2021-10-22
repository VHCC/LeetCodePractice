import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class _380_Insert_Delete_GetRandom_O_1 {
    public static void main(String[] arg0) {

        RandomizedSetB randomizedSet = new RandomizedSetB();

//        System.out.println(randomizedSet.insert(1));
//        System.out.println(randomizedSet.insert(10));
//        System.out.println(randomizedSet.insert(20));
//        System.out.println(randomizedSet.insert(30));
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.getRandom());

//        System.out.println(randomizedSet.insert(1));
//        System.out.println(randomizedSet.remove(2));
//        System.out.println(randomizedSet.insert(2));
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.remove(1));
//        System.out.println(randomizedSet.insert(2));
//        System.out.println(randomizedSet.getRandom());

//        System.out.println(randomizedSet.insert(0));
//        System.out.println(randomizedSet.insert(1));
//        System.out.println(randomizedSet.remove(0));
//        System.out.println(randomizedSet.insert(2));
//        System.out.println(randomizedSet.remove(1));
//        System.out.println(randomizedSet.getRandom());


//          System.out.println(randomizedSet.remove(0));
//          System.out.println(randomizedSet.remove(0));
//          System.out.println(randomizedSet.insert(0));
//          System.out.println(randomizedSet.getRandom());
//          System.out.println(randomizedSet.remove(0));
//          System.out.println(randomizedSet.insert(0));

        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
    }



    public static class RandomizedSetB {
        HashMap<Integer, Integer> map;
        List<Integer> intArray;
        Random rnd;

        public RandomizedSetB() {
            map = new HashMap<>();
            intArray = new ArrayList<>();
            rnd = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, intArray.size());
            intArray.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;

            int removedIndex = map.remove(val);
            int lastValue = intArray.remove(intArray.size() - 1);

            if (val != lastValue) {
                intArray.set(removedIndex, lastValue);
                map.put(lastValue, removedIndex);
            }
            return true;
        }

        public int getRandom() {
            return intArray.get(rnd.nextInt(intArray.size()));
        }
    }


    public static class RandomizedSet {
        List<String> stringArray;
        Random rnd;

        public RandomizedSet() {
            stringArray = new ArrayList<>();
            rnd = new Random();
        }

        public boolean insert(int val) {
            if (stringArray.contains(String.valueOf(val))) return false;
            stringArray.add(String.valueOf(val));
            return true;
        }

        public boolean remove(int val) {
            if (!stringArray.contains(String.valueOf(val))) return false;
            stringArray.remove(String.valueOf(val));
            return true;
        }

        public int getRandom() {
            return Integer.parseInt(stringArray.get(rnd.nextInt(stringArray.size())));
        }
    }
}
