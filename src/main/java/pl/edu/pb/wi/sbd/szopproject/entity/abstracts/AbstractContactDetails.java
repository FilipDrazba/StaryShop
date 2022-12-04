package pl.edu.pb.wi.sbd.szopproject.entity.abstracts;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractContactDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;

    @Column(name = "email",
            nullable = false)
    private String email;

    @Column(name = "phone_number",
            nullable = false)
    private String phoneNumber;

}
