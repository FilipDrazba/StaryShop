package pl.edu.pb.wi.sbd.szopproject.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "SHOPS_PRODUCTS")
public class ShopsProducts implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "SHOP_ID", referencedColumnName = "ID")
    private Shop shop;

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    public ShopsProducts() {

    }

}
