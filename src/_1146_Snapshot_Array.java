import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _1146_Snapshot_Array {
    public static void main(String[] args) {

        List<Integer> qqq = new ArrayList<>();

        SnapshotArray snapshotArray = new SnapshotArray(4);
//        snapshotArray.set(0, 15);
        snapshotArray.snap();
        snapshotArray.snap();
        System.out.println(snapshotArray.get(3, 1));
        snapshotArray.set(2, 4);
        snapshotArray.snap();
        snapshotArray.set(1, 4);
        System.out.println(snapshotArray.get(3, 1));
    }


    static class SnapshotArray {
        private int arrayLength;

        int snapIndex; // will be 0
        HashMap<Integer, HashMap> snapMap;
        HashMap<Integer, Integer> historyMap;

        public SnapshotArray(int length) {
            this.arrayLength = length;
            this.snapMap = new HashMap<>();
            this.historyMap = new HashMap<>();
        }

        public void set(int index, int val) {

            if (!snapMap.containsKey(snapIndex)) {
                snapMap.put(snapIndex, historyMap);
            }
            HashMap<Integer, Integer> currentSnap = snapMap.get(snapIndex);
            currentSnap.put(index, val);
        }

        public int snap() {
//            HashMap<Integer, Integer> saveMap = new HashMap<>();

            if (snapMap.containsKey(snapIndex)) {
                snapMap.put(snapIndex + 1, new HashMap(snapMap.get(snapIndex)));
            } else {
                snapMap.put(snapIndex + 1, new HashMap());
            }
            return snapIndex++;
        }

        public int get(int index, int snap_id) {
            if (!snapMap.containsKey(snap_id)) return 0;
            return (int) snapMap.get(snap_id).getOrDefault(index, 0);
        }

    }


//    static class SnapshotArray {
//        HashMap<Integer, List<Integer>> snapMap;
//        HashMap<List<Integer>, List<Integer>> listMAp;
//        int snapTime = 0;
//        List<Integer> tempArray;
//        int arrayLength = 0;
//
//        public SnapshotArray(int length) {
//            arrayLength = length;
//            snapMap = new HashMap<>();
//            listMAp = new HashMap<>();
//            tempArray = new ArrayList<>();
//            for (int i = 0; i < arrayLength; i++) {
//                tempArray.add(0);
//            }
////            System.out.println(tempArray);
//        }
//
//        public void set(int index, int val) {
//            tempArray.set(index, val);
//        }
//
//        public int snap() {
//            snapMap.put(snapTime, listMAp.getOrDefault(tempArray, new ArrayList<>(tempArray)));
//            return snapTime++;
//        }
//
//        public int get(int index, int snap_id) {
//            System.out.println(snapMap);
//            List<Integer> getArray = snapMap.get(snap_id);
//            return getArray.get(index);
//        }
//
//    }

}
