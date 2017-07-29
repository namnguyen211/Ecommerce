package com.example.ecommerce.data.request;

/**
 * Created by brian on 7/29/17.
 */

public class UpdateOrderRequest {

    private Integer id;
    private String status;

    public UpdateOrderRequest(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
