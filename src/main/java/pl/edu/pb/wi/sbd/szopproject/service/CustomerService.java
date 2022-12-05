package pl.edu.pb.wi.sbd.szopproject.service;

import org.springframework.stereotype.Service;
import pl.edu.pb.wi.sbd.szopproject.repository.CustomerRepository;
import pl.edu.pb.wi.sbd.szopproject.entity.Customer;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long customerId){
        return customerRepository.findById(customerId).orElseThrow();
    }

}
