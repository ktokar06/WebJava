package com.example.demo.dto;

import lombok.Data;

@Data
public class CreateOrderDTO {

    private String price;
    private String address;
    private String phone;
    private Integer client;
    private Integer manager;
    private Integer deliveryman;
    private String comment;
    private String status;

}
