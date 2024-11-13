package week1111;

// 题目解析 ，判断输入的数字是不是回文数
public class leetcode9 {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }else {
            String str = String.valueOf(x);
            return str.equals(new StringBuilder(str).reverse().toString());
        }

    }

}
