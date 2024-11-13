package week1111;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetCode 452.用最少数量的箭引爆气球
 * 题目解析 ：
 * 求射出的最少的箭的数量，使得所有气球不重叠。
 * 如果存在重叠的坐标那么就会存在一箭射爆多个气球 没有的话 就是 每个只有一个气球的情况。（使用贪心策略处理）
 */
public class leetCode452 {
    //最终的结果就是 求气球交集的数量 （这个是错误的思路）
    // 贪心策略： 贪心策略的要求要对传入的数组的左端点进行排序，要么射击的区间从左到右 要么射击从右到左 ，不能和从中间=开始 ，要不然无法准确的判断
    // 2 . 合计区间的选择问题 ，1，刚传入一个气球 ，那么ans=1 ，射击的区间为 第一个气球的区间 ，然后传入第二个气球 那么
    // 设计区间为两个的交际，如果区间有交集，那么就取两个区间的交集，然后继续shot，直到没有交集，那么ans++，
    // 设计区间为 下个气球的区间，一次类推
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 首先对 传入的数组进行排序 冒泡排序
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] > points[j][0]) {
                    int[] temp = points[i];
                    points[i] = points[j];
                    points[j] = temp;
                }
            }
        }
        // 开始shot
        int ans = 1;
        int shot = points[0][1]; // shot的区间
        for (int i = 1; i < points.length; i++) {
            if (shot >= points[i][0]) {
                shot = Math.min(shot, points[i][1]);
            } else {
                ans++;
                shot = points[i][1];
            }
        }

//        System.out.println(Arrays.deepToString(points));

        return ans;
    }

    //存在的问题 冒泡排序的时间的 复杂度较高 2 .加入length=1  的情况应该直接返回1
    public int findMinArrowShotsV2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        if (points.length == 1){
            return 1;
        }
        // 首先对 传入的数组进行排序 冒泡排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        // 开始shot
        int ans = 1;
        int shot = points[0][1]; // shot的区间
        for (int i = 1; i < points.length; i++) {
            if (shot >= points[i][0]) {
                shot = Math.min(shot, points[i][1]);
            } else {
                ans++;
                shot = points[i][1];
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int ans = new leetCode452().findMinArrowShots(points);
        System.out.println(ans);
    }
}
