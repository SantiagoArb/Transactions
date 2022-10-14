package co.com.arbelaez.api.utils;

import java.util.Map;

public class FailedResponse {

    public static ResponseStructure response(String message){
        return ResponseStructure.builder().status("Successs").message(message).build();
    }

    public static ResponseStructure response(String key, Object data){return response(key, data, null);}

    public static ResponseStructure response(String key, Object data, String message){
        ResponseStructure responseStructure = ResponseStructure.builder().status("Failed").message(message).build();
        responseStructure.addData(key,data);
        return responseStructure;
    }

    public static ResponseStructure response(Map<String, Object> data, String message){
        return ResponseStructure.builder().status("Failed").data(data).message(message).build();
    }
}
