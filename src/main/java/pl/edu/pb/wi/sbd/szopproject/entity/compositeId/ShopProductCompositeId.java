package pl.edu.pb.wi.sbd.szopproject.entity.compositeId;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pl.edu.pb.wi.sbd.szopproject.entity.Product;
import pl.edu.pb.wi.sbd.szopproject.entity.Shop;

import java.io.Serializable;

@Embeddable
public class ShopProductCompositeId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "SHOP_ID", referencedColumnName = "ID")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;

    public ShopProductCompositeId() {

    }

    public ShopProductCompositeId(Shop shop, Product product) {
        this.shop = shop;
        this.product = product;
    }
}
