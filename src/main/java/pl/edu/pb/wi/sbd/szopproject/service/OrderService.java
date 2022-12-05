package pl.edu.pb.wi.sbd.szopproject.service;

import org.springframework.stereotype.Service;
import pl.edu.pb.wi.sbd.szopproject.entity.*;
import pl.edu.pb.wi.sbd.szopproject.repository.OrderRepository;
import pl.edu.pb.wi.sbd.szopproject.shared.OrderState;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final ShopService shopService;
    private final ShopProductService shopProductService;
    private final CustomerService customerService;


    public OrderService(OrderRepository orderRepository,
                        ProductService productService,
                        ShopService shopService,
                        ShopProductService shopProductService,
                        CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.shopService = shopService;
        this.shopProductService = shopProductService;
        this.customerService = customerService;
    }

    public void create(Long productId,
                       Long shopId,
                       Long customerId,
                       Boolean issuedInvoice) {
        Product product = productService.findById(productId);
        Shop shop = shopService.findById(shopId);
        Customer customer = customerService.findById(customerId);
        ShopProduct shopProduct=shopProductService.findById(shopId,productId);

        shopProduct.decrementQuantity();
        Order order = new Order(issuedInvoice, product, shop, customer);

        orderRepository.save(order);
    }

    public Order findById(Long orderId){
        return orderRepository.findById(orderId).orElseThrow();
    }

    public List<Order> findOrdersByCustomerId(Long customerId){
        Customer customer=customerService.findById(customerId);

        return orderRepository.findByCustomer(customer);
    }

    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    public void updateOrderState(Long orderId,
                                 OrderState orderState){
        Order order = findById(orderId);

        order.setOrderState(orderState);

        orderRepository.save(order);
    }

}
