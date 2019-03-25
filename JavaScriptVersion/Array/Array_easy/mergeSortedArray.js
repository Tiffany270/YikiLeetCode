/**88
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {

    let i = m - 1, j = n - 1;//因为索引从0开始
    let k = n + m - 1;
    while (i > -1 && j > -1) {//不要忘记括号
        nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
    }
    while (j > -1) {
        nums1[k--] = nums2[j--];
    }


};