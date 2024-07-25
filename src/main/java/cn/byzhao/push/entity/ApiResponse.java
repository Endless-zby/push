package cn.byzhao.push.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -8160886787235984955L;

    public static final int OK = 0;
    public static final int ERROR = -1;

    private int code;
    /**
     * 返回码提示语
     */
    private String errMessage;

    private T data;

    public static <T> ApiResponse<T> isSuccess(){
        return new ApiResponse<>(OK, "success", null);
    }

    public static <T> ApiResponse<T> isSuccess(T data){
        return new ApiResponse<>(OK, "success", data);
    }
    public static <T> ApiResponse<T> isSuccess(int code, String errMessage, T data){
        return new ApiResponse<>(code, errMessage, data);
    }

    public static <T> ApiResponse<T> isFail(String errMessage){
        return new ApiResponse<>(ERROR, errMessage, null);
    }
    public static <T> ApiResponse<T> isFail(int code, String errMessage){
        return new ApiResponse<>(code, errMessage, null);
    }

}
