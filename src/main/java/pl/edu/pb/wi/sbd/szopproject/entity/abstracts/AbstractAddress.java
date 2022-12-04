package pl.edu.pb.wi.sbd.szopproject.entity.abstracts;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "country",
            nullable = false)
    private String country;

    @Column(name = "city",
            nullable = false)
    private String city;

    @Column(name = "postal_code",
            nullable = false)
    private String postalCode;

    @Column(name = "street",
            nullable = false)
    private String street;

    @Column(name = "building_number",
            nullable = false)
    private Integer buildingNumber;

    @Column(name = "flat_number",
            nullable = true)
    private Integer flatNumber;

}
