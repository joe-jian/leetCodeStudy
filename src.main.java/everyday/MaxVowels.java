package everyday;

public class MaxVowels {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        Integer maxValue=0;
//        if (k > chars.length){
//            for (int i = 0; i < chars.length; i++) {
//                if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'){
//                    maxValue++;
//                }
//            }
//        }else {
//            for (int i = 0; i < chars.length; i++) {
//                if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'){
//                    maxValue++;
//                }
//                if (i < k-1){
//
//                }
//
//            }
//
//        }
        int left=0;
        int right=0;
        for (int i = 0; i < chars.length; i++) {
            if (i==0 && right<k-1){
                for (int j = 0; j <= k-1; j++) {
                    if (chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'u'){
                        maxValue++;
                    }
                }
            }else {


            }
        }

        return 0;
    }
    /*
    * 滑块
    * */

    class Solution {
        public int maxVowels(String S, int k) {
            char[] s = S.toCharArray();
            int ans = 0;
            int vowel = 0;
            for (int i = 0; i < s.length; i++) {
                // 1. 进入窗口
                if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                    vowel++;
                }
                if (i < k - 1) { // 窗口大小不足 k
                    continue;
                }
                // 2. 更新答案
                ans = Math.max(ans, vowel);
                // 3. 离开窗口
                char out = s[i - k + 1];
                if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                    vowel--;
                }
            }
            return ans;
        }
    }


}
