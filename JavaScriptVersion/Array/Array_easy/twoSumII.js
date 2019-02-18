/**167
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (numbers, target) {

    let left = 0;
    let right = numbers.length - 1;
    let res = [];
    while (left < right) {
        let sum = numbers[left] + numbers[right];

        if (sum === target) {
            res.push(left + 1);
            res.push(right + 1);
            break;
        } else if (sum > target) {
            right--;
        } else {
             left++;
        }

    }
    return res;

};