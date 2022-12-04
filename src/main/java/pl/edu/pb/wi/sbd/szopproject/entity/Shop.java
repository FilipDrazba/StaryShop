package pl.edu.pb.wi.sbd.szopproject.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",
            nullable = false)
    private String name;

    @OneToOne(mappedBy = "shop",
            cascade = CascadeType.ALL)
    private ShopAddress address;

    @OneToMany(mappedBy = "shop",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Order> orders;

    public Shop() {

    }

    public Shop(String name) {
        this.name = name;
    }

}
