package pl.edu.pb.wi.sbd.szopproject.entity;

import pl.edu.pb.wi.sbd.szopproject.entity.abstracts.AbstractContactDetails;
import jakarta.persistence.*;

@Entity
@Table(name = "shop_contact_details")
public class ShopContactDetails extends AbstractContactDetails {

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Shop shop;

    public ShopContactDetails() {

    }

}
