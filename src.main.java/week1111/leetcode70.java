package week1111;

/* leetcode70 爬楼梯  斐波那契数列 1 ，1 ，2，3，5，8，13，21，34，55，89，144，233，377，610，987，1597，2584，4181，6765，10946，17711，28657，46368，75025，121393，196418，317811，514229，832040，1346269，2178309，3524578，5702887，9227465，14930352，241
*
* */
public class leetcode70 {
    /**
     * 计算爬到第n个台阶的方法数
     *
     * @param n 第n个台阶
     * @return 爬到第n个台阶的方法数
     */
    public int climbStairs(int n) {
        // 当只有一个台阶时，只有一种爬法
        if (n == 1) {
            return 1;
        }
        // 当有两个台阶时，有两种爬法：一次爬两个台阶或两次爬一个台阶
        if (n == 2) {
            return 2;
        }
        // 当台阶数大于2时，爬到第n个台阶的方法数等于爬到第n-1个台阶的方法数加上爬到第n-2个台阶的方法数
        // 这是因为从第n-1个台阶爬一个台阶到第n个台阶或从第n-2个台阶爬两个台阶到第n个台阶
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    /**
     * 使用动态规划的方法爬楼梯
     * 这个版本的函数使用了一个数组来存储到达每个阶梯的方法数，避免了重复计算，提高了效率
     *
     * @param n 楼梯的总数
     * @return 到达楼顶的方法总数
     */
    public int climbStairsV2(int n)
    {
        // 初始化一个数组来存储到达每个阶梯的方法数
        int[] dp = new int[n + 1];

        // 基本情况：当楼梯数为0时，有1种方法（即不爬）
        dp[0] = 1;

        // 基本情况：当楼梯数为1时，有1种方法（即爬1阶）
        dp[1] = 1;

        // 从第2个阶梯开始，到第n个阶梯结束
        for (int i = 2; i <= n; i++)
        {
            // 到达当前阶梯的方法数是到达前一个阶梯和前两个阶梯的方法数之和
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 返回到达第n个阶梯的方法数
        return dp[n];
    }
    public static void main(String[] args)
    {
        leetcode70 leetcode70=new leetcode70();
        int n=5;
        int result=leetcode70.climbStairs(n);
        System.out.println(result);
    }
}
