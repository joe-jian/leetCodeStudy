package everyday;
/*
*
困难
相关标签
相关企业
提示
给你一个整数数组 nums 和一个二维数组 queries，其中 queries[i] = [posi, xi]。

对于每个查询 i，首先将 nums[posi] 设置为 xi，然后计算查询 i 的答案，该答案为 nums 中 不包含相邻元素 的
子序列
 的 最大 和。

返回所有查询的答案之和。

由于最终答案可能非常大，返回其对 109 + 7 取余 的结果。

子序列 是指从另一个数组中删除一些或不删除元素而不改变剩余元素顺序得到的数组。



示例 1：

输入：nums = [3,5,9], queries = [[1,-2],[0,-3]]

输出：21

解释：
执行第 1 个查询后，nums = [3,-2,9]，不包含相邻元素的子序列的最大和为 3 + 9 = 12。
执行第 2 个查询后，nums = [-3,-2,9]，不包含相邻元素的子序列的最大和为 9 。

示例 2：

输入：nums = [0,-1], queries = [[0,-5]]

输出：0

解释：
执行第 1 个查询后，nums = [-5,-1]，不包含相邻元素的子序列的最大和为 0（选择空子序列）。



提示：

1 <= nums.length <= 5 * 104
-105 <= nums[i] <= 105
1 <= queries.length <= 5 * 104
queries[i] == [posi, xi]
0 <= posi <= nums.length - 1
-105 <= xi <= 105*/
//首先是解析题的意思
/* 对于num=[3,5,9], queries = [[1,-2],[0,-3]]
    把 num的索引为1 的改为-2, num= [3,-2,9] 不相邻的子序列的最大和为 3+9=12
    把 num的索引为0 的改为-3, num= [-3,-2,9] 不相邻的子序列的最大和为 9 （因为9可以单选）
*
* */

public class maximumSumSubsequence {

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        if (queries.length == 0 || nums.length == 0) {
            throw new RuntimeException("数组为空");
        }
        int maxValue = 0;
        //分为两个部分 1.循环 queries 2.循环 nums 获取不相邻的最大值


        return maxValue;
    }

    public static int getMax(int[] nums) {
        //获取所有不相邻的 子序列的
        int ans = 0;
        if (nums.length == 2) {
            if (nums[0] >= nums[1] && nums[0] > 0) {
                ans = nums[0];
            } else if (nums[1] >= nums[0] && nums[1] > 0) {
                ans = nums[1];
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                int temp = 0;
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[j] > 0) {
                        int i1 = nums[i] + nums[j];
                        temp = Math.max(temp, i1);
                    } else {
                        temp = nums[i];
                    }
                }

                temp = nums[i];

                ans = Math.max(ans, temp);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getMax(new int[]{-2, -3, 9}));
    }

}
