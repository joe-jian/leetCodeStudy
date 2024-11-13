
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Data;
import util.MapToListConverter;

public class Main {
    public static void main(String[] args) {
        // 假设这是你的数据
        List<Map<String, Object>> datas = new ArrayList<>();

        // 示例数据
        Map<String, Object> data1 = Map.of("id", "1", "name", "Report 1", "description", "Description 1");
        Map<String, Object> data2 = Map.of("id", "2", "name", "Report 2", "description", "Description 2");

        datas.add(data1);
        datas.add(data2);

        // 指定需要转换的属性
        List<String> properties = new ArrayList<>();
        properties.add("id");
        properties.add("name");

        try {
            // 转换为 List<DeliverPlanReportRef>
            List<DeliverPlanReportRef> deliverPlanReportRefs = MapToListConverter.convertList(datas, DeliverPlanReportRef.class, properties);

            // 打印结果
            for (DeliverPlanReportRef ref : deliverPlanReportRefs) {
                System.out.println(ref);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Data
class DeliverPlanReportRef {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
}