package sit.int204.practice.exceptions;

public class SurveyException extends RuntimeException {
    ExceptionResponse.ERROR_CODE errorCode;
    public SurveyException(ExceptionResponse.ERROR_CODE errorCode, String s) {
        super(s);
        this.errorCode = errorCode;
    }

    public ExceptionResponse.ERROR_CODE getErrorCode() {
        return this.errorCode;
    }
}
