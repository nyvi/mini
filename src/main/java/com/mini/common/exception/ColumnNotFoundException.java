package com.mini.common.exception;

/**
 * can not found column exception
 * @author czk
 * @date 2017-12-01
 */
public class ColumnNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ColumnNotFoundException(String msg){
        super(msg);
    }
}
