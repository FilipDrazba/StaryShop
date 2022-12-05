package pl.edu.pb.wi.sbd.szopproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.szopproject.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
