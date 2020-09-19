package lk.viyanga.studms.exception;


import lk.viyanga.studms.response.StudMSResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author - Kavindi Viyanga on 2020-07-19
 * @project - stud-ms
 **/
@ControllerAdvice
@SuppressWarnings("ALL")
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler(StudMSException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    StudMSResponse handleBadRequest(final StudMSException exception,
                                    final HttpServletRequest request) {
        StudMSResponse bgkResponse = new StudMSResponse();
        bgkResponse.setSuccess(false);
        bgkResponse.setErrorMessage(exception.getMessage());
        bgkResponse.setRequestedURI(request.getRequestURI());
        bgkResponse.setStatusInfo(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return bgkResponse;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    StudMSResponse handleMethodArgumentException(final MethodArgumentTypeMismatchException exception,
                                              final HttpServletRequest request) {
        StudMSResponse bgkResponse = new StudMSResponse();
        bgkResponse.setSuccess(false);
        bgkResponse.setErrorMessage(exception.getMessage());
        bgkResponse.setRequestedURI(request.getRequestURI());
        bgkResponse.setStatusInfo(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return bgkResponse;
    }

}
