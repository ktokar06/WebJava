package com.example.demo.dto;

import com.example.demo.models.Person;

import lombok.Data;
import java.util.Date;

@Data
public class OrderRequestDTO {

    // private int id;
    // private int deliveryDate;
    // private String price;
    // private String address;
    // private String phone;
    // private String client;
    // private String manager;
    // private String comment;
    // private String deliveryman;

    public int id;
    public String address;
    public String price;
    public String comment;
    public int deliveryDate;
    public String phone;
    public Date timeStart;
    public Date timeEnd;
    public int client;
    public int manager;
    public int deliveryman;
    public String status;
   

}
