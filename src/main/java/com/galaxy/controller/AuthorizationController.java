package com.galaxy.controller;

import com.galaxy.dto.request.CustomerDtoRequest;
import com.galaxy.dto.response.CustomerDtoResponse;
import com.galaxy.dto.response.OrderDtoResponse;
import com.galaxy.entity.Bmi;
import com.galaxy.entity.Customer;
import com.galaxy.entity.Order;
import com.galaxy.normal.Login;
import com.galaxy.normal.Register;
import com.galaxy.service.IBmiService;
import com.galaxy.service.ICustomerService;
import com.galaxy.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AuthorizationController {
    private final ICustomerService customerService;
    private final IBmiService bmiService;

    private  final IOrderService orderService;
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
    @GetMapping("/register")
    public ModelAndView registerForm(){
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("register", new Register());
        return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute (name = "register") Register register){
        ModelAndView modelAndView = new ModelAndView("/meal/list");
        Long bmiId = bmiHandler(register.getWeight(), register.getHeight());
        CustomerDtoResponse customerDtoResponse = new CustomerDtoResponse();
        BeanUtils.copyProperties(register, customerDtoResponse);
        Bmi bmi = bmiService.findById(bmiId);
        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();
        Order order = orderService.saveEntity(orderDtoResponse);
        customerDtoResponse.setBmi(bmi);
        customerDtoResponse.setOrder(order);
        customerService.save(customerDtoResponse);
        return modelAndView;
    }
    public Long bmiHandler(Double weight, Double height){
        Double result = weight * ( height * 2);
        if(result <= 18.5){
            return 1L;
        } else if(result <= 22.9){
            return 2L;
        } else if(result <= 29.9){
            return  3L;
        } else {
            return 4L;
        }
    }
}
