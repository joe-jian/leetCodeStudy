package util.Exception;

public class Test {

    public static void main(String[] args) {
        try {
            // 模拟抛出一个异常
            throw new IllegalArgumentException("非法参数");
        } catch (Exception e) {
            int errorCode = ExceptionUtils.getErrorCodeValue(e);
            String errorMessage = ExceptionUtils.getErrorMessage(e);
            System.out.println("Error Code: " + errorCode);
            System.out.println("Error Message: " + errorMessage);
        }
    }
}
