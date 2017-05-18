package com.example.sww.testdemo.mode;

/**
 * Created by shiweiwei on 2017/5/17.
 */

public class ResultBean {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    private String message;
    private boolean isSuccess;

}
