package edu.miu.courseregistrationsystem.exception;

public class ApplicationException extends Exception {
    public ApplicationException() {
        super();
    }


    public ApplicationException(String errorMsg) {
        super(errorMsg);
    }
}
