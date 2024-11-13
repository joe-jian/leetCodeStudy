package everyday.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 3255
 * <p>
 * 输入：nums = [1,2,3,4,3,2,5], k = 3
 * <p>
 * 输出：[3,4,-1,-1,-1]
 * <p>
 * 解释：
 * <p>
 * nums 中总共有 5 个长度为 3 的子数组：
 * <p>
 * [1, 2, 3] 中最大元素为 3 。
 * [2, 3, 4] 中最大元素为 4 。
 * [3, 4, 3] 中元素 不是 连续的。
 * [4, 3, 2] 中元素 不是 上升的。
 * [3, 2, 5] 中元素 不是 连续的。
 * 解析 传入的k的数量 如果是连续的 就返回最大值，否则返回-1
 */

public class LetCode3255 {

    /**
     *
     */
    public static int[] resultsArray(int[] nums, int k) {
        int[] results = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = 1; j < k; j++) {
                if (nums[i + j] > max) {
                    max = nums[i + j];
                }
            }
            results[i] = max;
        }
        return results;
    }

    /**
     * 思路 1 ：获取所有的子数组，，然后返回最大值，否则返回-1
     * 然后判断是否是连续的 如果是就 返回 最大值，否则返回-1
     */
    public static int[] resultsArrayV2(int[] nums, int k) {
        //保存结果的长度
        int length = (nums.length - k) + 1;
        int[] results = new int[length];

        //保存的所有的数组
        List<int[]> list = new ArrayList<>();
        //从 第一个到最后一个进行截取 ，第一个是0- k-1  1,k 直到结束

        for (int i = k - 1, j = 0; i < nums.length; i++) {
            int[] nums1 = new int[k];
            System.arraycopy(nums, j, nums1, 0, k);
            j++;
            list.add(nums1);
        }
        for (int i = 0; i < list.size(); i++) {
            results[i] = maxSubArray(list.get(i));
        }

        return results;
    }

    public static int maxSubArray(int[] nums) {
        int maxAns = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - maxAns == 1) {
                maxAns = nums[i];
            } else {
                maxAns = -1;
                break;
            }
        }
        return maxAns;
    }

    /**
     * v2的版本有点问题，在java中 new 一个对象的开销比较大
     * 需要在堆中开配空间 ，在循环的时候创建那么多的数组，堆内存开销大，所以要更改方法
     * 在多次循环中
     * 现在的解题思路是
     * 1，2 ，3，4，5，3，2，6，7，9
     * 1，2，3 ，4，5，1，1，2，3，4
     */
    public static int[] resultsArrayV3(int[] nums, int k) {
        int length = (nums.length - k) + 1;
        int[] results = new int[length];
        Arrays.fill(results, -1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            //判断是否是连续的cnt +1 然后>k的数据进行保存 负责 cnt初始化1
            cnt = i == 0 || nums[i] - nums[i - 1] != 1 ? 1 : cnt + 1;
            if (cnt >= k) {
                results[i - k + 1] = nums[i];
            }
        }
        return results;
    }

    /**
     * 最优解
     */
    public static int[] resultsArrayBest(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt = i == 0 || nums[i] == nums[i - 1] + 1 ? cnt + 1 : 1;
            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3};
        int k = 2;
        int[] results = resultsArrayV3(nums, k);

        System.out.println(Arrays.toString(results));

    }
}
