package util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// map转为List<T>
public class MapToListConverter {

    /**
     * 将 List<Map<String, Object>> 转换为 List<T>，仅转换指定的属性
     *
     * @param datas 数据列表
     * @param clazz 目标类的 Class 对象
     * @param properties 需要转换的属性列表
     * @param <T>   目标类的泛型类型
     * @return 转换后的 List<T>
     * @throws Exception 如果转换过程中发生错误
     */
    public static <T> List<T> convertList(List<Map<String, Object>> datas, Class<T> clazz, List<String> properties) throws Exception {
        List<T> result = new ArrayList<>();
        for (Map<String, Object> data : datas) {
            T obj = clazz.getDeclaredConstructor().newInstance();
            for (String property : properties) {
                if (data.containsKey(property)) {
                    Object value = data.get(property);
                    setField(obj, property, value);
                }
            }
            result.add(obj);
        }
        return result;
    }

    /**
     * 使用反射设置对象的字段值
     *
     * @param obj   对象实例
     * @param fieldName 字段名
     * @param value 字段值
     * @throws Exception 如果设置字段值时发生错误
     */
    private static void setField(Object obj, String fieldName, Object value) throws Exception {
        Method method = getSetterMethod(obj.getClass(), fieldName, value);
        if (method != null) {
            try {
                method.invoke(obj, value);
            } catch (Exception e) {
                System.err.println("Failed to set field: " + fieldName + " with value: " + value);
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("No setter method found for field: " + fieldName);
        }
    }

    /**
     * 获取对象的 setter 方法
     *
     * @param clazz 类的 Class 对象
     * @param fieldName 字段名
     * @param value 字段值
     * @return 对应的 setter 方法
     * @throws NoSuchMethodException 如果找不到对应的 setter 方法
     */
    private static Method getSetterMethod(Class<?> clazz, String fieldName, Object value) throws NoSuchMethodException {
        String setterName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Class<?> paramType = valueClass(value);
        try {
            return clazz.getMethod(setterName, paramType);
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodException("No setter method found for field: " + fieldName + " with type: " + paramType.getName());
        }
    }

    /**
     * 获取值的类类型
     *
     * @param value 值
     * @return 值的类类型
     */
    private static Class<?> valueClass(Object value) {
        if (value == null) {
            return Object.class;
        }
        return value.getClass();
    }
}