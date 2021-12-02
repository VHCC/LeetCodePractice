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

    public void mergeSort() {
        // Top-Down
        /* 將leftData與rightData依大小順序合併 */
//        var merge = function(leftData, rightData)ｄ{
//            var sortedData = new Array();
//            var leftIndex = 0, rightIndex = 0;
//
//            // 一一比對leftData和rightData每個元素的大小
//            // 將較小者依序填入sortedData
//            for(var i = 0; i < leftData.length + rightData.length; i++){
//
//                //如果leftData已填完, 就填入rightData的資料
//                if(leftIndex == leftData.length)
//                    sortedData.push(rightData[rightIndex++]);
//
//                    //如果rightData已填完, 就填入leftData的資料
//                else if( rightIndex == rightData.length)
//                    sortedData.push(leftData[leftIndex++]);
//
//                    // 如果leftData < rightData,則填入leftData的資料
//                else if(leftData[leftIndex] < rightData[rightIndex])
//                    sortedData.push(leftData[leftIndex++]);
//
//                    // 如果rightData < leftData,則填入leftData的資料
//                else
//                    sortedData.push(rightData[rightIndex++]);
//            }
//            return sortedData;
//        };
//
//        var mergeSort = function(data){
//            if(data.length > 1) {    // 如果資料超過1筆
//                var leftData = new Array(), rightData = new Array();
//                var middle = parseInt(data.length/2);
//
//                // 將資料分割成左右子串列
//                for(var i = 0; i < middle; i++)
//                    leftData[i] = data[i];
//                for(var j = middle; j < data.length; j++)
//                    rightData[j-middle] = data[j];
//
//                leftData = mergeSort(leftData);    // 對左子串列作合併排序
//                rightData = mergeSort(rightData);  // 對右子串列作合併排序
//                return merge(leftData, rightData); // 將左右子串列作完合併的結果合併
//            }
//            return data;    // 如果資料只有1筆,直接回傳
//        };

//執行
//        var result = mergeSort(data);
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
