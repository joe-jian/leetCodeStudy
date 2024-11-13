package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        List<String> monthList = new ArrayList<>(Arrays.asList(
                "2024-01", "2024-02", "2024-03", "2024-04",
                "2024-05", "2024-06", "2024-07", "2024-08",
                "2024-09", "2024-10", "2024-11", "2024-12"
        ));
        List<String> collect = monthList.stream().map(month -> month.replace("-", "")).collect(Collectors.toList());

        System.out.println(collect);
    }

}
