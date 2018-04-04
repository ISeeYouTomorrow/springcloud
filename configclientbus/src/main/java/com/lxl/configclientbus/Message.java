package com.lxl.configclientbus;

/**
 * @author lxl lukas
 * @description
 * @create 2018/1/26
 */
public class Message {

    private Integer id ;

    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "id :"+id+" ;msg: "+message;
    }
}
