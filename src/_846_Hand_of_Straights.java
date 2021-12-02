import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _846_Hand_of_Straights {

    public static void main(String[] args) {
//        int[] hand = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8, 1, 2, 3, 6, 2, 3, 4, 7, 8, 1, 2, 3, 6, 2, 3, 4, 7, 8, 1, 2, 3, 6, 2, 3, 4, 7, 9};
        int[] hand = new int[]{2,3,4,5,6,
        101,102,104,105,103,
        7,9,10,11,8};
        int groupSize = 5;
        // [2,3,4,5,6]
        // [7,8,9,10,11]
        // [101,102,103,104,105]


        System.out.println(isNStraightHand(hand, groupSize));
    }

    static public boolean isNStraightHand(int[] hand, int groupSize) {
        System.out.println("length:> " + hand.length);
        if (hand.length % groupSize != 0) {
            return false;
        }

        int groupTarget = hand.length / groupSize;

        HashMap<Integer, Integer> cardCount = new HashMap<>();

        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        System.out.println(cardCount);
        Arrays.sort(hand);

        for (int c : hand) {
            System.out.print(c + ", ");
        }
        System.out.println();

        int groupCounts = 0;

        for (int i = 0; i < hand.length; i++) {
            int groupCount = 0;
            Stack<Integer> group = new Stack<>();
            while (groupCount < groupSize) {
                int check = hand[i] + groupCount++;
                if (cardCount.getOrDefault(check, -1) == 0) {
//                    return false;
                } else {
                    group.push(check);
                }
            }

            if (group.size() == groupSize) {
                System.out.println(group);
                groupCounts++;
                while (!group.empty()) {
                    int target = group.pop();
                    if (cardCount.get(target) == null || cardCount.get(target) == 0) {
                        System.out.println("target:> " + target + " is NULL");
                        return false;
                    }
                    cardCount.put(target, cardCount.getOrDefault(target, 0) - 1);
                }
            }

        }

        if (groupCounts == groupTarget) {
            return true;
        }


        return false;
    }


}
