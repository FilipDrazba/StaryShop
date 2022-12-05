package pl.edu.pb.wi.sbd.szopproject.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pl.edu.pb.wi.sbd.szopproject.entity.Product;
import pl.edu.pb.wi.sbd.szopproject.entity.ShoppingCart;
import pl.edu.pb.wi.sbd.szopproject.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

    public final ShoppingCartRepository shoppingCartRepository;
    public final ProductService productService;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
    }

    public ShoppingCart findById(Long id) {
        return shoppingCartRepository.findById(id).orElseThrow();
    }

    public void addProductToShoppingCart(Long shoppingCartId,
                                         Long productId) {
        ShoppingCart shoppingCart = findById(shoppingCartId);
        Product product = productService.findById(productId);

        shoppingCart.addProduct(product);

        shoppingCartRepository.save(shoppingCart);
    }

    public void removeProductFromShoppingCart(Long shoppingCartId,
                                              Long productId){
        ShoppingCart shoppingCart = findById(shoppingCartId);
        Product product = productService.findById(productId);

        shoppingCart.removeProduct(product);

        shoppingCartRepository.save(shoppingCart);
    }

}
