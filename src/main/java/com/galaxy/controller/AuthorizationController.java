package com.galaxy.controller;

import com.galaxy.entity.Customer;
import com.galaxy.normal.Login;
import com.galaxy.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AuthorizationController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/login");
        modelAndView.addObject("login",new Login());
        modelAndView.addObject("message","");
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView getAll(@ModelAttribute (name = "login") Login login){
        ModelAndView modelAndView ;
        String email = login.getEmail();
        String password = login.getPassword();
        Customer customer = customerService.findByEmail(email);
        if(customer != null && customer.getPassword().equals(password)){
            modelAndView = new ModelAndView("/meal/list");
        }else {
            modelAndView = new ModelAndView("redirect:/home");
            modelAndView.addObject("message","đăng nhập thất bại");
        }


        return modelAndView;
    }

}
