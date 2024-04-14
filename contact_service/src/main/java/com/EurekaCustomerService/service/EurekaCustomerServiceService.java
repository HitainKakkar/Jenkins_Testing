package com.EurekaCustomerService.service;

import java.util.List;

import com.EurekaCustomerService.entity.EurekaCustomer;

public interface EurekaCustomerServiceService {
    List<EurekaCustomer> getAllCustomers();
    EurekaCustomer getCustomerById(Long id);
    EurekaCustomer addCustomer(EurekaCustomer eurekaCustomer);
    EurekaCustomer updateCustomer(Long id, EurekaCustomer eurekaCustomer);
    void deleteCustomer(Long id);
}
