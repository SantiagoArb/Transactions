package co.com.arbelaez.api.utils;

import java.util.Map;

public class SuccessResponse {

    public static ResponseStructure success(String message){
        return ResponseStructure.builder().status("Successs").message(message).build();
    }

    public static ResponseStructure success(String key, Object data){return success(key, data, null);}

    public static ResponseStructure success(String key, Object data, String message){
        ResponseStructure responseStructure = ResponseStructure.builder().status("Success").message(message).build();
        responseStructure.addData(key,data);
        return responseStructure;
    }

    public static ResponseStructure success(Map<String, Object> data, String message){
        return ResponseStructure.builder().status("Success").data(data).message(message).build();
    }

    public static ResponseStructure error(String message, int code){
        return ResponseStructure.builder().status("Failed").message(message).errorCode(code).build();
    }
}
