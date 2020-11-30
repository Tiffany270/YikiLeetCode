package Array.easy;

import java.util.ArrayList;
import java.util.List;

/*
* Given a non-empty array of integers nums,
* every element appears twice except for one.
* Find that single one.
Follow up:
Could you implement a solution with a linear runtime complexity and without using extra memory?

            Example 1:
            Input: nums = [2,2,1]
            Output: 1

            Example 2:
            Input: nums = [4,1,2,1,2]
            Output: 4
* */
public class _136_SingleNumber {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int item :nums){
            if(!list.contains(item)){
                list.add(item);
            }else{
                list.remove(new Integer(item));

            }
        }

        return  list.get(0);

    }
}

//Better use map but this time let's skip it ~
