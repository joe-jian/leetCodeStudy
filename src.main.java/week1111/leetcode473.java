package week1111;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// leetcode473. 火柴拼正方形
// 题目解析 ，这里分为求出正方形的边长，以及判断是否能拼出正方形，这里直接用递归求解即可。
public class leetcode473 {
//    public boolean makesquare(int[] matchsticks) {
//        int sum = Arrays.stream(matchsticks).sum();
//        if (sum % 4 != 0){
//            return false;
//        }
//        sum = sum / 4;
//        List<Integer> collect = Arrays.stream(matchsticks).boxed().toList();
//        int finalSum1 = sum;
//        boolean b = collect.stream().allMatch(x -> x <= finalSum1);
//        if (!b){
//            return false;
//        }
//        collect = collect.stream().sorted().collect(Collectors.toList());
//        LinkedList<Integer> list = new LinkedList<>(collect);
//        long total=4L;
//        if (list.contains(sum)){
//            int finalSum = sum;
//            long count = list.stream().filter(x -> x == finalSum).count();
//            total = total- count;
//            list.remove(sum);
//            return list.size() == 0;
//        }else {
//            int [] bullet=new int[(int) total];
//            Arrays.fill(bullet, sum);
//            for (int i = 0; i < bullet.length; i++){
//                for (int j = 0; j < list.size(); j++){
//                    if (list.get(j) <= bullet[i]){
//                        bullet[i] -= list.get(j);
//                    }
//                    }
//                }
//
//            }
//        }
//    }

//    private void dfs(Integer integer, int[][] bullet, int sum) {
//
//        for (int i = 0; i < bullet.length; i++) {
//            if (bullet[i][0]>=integer){
//                bullet[i][0]-=integer;
//                if (bullet[i][0]==0){
//                    bullet[i][0]=sum;
//                }
//                return;
//            }
//        }
//    }


    int[] ms;
    int t;

//    public boolean makesquare(int[] _ms) {
//        ms = _ms;
//        int sum = 0;
//        for (int i : ms) sum += i;
//        t = sum / 4;
//        if (t * 4 != sum) return false;
//        Arrays.sort(ms);
//        return dfs(ms.length - 1, new int[4]);
//    }

    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        sum = sum / 4;
        List<Integer> collect = Arrays.stream(matchsticks).boxed().toList();
        int finalSum = sum;
        boolean b = collect.stream().allMatch(x -> x <= finalSum);
        if (!b) {
            return false;
        }
        collect = collect.stream().sorted().collect(Collectors.toList());
        LinkedList<Integer> list = new LinkedList<>(collect);
        int total = 4;
        if (list.contains(sum)) {
            int finalSum1 = sum;
            long count = list.stream().filter(x -> x == finalSum1).count();
            total -= count;
            while (count-- > 0) {
                list.remove(Integer.valueOf(sum));
            }
            if (list.isEmpty()) {
                return true;
            }
        }
        return canFormSquare(list, sum, total, new int[4]);
    }

    private boolean canFormSquare(LinkedList<Integer> list, int sideLength, int sidesLeft, int[] sides) {
        if (sidesLeft == 0) {
            return true; // 基线条件：所有边都已拼好
        }
        for (int i = 0; i < list.size(); i++) {
            int matchstick = list.removeFirst();
            for (int j = 0; j < 4; j++) {
                if (sides[j] + matchstick <= sideLength) {
                    sides[j] += matchstick;
                    if (sides[j] == sideLength && canFormSquare(list, sideLength, sidesLeft - 1, sides)) {
                        return true; // 递归条件：当前边已拼好，继续拼下一个边
                    } else if (canFormSquare(list, sideLength, sidesLeft, sides)) {
                        return true; // 递归条件：当前边未拼好，继续尝试其他边
                    }
                    sides[j] -= matchstick; // 回溯
                }
            }
            list.addLast(matchstick); // 回溯
        }
        return false; // 所有尝试均失败
    }

    public static void main(String[] args) {
        int[] matchsticks = {1, 1, 2, 2, 2};
        leetcode473 l = new leetcode473();
        System.out.println(l.makesquare(matchsticks));
    }
}


