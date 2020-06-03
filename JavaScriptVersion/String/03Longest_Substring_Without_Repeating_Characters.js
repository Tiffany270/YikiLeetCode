/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {


    var len = s.length;
    var map = new Map();
    var res = 0;

    for (var i = 0, j = 0; j < len; j++) {
        if (map.has(s[j])) {
            i = Math.max(map.get(s[j]), i);
        }
        res = Math.max(res, j - i + 1);
        map.set(s[j], j + 1);
    }

    return res;

};

var res = lengthOfLongestSubstring('abcabdceb');
console.log((res));