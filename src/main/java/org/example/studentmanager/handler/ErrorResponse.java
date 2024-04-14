package org.example.studentmanager.handler;

public class ErrorResponse{
    private  int status;
    private String message;
    private Long timeStemp;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timeStemp = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStemp() {
        return timeStemp;
    }

    public void setTimeStemp(Long timeStemp) {
        this.timeStemp = timeStemp;
    }
}
