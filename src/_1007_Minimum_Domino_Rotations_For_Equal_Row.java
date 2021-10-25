import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class _1007_Minimum_Domino_Rotations_For_Equal_Row {
    public static void main(String[] args){
//        int[] tops___ = new int[]{2,1,2,4,2,2};
//        int[] bottoms = new int[]{5,2,6,2,3,2};

//        int[] tops___ = new int[]{3,5,1,2,3};
//        int[] bottoms = new int[]{3,6,3,3,4};

//        int[] tops___ = new int[]{1,2,3,4,6};
//        int[] bottoms = new int[]{6,6,6,6,5};

//        int[] tops___ = new int[]{2,1,1,3,2,1,2,2,1};
//        int[] bottoms = new int[]{3,2,3,1,3,2,3,3,2};

//        int[] tops___ = new int[]{1,2,1,1,1,2,2,2};
//        int[] bottoms = new int[]{2,1,2,2,2,2,2,2};

        int[] tops___ = new int[]{2,1,1,1,2,2,2,1,1,2};
        int[] bottoms = new int[]{1,1,2,1,1,1,1,2,1,1};

//        int[] tops___ = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,1,1,1,1,1,2,1,2,2,1,1,2,2,2,2,2,1,1,2,2,2,2,1,2,1,1,2,1,1,1,1,2,1,2,2,2,1,2,1,2,2,1,2,1,2};
//        int[] bottoms = new int[]{2,1,1,1,2,1,2,1,2,2,1,1,1,2,1,2,2,1,2,2,2,1,2,2,1,1,1,2,1,2,2,1,2,1,1,2,1,1,1,2,1,2,2,2,2,1,2,1,1,2,1,2,2,1,2,1,1,2,2,1,2,1,1,2};
        System.out.println(minDominoRotationsGreat(tops___, bottoms));
    }

    public static int minDominoRotationsGreat(int[] A, int[] B) {
        int len  = A.length;
        int[] countSum = new int[7], countA = new int[7], countB = new int[7];
        List<Integer> listSum = new ArrayList<>(), listA = new ArrayList<>(), listB = new ArrayList<>();
        listSum.add(0);
        listSum.add(0);
        listSum.add(0);
        listSum.add(0);
        listSum.add(0);
        listSum.add(0);
        listSum.add(0);

        listA.add(0);
        listA.add(0);
        listA.add(0);
        listA.add(0);
        listA.add(0);
        listA.add(0);
        listA.add(0);

        listB.add(0);
        listB.add(0);
        listB.add(0);
        listB.add(0);
        listB.add(0);
        listB.add(0);
        listB.add(0);

        for(int i = 0 ; i < len; i++) {
            if(A[i] == B[i]){
                listSum.set(A[i], listSum.get(A[i])+1);
                countSum[A[i]]++;
            }
            else {
                countSum[A[i]]++;
                listSum.set(A[i], listSum.get(A[i])+1);
                countSum[B[i]]++;
                listSum.set(B[i], listSum.get(B[i])+1);
                countA[A[i]]++;
                listA.set(A[i], listA.get(A[i])+1);
                countB[B[i]]++;
                listB.set(B[i], listB.get(B[i])+1);
            }
        }

        System.out.println(listSum);
        System.out.println(listA);
        System.out.println(listB);

        for(int i = 1; i <= 6; i++) {
            if(countSum[i] == len) {
                System.out.println("i:> " + i + ", countA[i]:> " + countA[i] + ", countB[i]:> " + countB[i]);
                return Math.min(countA[i], countB[i]);
            }
        }
        return -1;
    }

    public static int minDominoRotationsMy(int[] tops, int[] bottoms) {
        int topH = 0;
        int bottomH = 0;
        int topPre = tops[0];
        int bottomPre = bottoms[0];
        int count = 0;
        int temp = 0;

        int targetPre = 0;

        List<Integer> newTop = new ArrayList<>();
        List<Integer> newBottom = new ArrayList<>();

        for (int index = 1; index < tops.length; index ++) {
            newTop.add(topPre);
            newBottom.add(bottomPre);
            topH = tops[index];
            bottomH = bottoms[index];
            System.out.println("[" + topPre + ", " + topH + "]");
            System.out.println("[" + bottomPre + ", " + bottomH + "]");

            if ((topH != topPre && topH != bottomPre) && (bottomH != bottomPre && bottomH != topPre)) {
                return -1;
            }
            if ((topPre == bottomPre) || (topPre == topH) || (topH == bottomH) || (bottomPre == bottomH)) {
                topPre = topH;
                bottomPre = bottomH;
                continue;
            }
            temp = topH;
            topPre = bottomH;
            bottomPre = temp;
            System.out.println("count++ =====, targetPre:> " + targetPre);
            count ++;
        }

        newTop.add(topPre);
        newBottom.add(bottomPre);

        System.out.println(newTop);
        System.out.println(newBottom);

        boolean topCheck = true;
        boolean bottomCheck = true;

        for (int top: newTop) {
            if (newTop.get(0) != top) {
                topCheck = false;
            }
        }
        for (int bottom: newBottom) {
            if (newBottom.get(0) != bottom) {
                bottomCheck = false;
            }
        }

        if (!topCheck && !bottomCheck) {
            return -1;
        }

        return count;
    }








    public int minDominoRotations(int[] tops, int[] bottoms) {
        int topH = 0;
        int bottomH = 0;
        int topPre = tops[0];
        int bottomPre = bottoms[0];
        int count = 0;
        int temp = 0;

        int targetPre = 0;

        for (int index = 1; index < tops.length; index ++) {
            topH = tops[index];
            bottomH = bottoms[index];

            if ((topH != topPre && topH != bottomPre) && (bottomH != bottomPre && bottomH != topPre)) {
                return -1;
            }
            if ((topPre == bottomPre)) {
                if (targetPre != 0 && targetPre != bottomPre) {
                    return -1;
                }
                targetPre = bottomPre;
                continue;
            }
            if ((topPre == topH)) {
                if (targetPre != 0 && targetPre != topH) {
                    return -1;
                }
                targetPre = topH;
                continue;
            }
            if ((topH == bottomH)) {
                if (targetPre != 0 && targetPre != bottomH) {
                    return -1;
                }
                targetPre = bottomH;
                continue;
            }
            if ((bottomPre == bottomH)) {
                if (targetPre != 0 && targetPre != bottomH) {
                    return -1;
                }
                targetPre = bottomH;
                continue;
            }

            temp = topH;
            topPre = bottomH;
            bottomPre = temp;
            count ++;
        }
        return count;
    }
}
