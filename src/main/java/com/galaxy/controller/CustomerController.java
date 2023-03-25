package com.galaxy.controller;

import com.galaxy.dto.response.CustomerDtoResponse;
import com.galaxy.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;

    @GetMapping("/customer/list")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }
    @GetMapping("/customer/edit/{id}")
    public ModelAndView FormEditCustomer(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
    @PostMapping("/customer/edit")
    public ModelAndView editCustomer(@ModelAttribute("customer") CustomerDtoResponse customerDtoResponse){
        customerService.save(customerDtoResponse);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("message", "Edit Customer Successfully");
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView CreateCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new CustomerDtoResponse());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView CreateCustomer(@ModelAttribute("customer") CustomerDtoResponse customerDtoResponse){
        customerService.save(customerDtoResponse);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("message", "Create Customer Successfully");
        return modelAndView;
    }
    @GetMapping("/customer/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        customerService.remove(id);
        return modelAndView;
    }

}
