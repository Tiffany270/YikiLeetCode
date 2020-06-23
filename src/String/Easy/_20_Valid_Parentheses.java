package String.Easy;

import java.util.HashMap;
import java.util.Stack;

/*
* Given a string containing just the characters
* '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

            Example 1:
            Input: "{[]}"
            Output: true

            Example 4:
            Input: "([)]"
            Output: false
* */
public class _20_Valid_Parentheses {
    /*
     * Solution: Stack + Map
     * Map for mapping
     * Stack to match, if match then pop
     *
     * NOTE:
     * " is for string , ' is for char
     *T :O(n) S :O(n)
     * */

    public boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (map.containsKey(c)) {
                char toElem = stack.isEmpty() ? '#' : stack.pop();
                if (toElem != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);

            }

        }

        return stack.isEmpty();
    }

}
