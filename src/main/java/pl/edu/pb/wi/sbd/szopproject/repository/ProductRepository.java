package pl.edu.pb.wi.sbd.szopproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.szopproject.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
