package co.com.arbelaez.model.Exception;

public class ErrorException extends Exception{
    public static final String GENERAL = "GEN";
    private String message;
    private int code;

    public ErrorException(String message, int code){
        super();
        this.message = message;
        this.code = code;
    }

    public String getMessage(){ return message;}

    public int getCode() {
        return code;
    }
}
