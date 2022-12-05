package pl.edu.pb.wi.sbd.szopproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.szopproject.entity.Customer;
import pl.edu.pb.wi.sbd.szopproject.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findByCustomer(Customer customer);

}
