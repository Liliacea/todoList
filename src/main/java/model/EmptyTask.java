package model;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"code","reason"})
public class EmptyTask {
    private String code;
    private String reason;




    public EmptyTask(String code, String reason) {

    }

    @Override
    public String toString() {
        return "code: " + code +
                "reason: " + reason;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


}
