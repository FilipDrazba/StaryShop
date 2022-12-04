package pl.edu.pb.wi.sbd.szopproject.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "receipts")
@Inheritance(strategy = InheritanceType.JOINED)
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount",
            nullable = false)
    private Double amount;

    @Column(name = "date",
            nullable = false)
    private LocalDate date;

    @Column(name = "seller_details",
            nullable = false)
    private String sellerDetails;

    @OneToOne
    @JoinColumn(nullable = false)
    private Order order;

    public Receipt() {

    }

    public Receipt(Double amount,
                   LocalDate date,
                   String sellerDetails,
                   Order order) {
        this.amount = amount;
        this.date = date;
        this.sellerDetails = sellerDetails;
        this.order = order;
    }
}
