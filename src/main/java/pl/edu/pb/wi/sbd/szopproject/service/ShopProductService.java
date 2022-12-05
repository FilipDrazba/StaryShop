package pl.edu.pb.wi.sbd.szopproject.service;

import org.springframework.stereotype.Service;
import pl.edu.pb.wi.sbd.szopproject.entity.compositeId.ShopProductCompositeId;
import pl.edu.pb.wi.sbd.szopproject.repository.ShopProductRepository;
import pl.edu.pb.wi.sbd.szopproject.entity.ShopProduct;
import pl.edu.pb.wi.sbd.szopproject.entity.Shop;
import pl.edu.pb.wi.sbd.szopproject.entity.Product;

import javax.management.BadAttributeValueExpException;
import javax.management.InvalidAttributeValueException;

@Service
public class ShopProductService {

    private final ShopProductRepository shopProductRepository;
    private final ShopService shopService;
    private final ProductService productService;

    public ShopProductService(ShopProductRepository shopProductRepository,
                              ShopService shopService,
                              ProductService productService) {
        this.shopProductRepository = shopProductRepository;
        this.shopService = shopService;
        this.productService = productService;
    }

    private ShopProduct findById(Shop shop,
                                 Product product) {
        ShopProductCompositeId id = new ShopProductCompositeId(shop, product);

        return shopProductRepository.findById(id).orElseThrow();
    }

    public ShopProduct findById(Long shopId,
                                Long productId) {
        Shop shop = shopService.findById(shopId);
        Product product = productService.findById(productId);

        return findById(shop, product);
    }

    public void create(Long shopId,
                       Long productId,
                       Integer quantity) {
        Shop shop = shopService.findById(shopId);
        Product product = productService.findById(productId);

        ShopProduct shopProduct = new ShopProduct(shop, product, quantity);

        shopProductRepository.save(shopProduct);
    }

    public void addQuantity(Long shopId,
                            Long productId,
                            Integer adder) {
        ShopProduct shopProduct = findById(shopId, productId);

        shopProduct.addQuantity(adder);

        shopProductRepository.save(shopProduct);
    }

    public void updateQuantity(Long shopId,
                               Long productId,
                               Integer newQuantity) throws InvalidAttributeValueException {
        ShopProduct shopProduct = findById(shopId, productId);

        if (newQuantity > 0)
            shopProduct.updateQuantity(newQuantity);
        else if (newQuantity == 0)
            shopProductRepository.delete(shopProduct);
        else {
            throw new InvalidAttributeValueException(
                    "New quantity (%d) can not be a negative number.".formatted(newQuantity));
        }
    }

    private void delete(ShopProduct shopProduct) {
        shopProductRepository.delete(shopProduct);
    }

    public void delete(Long shopId,
                       Long productId) {
        ShopProduct shopProduct = findById(shopId, productId);

        delete(shopProduct);
    }

}
