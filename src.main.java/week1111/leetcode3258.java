package week1111;

// 题目解析 ： 满足k约束的子字符串数量1

import java.util.ArrayList;
import java.util.List;

public class leetcode3258 {
    //最简单的做法就是暴力算法 找到所有的子串统计符合条件的子字符串数量
    public int countKConstraintSubstrings1(String s, int k) {
        int count=0;
        List<String> list = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<=s.length();j++){
                String substring = s.substring(i, j);
                if (substring.length() == 0){
                    continue;
                }
                int zero=(int) substring.chars().filter(c -> c == '0').count();
                int one=(int) substring.chars().filter(c -> c == '1').count();
                if (zero<=k||one<=k){
                    count++;
                    list.add(substring);
                }
                }
            }
        System.out.println(list);
        return count;
        }
        // 简单优化
    public int countKConstraintSubstrings2(String s, int k) {
        int count=0;
        for (int i=0;i<s.length();i++){
            int zero=0;
            int one=0;
            for (int j=i;j<s.length();j++){
                if (s.charAt(j)=='0'){
                    zero++;
                }else if (s.charAt(j)=='1'){
                    one++;
                }
                if (zero<=k||one<=k){
                    count++;
                }else break;
            }
        }
        return count;
    }
    public int countSubstrings(String s, int k) {
        if (s == null) {
            return 0; // 处理 s 为 null 的情况
        }

        int n = s.length();
        int count = 0;

        // 记录当前窗口内的 '0' 和 '1' 的数量
        int zeroCount = 0;
        int oneCount = 0;

        // 左指针
        int left = 0;

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            if (currentChar == '0') {
                zeroCount++;
            } else if (currentChar == '1') {
                oneCount++;
            }

            // 当窗口内的 '0' 和 '1' 数量都超过 k 时，移动左指针缩小窗口
            while (zeroCount > k && oneCount > k) {
                char leftChar = s.charAt(left);
                if (leftChar == '0') {
                    zeroCount--;
                } else if (leftChar == '1') {
                    oneCount--;
                }
                left++;
            }

            // 当前窗口 [left, right] 是有效的，计算有效子串的数量
            count += right - left + 1;
        }

        return count;
    }

    public int countKConstraintSubstrings(String s, int k) {
        //题目要求 ：子字符串 必须满足k约束，
        // 及 字符串中的0的数量不多于K 或者 1的数量不多于K
        //  子字符串的话可以采用滑块的思想
        int left=0;
        int right=0;
        int zero=0;
        int one=0;
        int count=0;
        while(right<s.length()){
            // 移动右指针
            if (zero<=k||one<=k){
                count++;
                if (s.charAt(right)=='0'){
                    zero++;
                }else if (s.charAt(right)=='1'){
                    one++;
                }
                right++;
            }else {
                left++;
                if (s.charAt(left)=='0'){
                    zero--;
                }else if (s.charAt(right)=='1'){
                    one--;
                }
                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        leetcode3258 leetcode3258 = new leetcode3258();
        String s = "10101"; int k = 1;
//        System.out.println(s.charAt(4));
        int i = leetcode3258.countSubstrings(s, k);
        System.out.println(i);
    }
}
