/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {

    var rows = [];

    for (var r = 0; r < numRows; r++) {
        rows.push([]);
    }

    var curRow = 0;
    var goingDown = false;

    for (var c in s) {
        if (numRows < 2) {
            rows[curRow].push(s.charAt(c));
            continue;
        }
        rows[curRow].push(s.charAt(c));
        if (curRow === 0 || curRow === numRows - 1) {
            goingDown = !goingDown;
        }
        curRow += goingDown ? 1 : -1;
    }
    var res = '';

    rows.forEach(function (x) {
        x.forEach(function (y) {
            res += y;
        })
    });

    return res;

};

var res = convert('PAYPALISHIRING', 4);
