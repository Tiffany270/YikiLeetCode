package BaseExm;

import java.util.Arrays;

public class BinarySearch {
 /*二分查找
  * poitn :
  * 1.   int mid = (hi - lo) / 2 + lo;
  * 试想lo已经移动不为0，中间数肯定是（后-前）/2，但如果贸然(hi-lo)/2是会错误的，
  * */

 //sorted & element not repeat
 private  int search(int key, int[] arr) {
  if (arr.length <= 0) {
   return -1;
  }

  int lo = 0;
  int hi = arr.length - 1;

  while (lo <= hi) {
   int mid = (hi - lo) / 2 + lo;
   if (arr[mid] == key) {
    return mid;
   } else if (arr[mid] < key) {
    lo = mid + 1;
   } else if (arr[mid] > key) {
    hi = mid - 1;
   }
  }
  return -1;
 }


 //sorted & element repeat & find the first position
 private  int search2(int key, int[] arr) {
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
 private  int search3(int key, int[] arr) {
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

 private  int[] searchRange(int[] nums, int target) {
  int[] res = {-1, -1};

  int first = search2(target, nums);
  int last = search3(target, nums);

  res[0] = first;
  res[1] = last;

  return res;

 }


 public static void main(String[] args) {

  BinarySearch b = new BinarySearch();

  int key = 8;
  int[] arr1 = {2, 4, 5, 6, 8, 9, 11, 23, 45, 67};
  int[] arr2 = {1, 2, 2, 4, 8, 8, 8};
  System.out.println(b.search(key, arr1));
  System.out.println(b.search2(key, arr2));
  System.out.println(b.search3(key, arr2));
  int[] nums = {5, 7, 7, 8, 8, 10};
  int t1 = 8;


  int t2 = 6;

  System.out.println(Arrays.toString(b.searchRange(nums, t1)));
  System.out.println(Arrays.toString(b.searchRange(nums, t2)));

  //java除法除非标注float否则为整数
//  System.out.println(5 / 3);
 }
}
