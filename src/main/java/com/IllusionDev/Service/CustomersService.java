package com.IllusionDev.Service;

import com.IllusionDev.Entity.Customers;
import com.IllusionDev.Repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomersService {

    private final CustomersRepository customersRepository;

    public Customers postCustomers(Customers customers) {
        return customersRepository.save(customers);
    }

    public List<Customers> getAllCustomers(){
        return  customersRepository.findAll();
    }

    public Customers getCustomersById(Long id){
        return  customersRepository.findById(id).orElse(null);
    }

    public Customers updateCustomers(Customers customers){
        return customersRepository.save(customers);
    }

    public void deleteCustomers(Long id){
        customersRepository.deleteById(id);
    }
}
