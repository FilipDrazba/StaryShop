package pl.edu.pb.wi.sbd.szopproject.entity;


import jakarta.persistence.*;
import pl.edu.pb.wi.sbd.szopproject.shared.Size;

import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",
            nullable = false)
    private String name;

    @Column(name = "price",
            nullable = false)
    private Double price;

    @Enumerated
    @Column(name = "size",
            nullable = false)
    private Size size;

    @ManyToMany(mappedBy = "products")
    private Set<ShoppingCart> shoppingCarts;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;

    public Product() {

    }

    public void update(Product other){
        this.name=other.name;
        this.price=other.price;
        this.size=other.size;
    }

}
