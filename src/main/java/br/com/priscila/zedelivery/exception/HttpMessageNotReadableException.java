package br.com.priscila.zedelivery.exception;

public class HttpMessageNotReadableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HttpMessageNotReadableException(String msg) {
        super(msg);
    }
}