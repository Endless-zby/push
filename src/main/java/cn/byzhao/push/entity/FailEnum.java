package cn.byzhao.push.entity;


public enum FailEnum {

    PARMETER_EXCEPTION(102, "参数异常!"),
    SERVICE_TIME_OUT(103, "服务调用超时！"),
    UNEXPECTED_EXCEPTION(500, "系统发生异常，请联系管理员！");


    private Integer code;

    private String msg;

    private FailEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
