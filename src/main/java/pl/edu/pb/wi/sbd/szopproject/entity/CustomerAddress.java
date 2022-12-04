package pl.edu.pb.wi.sbd.szopproject.entity;

import pl.edu.pb.wi.sbd.szopproject.entity.abstracts.AbstractAddress;
import jakarta.persistence.*;

@Entity
@Table(name = "customer_addresses")
public class CustomerAddress extends AbstractAddress {

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Customer customer;

    public CustomerAddress() {

    }

}
