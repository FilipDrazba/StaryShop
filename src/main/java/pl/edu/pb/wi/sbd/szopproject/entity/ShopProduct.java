package pl.edu.pb.wi.sbd.szopproject.entity;

import jakarta.persistence.*;
import pl.edu.pb.wi.sbd.szopproject.entity.compositeId.ShopProductCompositeId;

import java.io.Serializable;

@Entity
@Table(name = "shops_products")
public class ShopProduct implements Serializable {

    @EmbeddedId
    ShopProductCompositeId shopProductCompositeId;

    @Column(name = "quantity",
            nullable = false)
    private Integer quantity;

    public ShopProduct(Shop shop,
                       Product product,
                       Integer quantity) {
        this.shopProductCompositeId = new ShopProductCompositeId(shop, product);
        this.quantity = quantity;
    }

    public void decrementQuantity(){
        quantity--;
    }

    public void addQuantity(Integer adder) {
        quantity += adder;
    }

    public void updateQuantity(Integer newQuantity){
        this.quantity=newQuantity;
    }

}
