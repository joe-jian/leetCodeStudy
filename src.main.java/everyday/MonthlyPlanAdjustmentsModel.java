package everyday;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MonthlyPlanAdjustmentsModel {
    private LocalDate suggestStart;

    public MonthlyPlanAdjustmentsModel(LocalDate suggestStart) {
        this.suggestStart = suggestStart;
    }

    public LocalDate getSuggestStart() {
        return suggestStart;
    }

    @Override
    public String toString() {
        return "MonthlyPlanAdjustmentsModel{" +
                "suggestStart=" + suggestStart +
                '}';
    }

    public static void main(String[] args) {
        List<MonthlyPlanAdjustmentsModel> adjustmentsList = new ArrayList<>();
        adjustmentsList.add(new MonthlyPlanAdjustmentsModel(LocalDate.of(2023, 10, 15)));
        adjustmentsList.add(new MonthlyPlanAdjustmentsModel(LocalDate.of(2023, 9, 10)));
        adjustmentsList.add(new MonthlyPlanAdjustmentsModel(LocalDate.of(2023, 11, 20)));

        // 排序前
        System.out.println("排序前:");
        adjustmentsList.forEach(System.out::println);

        // 排序
        adjustmentsList.sort(Comparator.comparing(MonthlyPlanAdjustmentsModel::getSuggestStart));

        // 排序后
        System.out.println("排序后:");
        adjustmentsList.forEach(System.out::println);
    }
}