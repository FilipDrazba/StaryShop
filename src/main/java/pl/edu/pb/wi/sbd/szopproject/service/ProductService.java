package pl.edu.pb.wi.sbd.szopproject.service;

import org.springframework.stereotype.Service;
import pl.edu.pb.wi.sbd.szopproject.entity.Product;
import pl.edu.pb.wi.sbd.szopproject.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(Product product) { //todo: dto?
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public void update(Long id,
                       Product otherProduct) { //todo: dto?
        Product thisProduct = findById(id);
        thisProduct.update(otherProduct);
    }

    public void delete(Long id){
        Product product=findById(id);
        productRepository.delete(product);
    }

}
