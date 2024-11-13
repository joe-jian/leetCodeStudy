package everyday;//对 i, j 的数目。
//
// 整天 定义为时间持续时间是 24 小时的 整数倍 。
//
// 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
//
//
//
// 示例 1：
//
//
// 输入： hours = [12,12,30,24,24]
//
//
// 输出： 2
//
// 解释：
//
// 构成整天的下标对分别是 (0, 1) 和 (3, 4)。
//
// 示例 2：
//
//
// 输入： hours = [72,48,24,3]
//
//
// 输出： 3
//
// 解释：
//
// 构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。
//
//
//
// 提示：
//
//
// 1 <= hours.length <= 5 * 10⁵
// 1 <= hours[i] <= 10⁹
//
//
// Related Topics 数组 哈希表 计数 👍 22 👎 0

//取模运算


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public static long countCompleteDayPairs(int[] hours) {
        long count = 0;
        for (int i = 0; i < hours.length; i++){
            for (int j = i+1; j < hours.length; j++){
                if ((hours[i] + hours[j]) % 24==0){
                    System.out.println("i:"+i+" j:"+j);
                    count++;
                }
            }
        }
        return count;
    }
        public static long countCompleteDayPairs2(int[] hours) {
            Map<Integer, Integer> remainderCount = new HashMap<>();
            long count = 0;

            for (int hour : hours) {
                int remainder = hour % 24;
                int complement = (24 - remainder) % 24;

                // 累加与当前余数互补的余数出现的次数
                count += remainderCount.getOrDefault(complement, 0);

                // 更新当前余数的出现次数
                remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
            }
            return count;
        }


    public static void main(String[] args) {
        System.out.println(countCompleteDayPairs2(new int[]{12,12,12,12,24,24}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
