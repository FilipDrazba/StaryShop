package pl.edu.pb.wi.sbd.szopproject.entity;

import pl.edu.pb.wi.sbd.szopproject.entity.abstracts.AbstractAddress;
import jakarta.persistence.*;

@Entity
@Table(name = "shop_addresses")
public class ShopAddress extends AbstractAddress {

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    Shop shop;

    public ShopAddress() {

    }

}
