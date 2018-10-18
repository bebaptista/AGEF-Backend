package com.tisv.agef.services.exceptions;

@SuppressWarnings("unused")
public class ConstraintViolationExceptionOnDelete extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ConstraintViolationExceptionOnDelete(String msg) {
        super(msg);
    }

    public ConstraintViolationExceptionOnDelete(String msg, Throwable cause) {
        super(msg, cause);
    }

}
