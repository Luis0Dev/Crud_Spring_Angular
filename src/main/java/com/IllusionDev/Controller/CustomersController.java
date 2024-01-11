package com.IllusionDev.Controller;

import com.IllusionDev.Entity.Customers;
import com.IllusionDev.Service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")

public class CustomersController {

    private final CustomersService customersService;

    @PostMapping("/customers")
    public Customers postCustomer(@RequestBody Customers customers){
        return customersService.postCustomers(customers);
    }

    @GetMapping("/custom")
    private List<Customers> getAllCustomers(){
        return customersService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customers> getCustomersById(@PathVariable Long id){
        Customers customers = customersService.getCustomersById(id);
        if(customers == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(customers);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customers> updateCustomers(@PathVariable Long id, @RequestBody Customers customers){
        Customers exixtingsCustomers = customersService.getCustomersById(id);
        if(exixtingsCustomers == null){
            return ResponseEntity.notFound().build();
        }
        exixtingsCustomers.setName(customers.getName());
        exixtingsCustomers.setEmail(customers.getEmail());
        exixtingsCustomers.setPhone(customers.getPhone());
        Customers updateCustomers = customersService.updateCustomers(exixtingsCustomers);
        return ResponseEntity.ok(customers);
    }

    public ResponseEntity<Customers> deleteCostumers(@PathVariable Long id){
        Customers exixtingsCustomers = customersService.getCustomersById(id);
        if(exixtingsCustomers == null){
            return ResponseEntity.notFound().build();
        }
        customersService.deleteCustomers(id);
        return ResponseEntity.ok().build();
    }
}
