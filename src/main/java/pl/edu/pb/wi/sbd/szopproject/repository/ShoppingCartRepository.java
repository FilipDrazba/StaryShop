package pl.edu.pb.wi.sbd.szopproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.szopproject.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

}
