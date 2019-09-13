package Array.Medium;

/*
* Given an array of integers nums sorted in ascending order,
* find the starting and ending position of a given target value.
* Your algorithm's runtime complexity must be in the order of O(log n).
* If the target is not found in the array, return [-1, -1].
* Example 1:
 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:
 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
* */


import java.util.Arrays;

public class Yiki_34_FindFirstandLastPositionofElementinSortedArray {

 private static int search2(int key, int[] arr) {
  if (arr.length <= 0) {
   return -1;
  }

  int lo = 0;
  int hi = arr.length - 1;

  while (lo < hi) {
   int mid = (hi - lo) / 2 + lo;
   if (arr[mid] >= key) {
    hi = mid;
   } else if (arr[mid] < key) {
    lo = mid + 1;
   }
  }
  return arr[lo] == key ? lo : -1;
 }


 //sorted & element repeat & find the last position
 private static int search3(int key, int[] arr) {
  if (arr.length <= 0) {
   return -1;
  }
  int lo = 0;
  int hi = arr.length - 1;

  while (lo < hi) {
   //让mid在二分的时候趋于右而不是左边，避免死循环
   int mid = (hi - lo + 1) / 2 + lo;
   if (arr[mid] <= key) {
    lo = mid;
   } else {
    hi = mid - 1;
   }
  }
  return arr[hi] == key ? hi : -1;
 }


 private static int[] searchRange(int[] nums, int target) {
  int[] res = {-1, -1};

  int first = search2(target, nums);
  int last = search3(target, nums);

  res[0] = first;
  res[1] = last;

  return res;


 }

 public static void main(String[] args) {
  int[] nums = {5, 7, 7, 8, 8, 10};
  int t1 = 8;


  int t2 = 6;

  System.out.println(Arrays.toString(searchRange(nums, t1)));
  System.out.println(Arrays.toString(searchRange(nums, t2)));
 }

}
