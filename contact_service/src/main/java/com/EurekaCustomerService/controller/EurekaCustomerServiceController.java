package com.EurekaCustomerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.EurekaCustomerService.entity.EurekaCustomer;
import com.EurekaCustomerService.service.EurekaCustomerServiceService;

import com.nagarro.EurekaAccountServices.entity.EurekaAccount;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class EurekaCustomerServiceController {
	
	@Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaCustomerServiceService eurekaCustomerServiceService;

    @GetMapping
    public List<EurekaCustomer> getAllCustomers() {
        List<EurekaCustomer> customers = eurekaCustomerServiceService.getAllCustomers();
//        for (EurekaCustomer customer : customers) {
//            Long userId = customer.getId();
//            List<EurekaCustomer> contacts = restTemplate.getForObject("http://contact-service/contact/user/" + userId, List.class);
//            customer.setEurekaCustomers(contacts); // Store contacts in a separate field
//        }
        return customers;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<EurekaCustomer> getCustomerById(@PathVariable Long id) {
//        EurekaCustomer eurekaCustomer = eurekaCustomerServiceService.getCustomerById(id);
//        Long eurekaCustomerId = eurekaCustomer.getId();
//        double aacountBalance = this.restTemplate.getForObject("http://localhost:9001/accounts/" + eurekaCustomerId + "/balance", Double.class);
//        eurekaCustomer.setBalance(aacountBalance);
//        return ResponseEntity.ok().body(eurekaCustomer);
//    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EurekaCustomer> getCustomerById(@PathVariable Long id) {
        try {
            EurekaCustomer eurekaCustomer = eurekaCustomerServiceService.getCustomerById(id);
            Long eurekaCustomerId = eurekaCustomer.getId();
            double accountBalance = this.restTemplate.getForObject("http://EurekaAccount-Service/accounts/" + eurekaCustomerId + "/balance", Double.class);
            eurekaCustomer.setBalance(accountBalance);
            return ResponseEntity.ok().body(eurekaCustomer);
        } catch (Exception e) {
            // Log the exception or return an appropriate error response
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PostMapping
    public ResponseEntity<EurekaCustomer> addCustomer(@RequestBody EurekaCustomer eurekaCustomer) {
        EurekaCustomer addedCustomer = eurekaCustomerServiceService.addCustomer(eurekaCustomer);
        return ResponseEntity.ok().body(addedCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EurekaCustomer> updateCustomer(@PathVariable Long id, @RequestBody EurekaCustomer eurekaCustomer) {
        EurekaCustomer updatedCustomer = eurekaCustomerServiceService.updateCustomer(id, eurekaCustomer);
        return ResponseEntity.ok().body(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        eurekaCustomerServiceService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
