package week1111;
// leetcode 55 跳跃游戏 //贪心算法的问题  传入一个数组 下标上的数字表示可以跳到该位置，如果跳到最后返回true，else 返回false

public class leetcode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        leetcode55 leetcode55 = new leetcode55();
        System.out.println(leetcode55.canJump(nums));
        System.out.println(leetcode55.canJump(nums2));
    }
}