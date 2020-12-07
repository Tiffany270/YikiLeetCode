package CodingInterviews;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

            示例:
            s = "abaccdeff"
            返回 "b"
            
            s = ""
            返回 " "
*/
public class _50_FirstUniqChar {
    /*
     * Solution: HashMap and LinkedHashMap
     *
     * NOTE: hashMap is non-order
     *       linkedHashMap is order basic the order of your insert
     *
     *  save time : use linkedHashMap
     *
     * */


    public char firstUniqChar(String s) {

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char item : s.toCharArray()) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }

        }

        for (Map.Entry<Character, Integer> d : map.entrySet()) {
            if (d.getValue() == 1) return d.getKey();
        }

        return ' ';
    }
}
