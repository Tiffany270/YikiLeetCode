package Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
        Given a string s containing only digits,
        return all possible valid IP addresses that can be obtained from s.
        You can return them in any order.
        A valid IP address consists of exactly four integers,
        each integer is between 0 and 255, separated by single dots and cannot have leading zeros.
        For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses
        and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.

            Example 1:
            Input: s = "25525511135"
            Output: ["255.255.11.135","255.255.111.35"]

            Example 2:
            Input: s = "0000"
            Output: ["0.0.0.0"]

            Example 3:
            Input: s = "1111"
            Output: ["1.1.1.1"]

            Example 4:
            Input: s = "010010"
            Output: ["0.10.0.10","0.100.1.0"]

            Example 5:
            Input: s = "101023"
            Output: [
            "1.0.10.23",
            "1.0.102.3",
            "10.1.0.23",
            "10.10.2.3",
            "101.0.2.3"]
*
* */
public class _93_RestoreIPAddresses {
    List<String> res = new ArrayList<>();
    int[] segments = new int[4];

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return res;

    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == 4) { // 仅构造作用
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < 4; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != 3) {
                        ipAddr.append('.');
                    }
                }
                System.out.println(ipAddr.toString());
                res.add(ipAddr.toString());

            }

            return;
        }
        if (segStart == s.length()) return;

        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                System.out.println(
                        "id:" + segId +
                        "  start:" + segStart+
                        "  end:" + segEnd+
                        "  addr:" + addr);
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }

    }

    public static void main(String[] args) {
        _93_RestoreIPAddresses func = new _93_RestoreIPAddresses();
        func.restoreIpAddresses("101023");
    }
}
