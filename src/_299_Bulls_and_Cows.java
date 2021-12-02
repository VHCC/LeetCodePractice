import java.util.HashMap;

public class _299_Bulls_and_Cows {

    public static void main(String[] args) {
        String secret = "180071";
        String guess  = "781000";

        System.out.println(getHint(secret, guess));
    }


    static public String getHint(String secret, String guess) {
        HashMap<Character, Integer> countMap = new HashMap<>();

        for (char c : secret.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int bulls = 0;
        int cats = 0;
        for (int index = 0; index < guess.length(); index++) {
            if (secret.charAt(index) == guess.charAt(index)) {
                bulls++;
                if (countMap.get(guess.charAt(index)) == 0) {
                    cats--;
                } else {
                    countMap.put(guess.charAt(index), countMap.get(guess.charAt(index)) - 1);
                }
            } else {
                if (!countMap.containsKey(guess.charAt(index))) {
                    // TODO DO NOTHING
                } else {
                    if (countMap.get(guess.charAt(index)) > 0) {
                        cats++;
                        countMap.put(guess.charAt(index), countMap.get(guess.charAt(index)) - 1);
                    }
                }
            }
        }


        System.out.println(countMap);
        return String.valueOf(bulls) + "A" + String.valueOf(cats) + "B";
    }
}
