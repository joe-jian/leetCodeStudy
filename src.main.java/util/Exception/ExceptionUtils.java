package util.Exception;


public class ExceptionUtils {

    public static ErrorCode getErrorCode(Exception e) {
        if (e instanceof IllegalArgumentException) {
            return ErrorCode.BAD_REQUEST;
        } else if (e instanceof SecurityException) {
            return ErrorCode.UNAUTHORIZED;
        } else if (e instanceof NullPointerException) {
            return ErrorCode.INTERNAL_SERVER_ERROR;
        } else {
            return ErrorCode.UNKNOWN_ERROR;
        }
    }

    public static String getErrorMessage(Exception e) {
        ErrorCode errorCode = getErrorCode(e);
        return errorCode.getMessage();
    }

    public static int getErrorCodeValue(Exception e) {
        ErrorCode errorCode = getErrorCode(e);
        return errorCode.getCode();
    }
}