package pl.edu.pb.wi.sbd.szopproject.entity;

import pl.edu.pb.wi.sbd.szopproject.entity.abstracts.AbstractContactDetails;
import jakarta.persistence.*;

@Entity
@Table(name = "customer_contact_details")
public class CustomerContactDetails extends AbstractContactDetails {

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Customer customer;

    public CustomerContactDetails() {

    }

}
