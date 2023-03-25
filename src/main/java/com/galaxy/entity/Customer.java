package com.galaxy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String  phone;
    private String gender;
    private String password;
    private Integer age;
    private boolean isStatus;
    @ManyToOne(targetEntity = Bmi.class)
    @JoinColumn(name = "bmi_id", referencedColumnName = "id")
    private Bmi bmi;

    @OneToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;


}
