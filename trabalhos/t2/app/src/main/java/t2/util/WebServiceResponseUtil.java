package t2.util;

public class WebServiceResponseUtil {
    private boolean success;
    private String message;

    public WebServiceResponseUtil(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return StringUtil.toJSON(this);
    }
}
