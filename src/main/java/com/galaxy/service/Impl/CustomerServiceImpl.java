package com.galaxy.service.Impl;

import com.galaxy.dto.response.CustomerDtoResponse;
import com.galaxy.entity.Customer;
import com.galaxy.mapper.CustomerMapper;
import com.galaxy.repository.ICustomerRepository;
import com.galaxy.service.ICustomerService;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {


    private final ICustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDtoResponse> findAll() {
        List<Customer> customers = customerRepository.findAllCustomers();
        List<CustomerDtoResponse> customerDtoResponses;
        customerDtoResponses =  customerMapper.entitiesToDtos(customers);
        return customerDtoResponses;
    }


    @Override
    public CustomerDtoResponse findById(Long id) {
        Customer customer = customerRepository.findById(id).get();
        CustomerDtoResponse customerDtoResponse = customerMapper.entityToDto(customer);
        return customerDtoResponse;
    }
    @Override
    public void save(CustomerDtoResponse customerDtoResponse) {
        Customer customer = customerMapper.DtoToEntity(customerDtoResponse);
        customerRepository.save(customer);
    }
    @Override
    @Transactional
    public void remove(Long id) {
           customerRepository.deleteCustomerById(id);
    }
}
