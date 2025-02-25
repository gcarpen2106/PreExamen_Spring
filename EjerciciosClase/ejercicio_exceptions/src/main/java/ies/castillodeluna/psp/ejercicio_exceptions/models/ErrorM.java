package ies.castillodeluna.psp.ejercicio_exceptions.models;

import java.sql.Date;

public class ErrorM {
 
    private String message;
    private String code;
    private int status;
    private Date date;

    public ErrorM() {
    }

    public ErrorM(String message, String code, int status, Date date) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    
}
