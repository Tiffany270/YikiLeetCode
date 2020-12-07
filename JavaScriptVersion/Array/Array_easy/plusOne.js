/**
 * 66
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {

    for (let i = digits.length - 1; i >= 0; i--) {
        if (digits[i] === 9) {
            digits[i] = 0;
        } else {
            digits[i]++;
            return digits;
        }
    }

    if (digits[0] === 0) {
        // let arr = Leetcode(digits.length + 1).fill(0)
        // arr[0] = 1;
        // return arr;
        digits.unshift(1);
    }

    return digits;
};