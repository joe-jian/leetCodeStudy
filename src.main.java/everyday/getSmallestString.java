package everyday;

import java.util.ArrayList;
import java.util.List;

/*给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的
字典序最小的字符串
。

如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。



示例 1：

输入： s = "45320"

输出： "43520"

解释：

s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。

示例 2：

输入： s = "001"

输出： "001"

解释：

无需进行交换，因为 s 已经是字典序最小的。



提示：

2 <= s.length <= 100
s 仅由数字组成。
*
*
* */

public class getSmallestString {
    public static String getSmallestString(String s) {
        if (s==null || s.length()<2 || s.length()>100){
            throw new IllegalArgumentException("Invalid input");
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> booleans =new ArrayList<>();
        int switchIndex = s.length()-1;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int number = Character.getNumericValue(c);
            if (i==0){
                booleans.add(isValid(number));
            }else {
                Integer valid = isValid(number);
                booleans.add(valid);
                if ((valid+booleans.get(i-1))%2==0){
                    switchIndex=i-1;
                    break;
                }
            }
        }
        if (switchIndex==s.length()-1){
            return s;
        }else {
          sb.append(s, 0, switchIndex-1).append(s.charAt(switchIndex)).append(s.charAt(switchIndex-1)).append(s.substring(switchIndex+1,s.length()-1));
        }
        return sb.toString();
    }

    public static String getSmallestString2(String s) {
        if (s==null || s.length()<2 || s.length()>100){
            throw new IllegalArgumentException("Invalid input");
        }
        StringBuilder sb = new StringBuilder();
        int switchIndex = 1000;
        int previousValidity=-1;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int number = Character.getNumericValue(c);
            Integer currentValidity = isValid(number);
            if (i==0){
                previousValidity=currentValidity;
            }else {
                if ((currentValidity+previousValidity)%2==0){
                    switchIndex=i;
                    break;
                }
                previousValidity=currentValidity;
            }
        }
        if (switchIndex>s.length()-1){
            return s;
        }else {
            sb.append(s, 0, switchIndex-1).append(s.charAt(switchIndex)).append(s.charAt(switchIndex-1)).append(s.substring(switchIndex+1,s.length()));
        }
        return sb.toString();
    }
    public static Integer isValid(int s){
        return s%2;
    }
    public static String getSmallestString3(String s) {

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.charAt(i) > s.charAt(i + 1) && s.charAt(i) % 2 == s.charAt(i+1) % 2) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(i+1));
                sb.setCharAt(i+1, temp);
                break;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String smallestString = getSmallestString3("123456897");
        System.out.println(smallestString);
    }
}
