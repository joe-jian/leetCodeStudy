package everyday;

/**
 * leetcode 633
 * 题目解析判断一个数是否可以表示为两个完全平方数的和
 */

public class judgeSquareSum {


    /**
     * 尽管费马两平方和定理的证明过程十分复杂，但是它的意义和应用却是非常明确的。它告诉我们，平方数的和不可能再次是一个平方数，这是数学中的一个基本原理。
     * 通过理解和运用这个定理，我们可以更好地理解数学中的其他概念和定理，并将其应用于实际问题中，
     * 根据费马平方和定理，一个正整数 c 可以表示为两个完全平方数的和，当且仅当 c 的所有形如 4k + 3 的质因数的指数均为偶数。
     * 代码实现
     * 上述代码正是基于这一数学原理实现的。具体步骤如下：
     * 遍历因子：从2开始遍历所有可能的因子 i，直到 i * i 大于 c。
     * 计算幂次：对于每个因子 i，计算 c 中 i 的幂次 count，并不断将 c 除以 i。
     * 检查条件：如果 i 模4等于3且 count 是奇数，则 c 不能表示为两个完全平方数的和，返回 false。
     * 最终检查：循环结束后，检查 c 模4是否不等于3，如果是则返回 true，否则返回 false。
     */
    public static boolean judgeSquareSum(int c) {
        //判断一个非负数的整数是不是 两个数正整数的平方和if(a^2+b^2=c)

        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            while (c % i == 0) {
                count++;
                c /= i;
            }
            if (i % 4 == 3 && count % 2 != 0)
                return false;
        }
        return c % 4 != 3;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(0));
    }


//    public static boolean judgeSquareSumV2(int c) {
//        //判断一个非负数的整数是不是 两个数正整数的平方和if(a^2+b^2=c)
//        // 思路：从2开始判断，如果能被整除，则将c除以i，并且count++，直到c不能被i整除，然后判断count是否为奇数，如果是，则返回false，否则返回true。
//        for (int i = 2; i * i <= c; i++) {
//            int count = 0;
//            while (c % i == 0) {
//                count++;
//            }
//        }
//    }

    public static boolean judgeSquareSumV3(int c) {
        //首先按照自己的思路，判断一个非负数的整数是不是 两个数正整数的平方和if(a^2+b^2=c)
        boolean flag = false;
        for (int i = 0; i * i <= c; i++) {
            int i1 = c - i * i;
            double sqrt = Math.sqrt(i1);
            if (sqrt == (int) sqrt) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 双指针 写法
     */
    public static boolean judgeSquareSumV4(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

}
