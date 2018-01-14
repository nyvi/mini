package com.mini.common.exception;

/**
 * can not found table exception
 * @author czk
 * @date 2017-12-01
 */
public class TableNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TableNotFoundException(String msg) {
        super(msg);
    }
}
