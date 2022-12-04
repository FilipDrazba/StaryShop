package pl.edu.pb.wi.sbd.szopproject.entity;

import jakarta.persistence.*;
import pl.edu.pb.wi.sbd.szopproject.shared.OrderState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders",
        indexes = {@Index(name = "indeksik",
                columnList = "customer_id")})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date",
            nullable = false)
    private LocalDate date;

    @Column(name = "state",
            nullable = false)
    private OrderState orderState;

    @Column(name = "issuedInvoice",
            nullable = false)
    private Boolean issuedInvoice;

    @JoinColumn(nullable = false)
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Shop shop;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

    public Order(Boolean issuedInvoice,
                 Set<Product> products,
                 Shop shop,
                 Customer customer){
        this.date=LocalDate.now();
        this.orderState=OrderState.PLACED;
        this.issuedInvoice=issuedInvoice;
        this.products=products;
        this.shop=shop;
        this.customer=customer;
    }

    public Order(Boolean issuedInvoice,
                 Product product,
                 Shop shop,
                 Customer customer){
        this.date=LocalDate.now();
        this.orderState=OrderState.PLACED;
        this.issuedInvoice=issuedInvoice;
        this.products=new HashSet<>();products.add(product);
        this.shop=shop;
        this.customer=customer;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

}
