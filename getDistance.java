import java.util.HashMap;
import java.util.Map;

public class DistanceCalculator {

    public static int getDistance(String word) {
        String[][] keyword = {
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"},
            {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"},
            {"A", "S", "D", "F", "G", "*", "H", "J", "K", "L"},
            {" ", "Z", "X", "C", "V", "B", "N", "M", " ", " "}
        };

        Map<Character, int[]> set = new HashMap<>();
        
        for (int i = 0; i < keyword.length; i++) {
            for (int j = 0; j < keyword[i].length; j++) {
                set.put(keyword[i][j].charAt(0), new int[]{i, j});
            }
        }

        int[] ini = set.get('*');
        int result = 0;

        for (char c : word.toCharArray()) {
            int[] j = set.get(c);
            result += Math.abs(ini[0] - j[0]) + Math.abs(ini[1] - j[1]);
            ini = j;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getDistance("QZ"));
        System.out.println(getDistance("QA"));
        System.out.println(getDistance("HELLO123"));
    }
}
