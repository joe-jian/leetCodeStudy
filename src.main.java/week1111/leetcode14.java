package week1111;

/**
*  leetcode14 最长公共前缀
 *  思路：先将第一个作为公共前缀 ，与后面的进行比较，如果相同，则继续，如果不同，则将公共前缀从后向前去除，为空就break，直到找到相同的为止。
* */
public class leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
                if (res.isEmpty()) break;
            }
        }
        return res;
    }
}
