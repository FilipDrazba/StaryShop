package pl.edu.pb.wi.sbd.szopproject.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name",
            nullable = false)
    private String firstName;

    @Column(name = "last_name",
            nullable = false)
    private String lastName;

    @OneToOne(mappedBy = "customer",
            cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL)
    private Set<Order> orders;

    public Customer() {

    }

}
