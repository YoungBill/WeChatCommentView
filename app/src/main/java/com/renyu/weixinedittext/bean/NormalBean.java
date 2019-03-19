package com.renyu.weixinedittext.bean;

/**
 * Created by Administrator on 2018/4/20.
 */

public class NormalBean extends AbstractBean{

    private String msg;

    public NormalBean(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
