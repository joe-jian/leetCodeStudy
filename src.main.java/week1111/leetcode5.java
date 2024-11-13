package week1111;


import lombok.Data;

@Data
class palindrome {
    String s;
    int start,end,len;
}
// leetcode5 最长回文子串 查找子串 中的最长的回问子串 最优解
public class leetcode5 {
    //使用的是中心扩展的方式 找到中心位置向两边进行扩展实现代

    public String longestPalindrome(String s) {
        if (s.length()<2){
            return s;
        }
        int start = 0;
        for (int i = 0; i < s.length();i++){
            //这里获取了最大长度
            int max = Math.max(expandAroundCenterV2(s, i, i + 1), expandAroundCenterV2(s, i, i));
            if (max>s.length()-1){
                return s.substring(i-max/2,i+max/2+1);
            }

        }
        return  "11";
    }
    private int expandAroundCenterV2(String s, int left, int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left+1;
    }

//    private palindrome expandAroundCenter(String s, int left, int right) {
//
//            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
//                left--;
//                right++;
//            }
//            palindrome palindrome = new palindrome();
//            palindrome.setStart(left);
//            palindrome.setEnd(right);
//            palindrome.setS(s.substring(left+1,right));
//            palindrome.setLen(right-left+1);
//
//        return palindrome;
//
//    }

    boolean isPalindrome(String s){
        String s1 = new StringBuilder(s).reverse().toString();
        return s.equals(s1);
    }

    public static void main(String[] args)
    {
        String s = "babad";
        String result = new leetcode5().longestPalindrome(s);
        System.out.println(result);
    }
}
