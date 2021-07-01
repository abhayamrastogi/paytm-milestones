package com.example.milestone1.entity;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "paytm_user")
public class PaytmUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long ID;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @NonNull
    @Column(name = "user_name")
    private String user_name;

    @NonNull
    @Column(name = "mobile_number")
    private String mobile_number;

    @NonNull
    @Column(name = "email_id")
    private String email_id;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @OneToMany(mappedBy = "paytmUser", cascade = CascadeType.ALL)
    private List<Payment> paymentList;

    public PaytmUser() {
    }

    @Override
    public String toString() {
        return first_name + ", " + last_name + "!";
    }

    public Long getID() {
        return ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

}
