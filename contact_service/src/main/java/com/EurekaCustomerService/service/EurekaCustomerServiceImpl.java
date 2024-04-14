package com.EurekaCustomerService.service;

import org.springframework.stereotype.Service;

import com.EurekaCustomerService.entity.EurekaCustomer;

import java.util.List;
import java.util.ArrayList;

@Service
public class EurekaCustomerServiceImpl implements EurekaCustomerServiceService {

    private final List<EurekaCustomer> eurekaCustomers = new ArrayList<>();

    @Override
    public List<EurekaCustomer> getAllCustomers() {
        return eurekaCustomers;
    }

    @Override
    public EurekaCustomer getCustomerById(Long id) {
        return eurekaCustomers.stream()
                        .filter(customer -> customer.getId().equals(id))
                        .findFirst()
                        .orElse(null);
    }

    @Override
    public EurekaCustomer addCustomer(EurekaCustomer eurekaCustomer) {
        eurekaCustomers.add(eurekaCustomer);
        return eurekaCustomer;
    }

    @Override
    public EurekaCustomer updateCustomer(Long id, EurekaCustomer updatedCustomer) {
        for (int i = 0; i < eurekaCustomers.size(); i++) {
            if (eurekaCustomers.get(i).getId().equals(id)) {
                eurekaCustomers.set(i, updatedCustomer);
                return updatedCustomer;
            }
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        eurekaCustomers.removeIf(customer -> customer.getId().equals(id));
        // Call account management service to delete associated account
        // accountManagementService.deleteAccountByCustomerId(id);
    }
}
