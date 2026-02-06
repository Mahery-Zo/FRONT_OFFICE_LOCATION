package com.frontoffice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable {

    @JsonProperty("status")
    private String status;

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("data")
    private List<ReservationApi> data;

    @JsonProperty("count")
    private Integer count;

    public ApiResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<ReservationApi> getData() {
        return data;
    }

    public void setData(List<ReservationApi> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
