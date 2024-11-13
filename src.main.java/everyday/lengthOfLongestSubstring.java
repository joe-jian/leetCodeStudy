package everyday;

import java.util.*;

public class lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 输出: 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 输出: 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 输出: 3
    }
}

