import java.util.HashMap;

public class _165_Compare_Version_Numbers {
    public static void main(String[] args){
        String version1 = "7.5.2.4";
//        String version1 = "1.01";
        String version2 = "7";
//        String version2 = "1.001";
        System.out.println("version1:> " + version1 + ", version2:> " + version2 + ", :> " + compareVersionB(version1, version2));
    }

    public static int compareVersionB(String version1, String version2) {
        int temp1 = 0,temp2 = 0;
        int len1 = version1.length(),len2 = version2.length();
        int i = 0,j = 0;
        while(i<len1 || j<len2) {
            temp1 = 0;
            temp2 = 0;
            while(i<len1 && version1.charAt(i) != '.') {
                temp1 = temp1*10 + version1.charAt(i++)-'0';
            }
            System.out.println("temp1:> " + temp1);
            while(j<len2 && version2.charAt(j) != '.') {
                temp2 = temp2*10 + version2.charAt(j++)-'0';

            }
            System.out.println("temp2:> " + temp2);
            if(temp1>temp2) return 1;
            else if(temp1<temp2) return -1;
            else {
                i++;
                j++;
            }
        }
        return 0;

    }

    public static int compareVersion(String version1, String version2) {
        HashMap<String, Integer> version1Map = new HashMap<>();
        HashMap<String, Integer> version2Map = new HashMap<>();

        int v1Index = 1;
        String[] v1Split = version1.split("\\.");
        for(String v1 : v1Split) {
            version1Map.put(String.valueOf(v1Index), Integer.valueOf(v1));
            v1Index ++;
        }

//        System.out.println(version1Map);

        int v2Index = 1;
        String[] v2Split = version2.split("\\.");
        int v1Num = 0;
        for(String v2 : v2Split) {
            v1Num = version1Map.get(String.valueOf(v2Index)) == null ? 0 : version1Map.get(String.valueOf(v2Index));
            version1Map.put(String.valueOf(v2Index), (v1Num - Integer.valueOf(v2)));
            if (v1Num > Integer.valueOf(v2)) {
                return 1;
            } else if (v1Num < Integer.valueOf(v2)) {
                return -1;
            }
            v2Index ++;
        }
        System.out.println(version1Map);
        for (int a:version1Map.values()){
            if (a > 0) {
                return 1;
            }
        }
        return 0;
    }
}
