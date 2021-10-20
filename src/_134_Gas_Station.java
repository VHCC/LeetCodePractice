
public class _134_Gas_Station {

    public static void main(String[] arg0) {
//        int[] gas = new int[]{3,4,5,6,7,8,9};
//        int[] cost = new int[]{4,5,6,7,8,9,3};
//        int[] gas = new int[]{1,2,3,4,5};
//        int[] cost = new int[]{3,4,5,1,2};
        int[] gas = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] cost = new int[]{0,0,0,0,0,0,0,0,0,0,0,1,0};




        int ans = 0;

        int stations = gas.length;
        boolean isGetAnswer = false;
//        int gasTotalCheck = 0;
//        int costTotalCheck = 0;
//        for (int index = 0; index < stations; index ++) {
//            gasTotalCheck += gas[index];
//            costTotalCheck += cost[index];
//        }
//
//        if (gasTotalCheck < costTotalCheck) {
//            return -1;
//        }

        for (int index = 0; index < stations; index ++) {
            int gasTotal = 0;
            int costTotal = 0;

            if (isGetAnswer) {
                break;
            }

            if (gas[index] < cost[index]) {
                ans = -1;
                continue;
            } else {
                System.out.println("index:> " + index);
                int subIndex = 0;
                while (subIndex < stations && !isGetAnswer) {
                    int targetIndex = index + subIndex >= stations ? index + subIndex - stations : index + subIndex;
                    gasTotal += gas[targetIndex];
                    costTotal += cost[targetIndex];
                    System.out.println("gasTotal:> " + gasTotal + ", costTotal:> " + costTotal);
                    if (gasTotal < costTotal) {
                        ans = -1;
                        break;
                    }

                    subIndex++;
                    System.out.println("subIndex:> " + subIndex);
                    if (subIndex == stations) {
                        isGetAnswer = true;
                        ans = index;
                        System.out.println("Ans:> " + ans);
                    }
                }
            }
        }

        System.out.println(ans);
    }


    public int solutionA () {
        int[] gas = new int[]{3,4,5,6,7,8,9};
        int[] cost = new int[]{4,5,6,7,8,9,3};
        int tank = 0;
        for(int i = 0; i < gas.length; i++)
            tank += gas[i] - cost[i];
        if(tank < 0)
            return - 1;

        int start = 0;
        int accumulate = 0;
        for(int i = 0; i < gas.length; i++){
            int curGain = gas[i] - cost[i];
            if(accumulate + curGain < 0){
                start = i + 1;
                accumulate = 0;
            }
            else accumulate += curGain;
        }

        return start;
    }
}
