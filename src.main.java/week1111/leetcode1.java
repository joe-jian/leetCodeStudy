package week1111;

// leetcode1 两数之和   暴力解法

import java.util.HashMap;
import java.util.Map;

public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
       return res;
    }
    // 第二种方案
    public int[] twoSumV2(int[] nums, int target){
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[0] = map.get(temp);
                res[1] = i;
                return res;
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        leetcode1 l = new leetcode1();
        int[] ans = l.twoSum(nums, target);
        for(int i : ans){
            System.out.println(i);
        }
    }
}
