package RomanToInt;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();

        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Create an object of the class RomanToInt.RomanToInt
        RomanToInt converter = new RomanToInt();

        // Call the romanToInt method on the object
        int result = converter.romanToInt("MCMXCIV");
        System.out.println(result);  // Output: 1994
    }
}
