package String.Medium;

import java.util.ArrayList;

public class _06_ZigZag_Conversion {
    /* (锯齿形）
    * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)

                P   A   H   N
                A P L S I I G
                Y   I   R


        Example:

        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:

        P     I    N
        A   L S  I G
        Y A   H R
        P     I

*/

    /**
     * Note : ArrayList
     * ArrayList  provides us dynamic arrays in Java,
     * its size can increase if collection grows or shrunk if objects are removed from the collection
     *
     *
     * Solution :
     * rowIndex = 0, go down
     * rowIndex = numRow, go up
     */
    public String convert(String s, int numRows) {

        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int r = 0; r < numRows; r++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) { // loop string but not for(i)

            if(numRows<2){// handle some special situation like numRows=1
                rows.get(curRow).append(c);
                continue;// not break!
            }
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }


        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }

        return res.toString();

    }

    public static void main(String[] args) {
        _06_ZigZag_Conversion func = new _06_ZigZag_Conversion();
        String test = "AB";
        String res = func.convert(test, 1);
        System.out.println(res);

    }
}
