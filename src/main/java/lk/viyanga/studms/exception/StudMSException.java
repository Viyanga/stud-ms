package lk.viyanga.studms.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author - Kavindi Viyanga on 2020-07-19
 * @project - stud-ms
 **/
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class StudMSException extends RuntimeException {

    public StudMSException() {
    }

    public StudMSException(String message) {
        super(message);
    }

    public StudMSException(Exception e) {
        super(e.getMessage());
    }

    public StudMSException(String message, Throwable cause) {
        super(message, cause);
    }
}
