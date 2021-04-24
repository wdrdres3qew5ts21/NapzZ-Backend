package com.napzz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecallDto {

    public RecallDto(){
        
    }

    public RecallDto(String type, String pfp, String remark) {
        this.type = type;
        this.pfp = pfp;
        Remark = remark;
    }

    private String type;

    @JsonProperty("Pfp")
    private String pfp;

    private String Remark;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPfp() {
        return pfp;
    }

    public void setPfp(String pfp) {
        this.pfp = pfp;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    @Override
    public String toString() {
        return "RecallDto [Remark=" + Remark + ", pfp=" + pfp + ", type=" + type + "]";
    }

}
