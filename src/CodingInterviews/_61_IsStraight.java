package CodingInterviews;

import java.util.HashSet;

/*
* 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
* 2～10为数字本身，A为1，J为11，Q为12，K为13，
* 而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

            示例 1:
            输入: [1,2,3,4,5]
            输出: True
            示例 2:
            输入: [0,0,1,2,5]
            输出: True
*/
public class _61_IsStraight {

    /*
     * Note: 0 可以被当作任意数字
     *   1.除了0，无重复 用set
     *   2.max-min<5
     * */
    public boolean isStraight(int[] nums) {

        HashSet<Integer> set = new HashSet();
        int max = -1, min = 14;
        for (int num : nums) {
            if(num==0){
                continue;
            }
            if (num > max) max = num;
            if (num < min) min = num;
            if(set.contains(num)){
                return false;
            }else{
                set.add(num);
            }
        }

        return max - min < 5;
    }

    public static void main(String[] args) {
        _61_IsStraight fun = new _61_IsStraight();
        int[] arr = {1,2,3,4,5};

        System.out.println(fun.isStraight(arr));
    }
}
