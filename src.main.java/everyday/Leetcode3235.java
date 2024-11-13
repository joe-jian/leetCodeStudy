package everyday;

/**
*   leetcode3235. 找出矩阵中是否能从 左上角 到 右下角的一条路径
 *   xCorner 和 yCorner 坐标的矩形的x轴和y轴形成的矩形
 *   circles表示的是 [[2,1,1],[1,2,1]]。  坐标问2，1 半径为1的圆 和 坐标问1，2 半径为1的圆
 *   ，且路径上所有数字都满足其 下标之和等于 数字的值
* */
public class Leetcode3235 {
    // 思路解析 1 .获取 矩形的 长宽 可以理解 x, y 的坐标 只要是 0，0 和 x,y 之间没有圆，
    //1 在圆内，那么就有可能无法到达，2 在圆外，那么就肯定能到达

    // 和
    // 那么就可以通过坐标来判断是否能到
    public boolean canReachCorner(int xCorner, int yCorner, int[][] circles) {



        return false;
    }


}
