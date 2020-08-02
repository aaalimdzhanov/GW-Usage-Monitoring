package com.gwumonitor.demo.utils;

public class ResponseJSON<T, V> {
    private T message;
    private V result;

    public V getResult() {
        return result;
    }

    public void setResult(V result) {
        this.result = result;
    }

    public ResponseJSON(T message) {
        this.message = message;
    }

    public ResponseJSON(T message, V result) {
        this.message = message;
        this.result = result;
    }

    public T getMessage() {
        return message;
    }


    public void setMessage(T message) {
        this.message = message;
    }
}
