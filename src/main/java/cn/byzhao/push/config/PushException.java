package cn.byzhao.push.config;

import cn.byzhao.push.entity.FailEnum;
import lombok.Data;

@Data
public class PushException extends RuntimeException{

    private static final long serialVersionUID = -7480022450501760611L;

    /**
     * 异常码
     */
    private Integer code;
    /**
     * 异常提示信息
     */
    private String message;

    public PushException(FailEnum failEnum) {
        this.code = failEnum.getCode();
        this.message = failEnum.getMsg();
    }


}
