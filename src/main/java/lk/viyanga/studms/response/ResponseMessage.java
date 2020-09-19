package lk.viyanga.studms.response;


/**
 * @author - Kavindi Viyanga on 2020-07-19
 * @project - stud-ms
 **/
public enum ResponseMessage {

    SUCCESSFULLY_SENT("Successfully sent.");
    private String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
