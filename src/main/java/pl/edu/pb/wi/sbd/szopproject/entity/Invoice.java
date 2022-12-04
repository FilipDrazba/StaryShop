package pl.edu.pb.wi.sbd.szopproject.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice extends Receipt {

    @Column(name = "buyer_data",
            nullable = false)
    private String buyerData;

    public Invoice() {

    }

}
