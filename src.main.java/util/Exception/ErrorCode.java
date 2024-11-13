package util.Exception;


public enum ErrorCode {
    UNKNOWN_ERROR(1000, "未知错误"),
    BAD_REQUEST(1001, "请求错误"),
    UNAUTHORIZED(1002, "未授权"),
    FORBIDDEN(1003, "禁止访问"),
    NOT_FOUND(1004, "资源未找到"),
    INTERNAL_SERVER_ERROR(1005, "内部服务器错误");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}