package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Адресс не должен быть пустым")
    @Length(min = 2, max = 100, message = "Адресс должен быть от 2 до 100 символов")
    private String address;

    @NotEmpty(message = "Оплата не должна быть пустой")
    @Length(min = 2, max = 100, message = "Оплата должно быть от 2 до 100 символов")
    private String price;

    @NotEmpty(message = "Комментарий курьера не должен быть пустым")
    @Length(min = 2, max = 100, message = "Комментарий курьера должен быть от 2 до 100 символов")
    private String comment;

    private int deliveryDate;

    @NotEmpty(message = "Телефон не должен быть пустым")
    @Length(min = 2, max = 100, message = "Телефон должен быть от 2 до 100 символов")
    private String phone;

    private Date timeStart;

    private Date timeEnd;

    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Person client;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Person manager;

    @ManyToOne
    @JoinColumn(name = "deliveryman_id", referencedColumnName = "id")
    private Person deliveryman;

    public Order() {
    }

    public Order( int deliveryDate, String price, String address, String phone, String courierComment, String status) {
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.address = address;
        this.phone = phone;
        this.comment = courierComment;
        this.status = status;
    }

    public Order(int id,
            @NotEmpty(message = "Адресс не должен быть пустым") @Length(min = 2, max = 100, message = "Адресс должен быть от 2 до 100 символов") String address,
            @NotEmpty(message = "Оплата не должна быть пустой") @Length(min = 2, max = 100, message = "Оплата должно быть от 2 до 100 символов") String price,
            @NotEmpty(message = "Комментарий курьера не должен быть пустым") @Length(min = 2, max = 100, message = "Комментарий курьера должен быть от 2 до 100 символов") String comment,
            int deliveryDate,
            @NotEmpty(message = "Телефон не должен быть пустым") @Length(min = 2, max = 100, message = "Телефон должен быть от 2 до 100 символов") String phone,
            Date timeStart, Date timeEnd, String status, Person client, Person manager, Person deliveryman) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.comment = comment;
        this.deliveryDate = deliveryDate;
        this.phone = phone;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.status = status;
        this.client = client;
        this.manager = manager;
        this.deliveryman = deliveryman;
    }

    public Order(
            @NotEmpty(message = "Адресс не должен быть пустым") @Length(min = 2, max = 100, message = "Адресс должен быть от 2 до 100 символов") String address,
            @NotEmpty(message = "Оплата не должна быть пустой") @Length(min = 2, max = 100, message = "Оплата должно быть от 2 до 100 символов") String price,
            @NotEmpty(message = "Комментарий курьера не должен быть пустым") @Length(min = 2, max = 100, message = "Комментарий курьера должен быть от 2 до 100 символов") String comment,
            int deliveryDate,
            @NotEmpty(message = "Телефон не должен быть пустым") @Length(min = 2, max = 100, message = "Телефон должен быть от 2 до 100 символов") String phone,
            Date timeStart, Date timeEnd, String status, Person client, Person manager, Person deliveryman) {
        this.address = address;
        this.price = price;
        this.comment = comment;
        this.deliveryDate = deliveryDate;
        this.phone = phone;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.status = status;
        this.client = client;
        this.manager = manager;
        this.deliveryman = deliveryman;
    }

    

    

    

    
}
