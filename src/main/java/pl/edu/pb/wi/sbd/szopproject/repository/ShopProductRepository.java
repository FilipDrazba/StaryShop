package pl.edu.pb.wi.sbd.szopproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.szopproject.entity.ShopProduct;
import pl.edu.pb.wi.sbd.szopproject.entity.compositeId.ShopProductCompositeId;

@Repository
public interface ShopProductRepository extends JpaRepository<ShopProduct, ShopProductCompositeId> {

}
