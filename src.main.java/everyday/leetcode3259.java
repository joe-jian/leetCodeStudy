package everyday;
/**
* 题目解析
 * 传入两个数组 energyDrinkA 和 energyDrinkB， energyDrinkA[i] 表示第 i 个能量饮料 A 的能量，
 * 1,2,18,4,5
 * 1,10,1,2,3z
 *
 * energyDrinkB[i] 表示第 i 个能量饮料 B 的能量。
* */

public class leetcode3259 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        // 喝两个能量 如果切换要中间歇息一个小时，求获取能量的最大值，换的话可以这样理解
        //加入 当前是 A 能量，那么就换到 B 能量 的条件就是 ，
        // 如果 B 能量 energyDrinkB[i+2] > energyDrinkA[i+2]+energyDrinkA[i+1]，那么就换到 B 能量，
         return 0L;
    }
}
