package Leetcode.easy;

public class _28_ImplementStr {

    // slider window
    public int strStr(String haystack, String needle) {

        int hl = haystack.length();
        int nl = needle.length();
        int loop_times = hl - nl + 1;
        for (int start = 0; start < loop_times; start++) {
            if (haystack.substring(start, start + nl).equals(needle)) {
                return start;
            }

        }


        return -1;
    }

    // those rest solutions are too complex = =.....



}
