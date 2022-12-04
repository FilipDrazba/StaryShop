package pl.edu.pb.wi.sbd.szopproject.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

    @Id
    @Column(name = "id")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Product> products;

    public ShoppingCart() {

    }

    public Set<Product> getProducts() {
        return products;
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

}
