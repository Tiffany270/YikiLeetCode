package String.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* Given a string,
* find the length of the longest substring without repeating characters.

    Example 1:
    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

* */
public class _03_Longest_Substring_Without_Repeating_Characters {

    /*Note: use HashSet and sliding window
    * API:  Set<T> set = new HashSet<>();set.contains(v); string.charA(j);  getMax = Math.max(x,y)
    * count length:    0 1 2 3 4
    *                  1_2_3_4_5
                     [2~4] len = i3-i1 + 1(itself) = 3-1 +1 = 3
    * */


    public int lengthOfLongestSubstring(String s) {

        int res = 0;
        int len = s.length();
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++)); //  here s.set an ele then j already plus
                res = Math.max(res, j - i); // so use j-i
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return res;
    }

    /*
     solution 2
     change Set to Map that only store index instead full string.
     API:   Map<Character, Integer> map = new HashMap();
            map.containsKey(k); map.put(v);map.get(k)
    */

    public int lengthOfLongestSubstring2(String s) {

        int res = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0, j = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);// use Max mesas never looking back
            }
            res = Math.max(res, j - i + 1); // j not plus yet, need add 1 to get a real length ( indicate j itself)
            map.put(s.charAt(j), j + 1); // (j+1) means skip duplicate
            System.out.println(map.toString()); // will update the value of key ( union key)
        }


        return res;
    }

    public static void main(String[] args) {
        _03_Longest_Substring_Without_Repeating_Characters func = new _03_Longest_Substring_Without_Repeating_Characters();
        int res = func.lengthOfLongestSubstring2("abcabdc");
        System.out.println(res);
    }


}
