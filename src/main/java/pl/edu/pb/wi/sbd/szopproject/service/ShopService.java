package pl.edu.pb.wi.sbd.szopproject.service;

import org.springframework.stereotype.Service;
import pl.edu.pb.wi.sbd.szopproject.entity.Shop;
import pl.edu.pb.wi.sbd.szopproject.repository.ShopRepository;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop findById(Long id) {
        return shopRepository.findById(id).orElseThrow();
    }

}
