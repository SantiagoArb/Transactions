package co.com.arbelaez.api.utils;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder(toBuilder = true)
public class ResponseStructure {
    private String status;
    private String message;
    private int errorCode;

    private Map<String, Object> data;

    public void addData(String key, Object object){
        if(data == null){
            data = new HashMap<>();
        }
        data.put(key, object);
    }
}
