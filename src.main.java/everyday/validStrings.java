
package everyday;

import java.util.ArrayList;
import java.util.List;

public class validStrings {

    public static List<String> validStrings(int n){
        //获取所有的2进制
        List<String> binaryStrings = new ArrayList<>();
        for (int i = 0; i < (1<< n); i++) {
            StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
            while (s.length() < n){
                s.insert(0, "0");
            }
            if (!s.toString().contains("00")){
                binaryStrings.add(s.toString());
            }
        }
        return binaryStrings;
    }

    //获取所有位数的二进制
    public static void main(String[] args) {
        List<String> strings = validStrings(1);

        System.out.println(strings);

    }
}

