package com.example.milestone1.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long ID;

    @Column(name = "order_id")
    private String orderID;

    @Column(name = "price")
    private String price;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PaytmUser paytmUser;

    @OneToMany(mappedBy = "payment", fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    public Long getID() {
        return ID;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getPrice() {
        return price;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
